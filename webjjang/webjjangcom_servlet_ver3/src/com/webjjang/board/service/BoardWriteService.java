package com.webjjang.board.service;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.dto.BoardDTO;
import com.webjjang.main.Service;

public class BoardWriteService implements Service {

	private final BoardDAO dao;
	
	public BoardWriteService(BoardDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao=dao;
	}
	
	// 데이터 Controller <-> DAO
	// 입력받은 글(BoardDTO)를 Controller 에서 받아서 처리한다.
	@Override
	public Integer service(Object[] objs) throws Exception{
		// 데이터 처리부분에 해당된다.
		BoardDTO dto = (BoardDTO) objs[0];
		System.out.println("BoardWriteService.service()");

		// 게시판 글쓰기에서 오류가 나고 있다는 처리를 할때 예외처리를 해준다.
		// - 예외가 발생이되면 알맞은 메시지로 바꿔서 던진다.
		try {
			// 데이터Controller에서 오라클에 저장하기 위해서 객체를 생성하고 호출한다.
			// BoardController - BoardWriteService - [BoardDAO]
			return dao.write(dto);

		} catch (Exception e) {
			// TODO: handle exception
			// 상세한 내용의 예의메시지를 셋팅해서 다시 던지기를 할 수 있다.
			throw e;
		}
	}
	
}
