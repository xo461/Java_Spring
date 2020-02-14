package com.webjjang.notice.service;


import com.webjjang.main.Service;
import com.webjjang.notice.dao.NoticeDAO;
import com.webjjang.notice.dto.NoticeDTO;

public class NoticeWriteService implements Service {

	// 데이터 Controller <-> DAO
	// 입력받은 글(BoardDTO)를 Controller 에서 받아서 처리한다.
	
	private final NoticeDAO dao;
	
	public NoticeWriteService(NoticeDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao=dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception{
		// 데이터 처리부분에 해당된다.
		System.out.println("NoticeWriteService.service()");
		NoticeDTO dto = (NoticeDTO) objs[0];
		// 게시판 글쓰기에서 오류가 나고 있다는 처리를 할때 예외처리를 해준다.
		// - 예외가 발생이되면 알맞은 메시지로 바꿔서 던진다.
		try {
			// 데이터Controller에서 오라클에 저장하기 위해서 객체를 생성하고 호출한다.
			// BoardController - BoardWriteService - [BoardDAO]
			dao.write(dto);
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			// 상세한 내용의 예의메시지를 셋팅해서 다시 던지기를 할 수 있다.
			throw new Exception("게시판 글쓰기 중 오류가 발생되었습니다.");
		}
	}
	
}
