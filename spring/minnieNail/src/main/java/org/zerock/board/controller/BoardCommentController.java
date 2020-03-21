package org.zerock.board.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.board.dto.Board_repDTO;
import org.zerock.board.dto.Board_rep_likeDTO;
import org.zerock.board.service.BoardCommentService;
import org.zerock.board.service.BoardService;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
@RequestMapping("/bcomment")
public class BoardCommentController {

	@Resource(name = "org.zerock.board.service.BoardCommentService")
	BoardCommentService bcService;
	
	// 댓글리스트************
	@RequestMapping("/list.do")
	@ResponseBody
	private Map<String, Object> bCommentList(int no, int id, Model model) throws Exception {
		// System.out.println("BoardCommentController.bCommentList.no: " + no);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("repdto", bcService.commentList(no));
		map.put("likeDislike", bcService.likeDislike())
		return map; // 리스트로 반환
	
	}

	// 댓글삽입***************
	@RequestMapping("/insert.do")
	@ResponseBody
	private int bCommentInsert(Board_repDTO dto) throws Exception {

		/*
		 * //넘어오는 값 확인 Enumeration params = request.getParameterNames();
		 * System.out.println("----------------------------"); while
		 * (params.hasMoreElements()){ String name = (String)params.nextElement();
		 * System.out.println(name + " : " +request.getParameter(name)); }
		 * System.out.println("----------------------------");
		 */

		System.out.println("BoardController.insertAComment().넘어오는값:" + dto);
		return bcService.commentInsert(dto);
	}

	@RequestMapping("/update.do") // 댓글 수정
	@ResponseBody
	private int bCommentUpdate(Board_repDTO dto) throws Exception {
		return bcService.commentUpdate(dto);
	}

	@RequestMapping("/delete/{rep_no}.do") // 댓글 삭제
	@ResponseBody
	// @pathvariable: bcoment/delete/댓글번호.do 주소에 있는 변수(댓글번호) 받는것. 이름 같으면 맵핑된다.
	private int bCommentDelete(@PathVariable int rep_no) throws Exception {
		return bcService.commentDelete(rep_no);
	}

	// 좋아요싫어요버튼클릭시
	// 넘어오는값: 좋아요버튼 클릭시likedislike=0, 싫어요 버튼 클릭시likedislike=1:
	// 리턴값: 좋아요나싫어요 추가 성공시 1, 이미좋아요 2, 이미싫어요 3리턴
	@RequestMapping("/increaselike.do")
	@ResponseBody
	//json으로 받는거 맵핑시키려면 콘트롤러에서는 @requestyBody써줘야하고 뷰에서는 contenttype:application/json으로 하고 data는 JSON.stringify()로 문자열화해야 한다.
	private int Like(@RequestBody Board_rep_likeDTO dto) throws Exception {
		System.out.println("BoardCommentCOntroller.Like().dto: "+dto);
		return bcService.ifLike(dto); 
	}

}
