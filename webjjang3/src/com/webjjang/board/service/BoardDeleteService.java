package com.webjjang.board.service;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.main.Service;

public class BoardDeleteService implements Service {

	
	private final BoardDAO dao;

	public BoardDeleteService(BoardDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao=dao;
	}
	@Override
	// 데이터 Controller <-> service - DAO
	// 입력받은 글번호(BoardDTO)를 Controller 에서 받아서 처리한다.
	public Integer service(Object[] objs)  throws Exception{		
		// 데이터 처리부분에 해당된다.
		int no = (int) objs[0];
		System.out.println("BoardDeleteService.service()");
		// 게시판 글삭제에서 오류가 나고 있다는 처리를 할때 예외처리를 해준다.
		// - 예외가 발생이되면 알맞은 메시지로 바꿔서 던진다.
			return dao.delete(no);

	}
	
}
