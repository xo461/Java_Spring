package com.webjjang.board.service;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.dto.BoardReplyDTO;
import com.webjjang.main.Service;

public class BoardReplyUpdateService implements Service{

	private final BoardDAO dao;
	
	public BoardReplyUpdateService(BoardDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao=dao;
	}
	
	// 데이터 Controller <-> DAO
	// 입력받은 글(BoardDTO)를 Controller 에서 받아서 처리한다.
	@Override
	public Object service(Object[] objs) throws Exception{
		// 데이터 처리부분에 해당된다.
		System.out.println("BoardReplyUpdateService.service()");
		
		// 게시판 글쓰기에서 오류가 나고 있다는 처리를 할때 예외처리를 해준다.
		// - 예외가 발생이되면 알맞은 메시지로 바꿔서 던진다.
		try {
			// 데이터Controller에서 오라클에 저장하기 위해서 객체를 생성하고 호출한다.
			// BoardController - BoardWriteService - [BoardDAO]
			dao.replyUpdate((BoardReplyDTO) objs[0]);
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			// 상세한 내용의 예의메시지를 셋팅해서 다시 던지기를 할 수 있다.
		// 사용자를 위한 예외처리
			//	throw new Exception("게시판 글쓰기 중 오류가 발생되었습니다.");
		// 개발자를 위한 예외처리
			throw new Exception("게시판 댓글 수정 중 오류가 발생하였습니다.");
			
		}
	}


	
}
