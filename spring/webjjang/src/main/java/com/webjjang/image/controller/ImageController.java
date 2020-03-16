package com.webjjang.image.controller;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.webjjang.image.dto.ImageDTO;
import com.webjjang.image.service.ImageService;
import com.webjjang.util.file.FileUtil;
import com.webjjang.util.page.PageObject;

//dispatcherservlet이 하는일:
//1. new ImageDTO dto = ImageDtO; 생성한다.
//2. 변수기본값셋팅
//3. 받은데이터와 매칭이 되는 property에 값을 넣어준다.

@Controller
//@Log4j
@RequestMapping("/image")
//@AllArgsConstructor //생성자에 의해서 멤버 변수를 초기화시키는 작업을 한다. 근데 클래스가 없는 멤버변수같은 경우에도 주입해줄수있어서 오류날수 있고, 변수가 다른 클래스를 상속받은거면 bean이 두개가 되어, 이걸 안쓰고 주입필요한 멤버변수에만 @autowired/@inject를 써주기도 한다.
public class ImageController {

	@Autowired
	@Qualifier("is")
	//imageserviceImpl이 Imageservice상속받으므로 imagecontroller에서 imageservice 변수선언시 bean이 imageservice와 imageserviceimpl 두개 가 된다 ->  같은 타입의 빈이 두 개 이상이 존재하는 경우에 스프링이 어떤 빈을 주입해야 할지 알 수 없어서 스프링 컨테이너를 초기화하는 과정에서 예외를 발생시킨다.
	//이 경우 @Qualifier을 @Autowired와 함께 사용하여 정확히 어떤 bean을 사용할지 지정하여 특정 의존 객체를 주입할 수 있도록 한다. (해당 서비스에도 @Qualifier("같은이름")어노테이션 써줘야함)
	private ImageService service;
	private final String module = "image";

	//1. 이미지 게시판 리스트
	@GetMapping("/list.do")
	public String list(Model model, PageObject pageObject) { //PageObject타입의 pageObject변수명으로 parameter받겠다.
		//이미지게시판은 8개씩 보이게 하자.
		//pageObject를 model에 담기 전에 셋팅해야 한다.
		//한줄에 나타나는 이미지개수 4개 * 2줄 = 총 보이는 이미지 개수 8개
		pageObject.setPerPageNum(8);
		
		model.addAttribute("list", service.list(pageObject));
		model.addAttribute("pageObject", pageObject);
		return module + "/list";
	}

	//2. 이미지 게시판 글보기
	@GetMapping("/view.do")
	public String view(Model model, int no) {
		model.addAttribute("dto", service.view(no));
		return module + "/view";
	}
	
	//3. 이미지  게시판 글쓰기폼
	@GetMapping("/write.do")
	public String writeForm() {
		return module + "/write";
	}
	
	//3-1. 이미지 게시판 글쓰기 처리
	//로그인: httpsession 파라메터로 받으면 - dispatcherservlet이 세션을 가져다준다.
	@PostMapping("/write.do")
	public String write(ImageDTO dto, MultipartFile multiFile, HttpSession session, HttpServletRequest request) throws Exception {
		System.out.println("dto"+dto);
		//★ dto에 먼저 담은 뒤에 service처리해야 한다. 순서 중요. 
		//있는 id로 강제로그인처리 
		dto.setId("test");
		
		//파일은 dto property로 받아지지 않음 -> multipartFile로 따로 받은 뒤 dto에 저장한다.
		dto.setMultiFile(multiFile);
		
		//1.서버경로 받기
		//현재 서비스가 돌아가고 있는 서버의 웹서비스 디렉토리의 물리적 경로를 구하기(여기에 업로드함)
		//방법: Httpservletrequest.getServletContext().getRealPath
		String realPath = request.getServletContext().getRealPath("/upload/image");
		
		//2.서버경로+파일명 조립해서 만들기
		//Fileutil에 파일명중복방지 메소드 사용
		//D:\Workspace\spring\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\webjjang\ upload\image\cutie1.jpg
		File saveFile = FileUtil.removeDuplicateFileName(realPath, multiFile.getOriginalFilename());//(경로,원본파일명) 두개 합쳐서 업로드되는 파일경로만들어준다.
		System.out.println("saveFile: "+saveFile);

		//3.db에 저장할 파일명 셋팅
		//하위경로+원본파일명 저장 : /upload/image/cutie.jpg
		dto.setFileName("/upload/image/"+saveFile.getName());

		//4. 업로드요청받은파일을 (경로)에 저장.
		multiFile.transferTo(saveFile);
		
		service.write(dto);
		return "redirect:list.do";
	}

	//4. 이미지 게시판 글수정 폼(사용자에게 보내줄 데이터 model로 받아오고, 수정할 글번호는 사용자한테서 받아온다.)
	@GetMapping("/update.do")
	public String updateForm(Model model, int no) {
		//view에 있는 글정보를 "dto"키에 담아서 뷰로 넘긴다.
		model.addAttribute("dto", service.view(no));
		return module + "/update";
	}
	
	//4-1. 이미지 게시판 수정 처리(사용자가 수정한 데이터 dto로 받는다.)
	@PostMapping("/update.do")
	public String update(ImageDTO dto) {
		int result = service.update(dto); //글수정 성공시 1 리턴, 실패시 0 리턴
		if(result > 0)//성공적으로 수정되어 1이 리턴되면
			return "redirect:view.do?no="+dto.getNo();
		else 
			return "error/error_pw"; //오류페이지jsp로 이동 
	}
	
	//5. 이미지 게시판 글삭제(글번호, 비밀번호 필수로 받는다.-->따로받으면 번거로우므로 dto로 함께 받는다.)
	//비밀번호때문에 post로 넘겨야함.->ajax나 formtag로 넘겨야 한다.
	@PostMapping("/delete.do")
	public String delete(ImageDTO dto) {
		service.delete(dto);
		return "redirect:list.do";
	}
}
