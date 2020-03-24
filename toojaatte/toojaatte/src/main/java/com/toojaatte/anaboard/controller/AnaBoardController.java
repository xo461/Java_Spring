package com.toojaatte.anaboard.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.toojaatte.anaboard.dto.AnaBoardDTO;
import com.toojaatte.anaboard.dto.AnaBoard_FileDTO;
import com.toojaatte.anaboard.service.AnaBoardService;
import com.toojaatte.util.file.FileUtil;
import com.toojaatte.util.page.PageObject;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j 
@RequestMapping("/anaboard")
public class AnaBoardController {
	@Autowired
	@Qualifier("as") //BoardService의 @Qualifier("bs")이름과 맞춘다.
	private AnaBoardService service;
	
	private final String MODULE = "anaboard";
	
	//1.게시판 리스트
	@GetMapping("/list.do") //RequestMapping + GetMapping
	public String list(Model model, PageObject pageObject, HttpServletRequest request){
		// 검색에 대한 데이터 셋팅
		String word = request.getParameter("word");
		String key = request.getParameter("key");
		String gradeNoType = request.getParameter("gradeNoType");
		String orderType = request.getParameter("orderType");
		System.out.println("*********"+ word);
		System.out.println("*********"+ key);
		System.out.println("*********"+ gradeNoType);
		System.out.println("*********"+ orderType);

		if (!StringUtils.isEmpty(word)) {
			pageObject.setSearch(request.getParameter("key"), request.getParameter("word"));
		}
		if (!StringUtils.isEmpty(gradeNoType)) {
			pageObject.setGradeNoType(request.getParameter("gradeNoType"));
		}
		if (!StringUtils.isEmpty(orderType)) {
			pageObject.setOrderType(request.getParameter("orderType"));
		}
		
		System.out.println(pageObject.toString());
		//DB에서 데이터 가져오기 -> 페이지 계산, JSP에서 표시할 페이지네이션 정보가 계산된다.
		model.addAttribute("list", service.list(pageObject));
		model.addAttribute("pageObject", pageObject);
		return MODULE + "/list";
	}
	//2.게시판 글보기
	@GetMapping("/view.do")
	public String view(Model model, int no, HttpSession session) {
		model.addAttribute("dto", service.view(no));
		model.addAttribute("login", session.getAttribute("login"));
		return MODULE + "/view";
	}
	//3-1.게시판 글쓰기폼
	@GetMapping("/write.do")
	public String writeForm(){
		return MODULE + "/write";
	}
	//3-2.게시판 글쓰기 처리
	@PostMapping("/write.do")
	public String write(AnaBoardDTO dto, AnaBoard_FileDTO fdto,
			MultipartFile[] multiFile, HttpSession session,
			HttpServletRequest request)throws Exception {
//로그인 적용 -> 지금은 테스트 중이니 강제 실행
		//dto.setId(((LoginDTO)session.getAttribute("login")).getId());
		dto.setId("test");
		System.out.println("******* session.getId() : "+dto.getId());
		
		File saveFile;
		dto.setMultiFile(multiFile);
		System.out.println("*******multiFile.length : "+dto.getMultiFile().length);

		service.write(dto);
		
		for(int i=0; i<multiFile.length; i++) {
			//DB에 저장할 파일 이름 셋팅
			String realPath = request.getServletContext().getRealPath("/upload/image");
			saveFile = FileUtil.removeDuplicateFileName(realPath, multiFile[i].getOriginalFilename());
			System.out.println("***********getNo():"+dto.getNo());
			fdto.setNo(dto.getNo());
			fdto.setFileName("/upload/image/" + saveFile.getName());
			fdto.setOri_fileName(multiFile[i].getOriginalFilename());
			System.out.println("***********setFileName():"+fdto.getFileName());
			System.out.println("***********setOriFileName():"+fdto.getOri_fileName());
			service.writeFile(fdto);
			multiFile[i].transferTo(saveFile);
		}

		// 자동으로 list로 이동
		return "redirect:list.do";
	}
	//4-1.게시판 글수정폼
	@GetMapping("/update.do")
	public String updateForm(Model model, int no) {
		model.addAttribute("dto", service.view(no));
		return MODULE + "/update";
	}
	//4-2.게시판 글수정 처리 - 전체 데이터
	@PostMapping("/update.do")
	public String update(AnaBoardDTO dto) {
		int result = service.update(dto);
		if(result > 0)
			// 자동으로 view로 이동
			return "redirect:view.do?no=" + dto.getNo();
		else
			// 오류 보여주는 jsp 페이지로 이동
			return "error/error_pw";
	}
	//5.게시판 글삭제 처리 - 글번호
	@GetMapping("/delete.do")
	public String delete(AnaBoardDTO dto, HttpSession session,
			HttpServletRequest request)throws Exception {
		dto.setNo(Integer.parseInt(request.getParameter("no")));
//		dto.setId(((LoginDTO)session.getAttribute("login")).getId());
		dto.setId("test");
		service.delete(dto);
		String page = request.getParameter("page");
		String word = request.getParameter("word");
		String key = request.getParameter("key");
		String gradeNoType = request.getParameter("gradeNoType");
		String orderType = request.getParameter("orderType");
		
//		String realPath = request.getServletContext().getRealPath("/upload/image");
//		FileUtil.deleteFile(FileUtil.realPath(request, request.getParameter("deleteFile1")));
//		FileUtil.deleteFile(FileUtil.realPath(request, request.getParameter("deleteFile2")));
//		FileUtil.deleteFile(FileUtil.realPath(request, request.getParameter("deleteFile3")));
		return "redirect:list.do?page="+page
				+"&key="+key
				+"&word="+word
				+"&gradeNoType="+gradeNoType
				+"&orderType="+orderType;
	}
}
