package com.webjjang.image.controller;

import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.webjjang.image.dto.ImageDTO;
import com.webjjang.main.Controller;
import com.webjjang.main.Execute;
import com.webjjang.main.Service;
import com.webjjang.util.ImageResizing;
import com.webjjang.util.io.FileUtil;
import com.webjjang.util.page.PageObject;

//static메소드인 굥우 static import를 사용해서 메소드까지 지정해놓으면 메소드만 사용할 수 있다.

public class ImageController implements Controller {


	//실행에 필요한 객체 선언 (컨트롤러 상속받아서 타입은 Sevice로)
	private Service listService;
	private Service viewService;
	private Service writeService;
	private Service updateService;
	private Service deleteService;
	
	//생성자 만들어서 파라메터로 받기 (service DI 적용 -> beans에서 생성 후 넣어준다.)
	public ImageController(
			Service listService, 
			Service viewService,
			Service writeService, 
			Service updateService,
			Service deleteService) {
		// TODO Auto-generated constructor stub
		
		//생성자에서 받아온것
		this.listService = listService;
		this.viewService = viewService;
		this.writeService = writeService;
		this.updateService = updateService;
		this.deleteService = deleteService;
	
	}
	
	// **** 첨부파일에서 사용되는 변수
	// 로그인 정보에서 아이디를 받는다. - 현재는 강제로그인.
	String id = "test";
	// 이미지 파일이 들어 있는 데이터 받기 처리
	// 첨부파일의 용량제한
	int size = 100*1024*1024;
	// 파일을 업로드할 웹의 위치 - 사이트 메시의 적용을 받지 않는 위치
	String path = "/upload/image/";
	
	// 글번호 변수
	String noStr = "";
	// 한페이지에 표시할 데이터의 갯수
	String perPageNumStr = "";
	
	// 데이터 수정이나 삭제 시 지워야할 파일
	String deleteFileName = null;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {
		// TODO Auto-generated method stub
		
		// 공통으로 사용되는 변수
		String jsp = "";
		PageObject pageObject = PageObject.getInstance(request.getParameter("page"),
				request.getParameter("perPageNum"));
		
		// 검색에 대한 셋팅
		String key = request.getParameter("key");
		String word = request.getParameter("word");
		if (word != null) {
			pageObject.setKey(key);
			pageObject.setWord(word);
		}
		
		int no;
		String title, content; 
		
		// jsp에서 자바 부분을 여기에 넣는다.
		switch (uri) {
		case "/image/list.do":
			request.setAttribute("pageObject", pageObject);
			request.setAttribute("list", Execute.service(listService, pageObject));
			jsp ="image/list";
			break;
			
		case "/image/view.do":
			//request에 실행한 결과값을 저장 -> jsp에서 꺼내 쓴다. 
			request.setAttribute("dto", Execute.service(viewService, Integer.parseInt(request.getParameter("no"))));
			jsp ="image/view";
			//frontcontroller에서 forward시킨다. 
//			request.getRequestDispatcher(jsp).forward(request, response);
			break;
			
		case "/image/writeForm.do":
			jsp = "image/writeForm";
			break;
			
		case "/image/write.do":
			// 로그인 정보에서 아이디를 받는다.
			// 파일을 업로드할 서버의 절대위치 : 하드디스트의 위치
//			String uploadPath = request.getServletContext().getRealPath(path);
//			System.out.println(uploadPath);
//			// new MultipartRequest(request, 파일이올라간하드디스크의위치와파일명, 용량제한, 엔코딩, 중복처리프로그램)
//			MultipartRequest multi = new MultipartRequest(request, uploadPath,
//					size, "utf-8",	new DefaultFileRenamePolicy());
//
//			// DB에 저장할 첨부파일 정보 : 웹위치+서버의파일명 (파일의 정보를 데이터베이스에 올릴수있도록
//			String fileName = path + multi.getFilesystemName("fileName");
//			System.out.println("ImageController.execute().fileName:" + fileName);
//			
			// 데이터를 받아 dto를 만든 후 서비스에 전달해서 DB에 글쓰기를 한다.
			// multi 이름 만들어서 써준뒤부터는 request.getParameter를 쓸 수 없고 무조건 multi.getParameter로 써줘야 한다.
			Execute.service(writeService, 
					getDTO(request));
			// 자동으로 리스트로 이동시켜야 한다.
			jsp ="redirect:list.do?page=1&perPageNum="
//					+multi.getParameter("perPageNum");
					+perPageNumStr;
			break;
		
			
		case "/image/updateForm.do":
			request.setAttribute("dto", Execute.service(viewService, Integer.parseInt(request.getParameter("no"))));
			//frontcontroller에서 forward시킨다. 
//			request.getRequestDispatcher(jsp).forward(request, response);
			jsp = "image/updateForm";
			break;
		
		case "/image/update.do":
			
			ImageDTO dto = getDTO(request);
			
			// 데이터를 받아 dto를 만든 후 서비스에 전달해서 DB에 글수정를 한다.
			Execute.service(updateService, dto);
			
			//전달된 첨부 파일이 있는 경우는 이미지 교체를 해야 하므로 원래있던 파일을 지운다.
			if(dto.getFileName() !=null)
				FileUtil.deleteFile(FileUtil.realPath(request, deleteFileName));
				
			// 자동으로 리스트로 이동시켜야 한다.
			jsp ="redirect:view.do?no=" + noStr
					+ "&page=" + pageObject.getPage()
					+ "&perPageNum=" + pageObject.getPerPageNum()
					+ ((pageObject.getWord() != null && !pageObject.getWord().equals(""))
					  ? "&key="+pageObject.getKey() 
					  	+ "&word=" 
					  	// 서버의 한글코드가  ISO-8859-1를 사용하므로 맞지 않으므로
					  	//  데이터를 꺼내서 붙이면 코드 변환 문제를 해결해야한다.
					  	// 검색어가 한글이 경우 엔코딩해서 넘긴다.
					    + URLEncoder.encode(pageObject.getWord(),"utf-8"):"");
			System.out.println("ImageController.execute().jsp:"+jsp);
			break;
			
			
			
			//이미지게시판 글삭제
			case "/image/delete.do":
				// -> 반드시 리스트에서 부터 들어와야 한다.
				Execute.service(deleteService, Integer.parseInt(request.getParameter("no")));
				// 서버에 올린 파일 지우기
				FileUtil.deleteFile(FileUtil.realPath(request,
						request.getParameter("deleteFile")));
				// 자동으로 리스트로 이동시켜야 한다.
				jsp ="redirect:list.do?page=1&perPageNum="
						+request.getParameter("perPageNum");
				break;
				
			
			
		default:
			break;
		}
		System.out.println("ImageController.execute().jsp");
		return jsp;
		
	}
	// 주로 글쓰기할때 사용되는 메서드
	private ImageDTO getDTO(String title, String content, 
			String id, String fileName) {
		ImageDTO dto = new ImageDTO();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setId(id);
		// 이미지 등록 시 에는 반드시 입력되어야 한다.
		// 그러나 수정 시에는 이미지를 그대로 사용하고자 할때는 변경되지 않는다. -> 데이터가 들어오지 않는다.
		if(fileName != null && !fileName.equals("") 
				&& !fileName.equals(path+"null"))
			dto.setFileName(fileName);
		return dto;
	}
	
	// 주로 글수정할때 사용되는 메서드
	private ImageDTO getDTO(int no, String title,
			String content, String id, String fileName) {
		ImageDTO dto = getDTO(title, content, id, fileName);
		dto.setNo(no);
		return dto;
	}
	
	// 쓰기나 수정하는 경우 이 메서드부터 시작이된다. -> no가 있으면 수정, 없으면 쓰기
	private ImageDTO getDTO(HttpServletRequest request) throws Exception {
		// 파일을 업로드할 서버의 절대위치 : 하드디스트의 위치
		String uploadPath = FileUtil.realPath(request, path);
		System.out.println(uploadPath);
		// new MultipartRequest(request, 파일이올라간하드디스크의위치와파일명, 용량제한, 엔코딩, 중복처리프로그램)
		MultipartRequest multi = new MultipartRequest(request, uploadPath,
				size, "utf-8",	new DefaultFileRenamePolicy());

		// DB에 저장할 첨부파일 정보 : 웹위치+서버의파일명
		String fileName = path + multi.getFilesystemName("fileName");
		System.out.println("ImageController.execute().fileName:" + fileName);
		
		
		// 저장된 파일 사이즈를 줄여서 리스트에 표시하기 위한 파일로 복사 -> dog01.jpg = s_dog01.jpg
		// webjjangma 카페에서 업로드 검색 리사이징 프로그램 참조 + 라이브러리 등록해서 사용
		//ImageResizing.imageResizing(realpath, 이미지 파일명, 앞첨자, 너비, 높이);
		//첨부파일이 있는 경우만 처리한다. 첨부가 없는 경우 fileName
		if(fileName != null && !fileName.equals("") && !fileName.equals(path + "null"))
		ImageResizing.imageResizing(uploadPath, multi.getFilesystemName("fileName"), "s_", 300);
		
		// 한페이지에 표시할 데이터의 갯수
		perPageNumStr = multi.getParameter("perPageNum");

		noStr = multi.getParameter("no");

		// 글번호가 들어오면 - 업데이터(수정)
		if(noStr != null && !noStr.equals("")) {
			// 원래의 파일명을 셋팅한다.
			deleteFileName = multi.getParameter("deleteFile");
			return getDTO(Integer.parseInt(noStr),
					multi.getParameter("title"),
					multi.getParameter("content"), id, fileName);
		}
		// 글번호가 들어오지 않으면 - 글쓰기
		return getDTO(multi.getParameter("title"),
				multi.getParameter("content"), id, fileName);
	}
}
