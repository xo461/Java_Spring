package org.zerock.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.board.dto.Board_repDTO;
import org.zerock.board.dto.Board_rep_likeDTO;
import org.zerock.board.service.BoardCommentService;
import org.zerock.util.filter.ConvertJson;

@Controller
@RequestMapping("/bcomment")
public class BoardCommentController {

	@Resource(name = "org.zerock.board.service.BoardCommentService")
	BoardCommentService bcService;
	
	// 댓글리스트************
	@RequestMapping("/list.do")
	@ResponseBody
	public Map<String, Object> bCommentList(int no, Integer id, Model model) throws Exception {
		System.out.println("BoardCommentController.bCommentList.id: " + id);
		Map<String, Object> map = new HashMap<String, Object>();
		
		//댓글리스트 가져오기
		map.put("repdto", bcService.commentList(no));
		//로그인 안되어있으면 id안넘옴.-> null값이 넘어오면 int는 처리 불가능한반면 integer는 0으로 바꿔준다.
		//로그인되어있으면: 댓글좋아요 목록 가져오기. 댓글리스트 로드할때 내가 한 좋아요 싫어요가 표시된다.
		if(id!=null) {
			map.put("repLikeDto", bcService.commentLikeList(no, id));
		}
		System.out.println(map);
		return map; // 댓글리스트, 댓글좋아요리스트(로그인안되어있으면 undefined) 반환
	
	}

	// 댓글삽입***************
	@RequestMapping("/insert.do")
	@ResponseBody
	public int bCommentInsert(Board_repDTO dto) throws Exception {

		/*
		 * //넘어오는 값 확인 Enumeration params = request.getParameterNames();
		 * System.out.println("----------------------------"); while
		 * (params.hasMoreElements()){ String name = (String)params.nextElement();
		 * System.out.println(name + " : " +request.getParameter(name)); }
		 * System.out.println("----------------------------");
		 */

		System.out.println("BoardCommentController.insertAComment().넘어오는값:" + dto);
		return bcService.commentInsert(dto);
	}

	@RequestMapping("/update.do") // 댓글 수정
	@ResponseBody
	public int bCommentUpdate(Board_repDTO dto) throws Exception {
		return bcService.commentUpdate(dto);
	}

	@RequestMapping("/delete/{rep_no}.do") // 댓글 삭제
	@ResponseBody
	// @pathvariable: bcoment/delete/댓글번호.do 주소에 있는 변수(댓글번호) 받는것. 이름 같으면 맵핑된다.
	public int bCommentDelete(@PathVariable int rep_no) throws Exception {
		return bcService.commentDelete(rep_no);
	}

	// 좋아요싫어요버튼클릭시
	// 넘어오는값: 좋아요버튼 클릭시likedislike=0, 싫어요 버튼 클릭시likedislike=1
	// 리턴값: 좋아요나싫어요 추가 성공시 1, 이미좋아요 2, 이미싫어요 3리턴
	@RequestMapping(value = "/increaselike.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	//json으로 받는거 맵핑시키려면 콘트롤러에서는 @requestyBody써줘야하고 뷰에서는 contenttype:application/json으로 하고 data는 JSON.stringify()로 문자열화해야 한다.
	public int Like(@RequestBody String filterJSON) throws Exception {

        Map<String, Object> map = ConvertJson.convertJsonToObject(filterJSON);
        
        System.out.println("BoardCommentCOntroller.Like().map: "+map);
        
        Board_rep_likeDTO dto = new Board_rep_likeDTO();
		dto.setId(Integer.parseInt(map.get("id").toString()));
		dto.setNo(Integer.parseInt(map.get("no").toString()));
		dto.setRep_no(Integer.parseInt(map.get("rep_no").toString()));
		int likeDislike = Integer.parseInt(map.get("likeDislike").toString());
	
		System.out.println("BoardCommentCOntroller.Like().dto: "+dto);
		System.out.println("BoardCommentCOntroller.Like().likeDislike: "+likeDislike);
		System.out.println("BoardCommentCOntroller.Like().리턴값:"+bcService.ifLike(dto, likeDislike));
		return bcService.ifLike(dto, likeDislike); //좋아요나싫어요 추가 성공시 1, 이미좋아요 2, 이미싫어요 3리턴
	}

}
