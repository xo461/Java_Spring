package com.webjjang.board.service;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.main.Service;

public class BoardViewService implements Service {


	// 데이터 Controller <-> DAO
	// 글번호를 Controller 에서 받아서 처리한다.
	private final BoardDAO dao;
	
	//생성자로 넣어야 편함 저장하려는 dao타입을 파라메터()안에 받음
	public BoardViewService(BoardDAO dao) {
		this.dao = dao;
	}
	

	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		
		int no = (int)objs[0];
		int cnt = (int)objs[1];
		
		System.out.println("BoardViewService.service()");
		

		// 데이터를 오라클에서 가져오기 위해서 객체를 생성하고 호출한다.
		// BoardController - BoardViewService - [BoardDAO]
		// cnt는 1 또는 0으로 판단만 하는 걸로 만듦. cnt가 1이면 조회수 증가시켜라.
		if(cnt ==1) dao.increaseHit(no);
		return dao.view(no);
		
	
	}


	
}
