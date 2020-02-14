package com.webjjang.qna.service;

import com.webjjang.main.Service;
import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.qna.dto.QnaDTO;

public class QnaUpdateService implements Service{

	private QnaDAO dao;
	public QnaUpdateService(QnaDAO dao) {
		this.dao = dao;
	
		// TODO Auto-generated constructor stub
	}

	// 데이터 Controller <-> DAO
	// 입력받은 글(QnaDTO)를 Controller 에서 받아서 처리한다.
	public Integer service(Object objs[]) throws Exception{
		// 데이터 처리부분에 해당된다.
		System.out.println("QnaUpdateService.service()");
		
		QnaDTO dto = (QnaDTO)objs[0];
		
		// 질문답변 게시판 글쓰기에서 오류가 나고 있다는 처리를 할때 예외처리를 해준다.
		// - 예외가 발생이되면 알맞은 메시지로 바꿔서 던진다.
		try {
			// 데이터Controller에서 오라클에 저장하기 위해서 객체를 생성하고 호출한다.
			// QnaController - QnaWriteService - [QnaDAO]
			return dao.update(dto);
			
		} catch (Exception e) {
			// TODO: handle exception
			// 상세한 내용의 예의메시지를 셋팅해서 다시 던지기를 할 수 있다.
		// 사용자를 위한 예외처리
			e.printStackTrace();
				throw new Exception("질문답변 수정 중 오류가 발생되었습니다.");
		// 개발자를 위한 예외처리
//			throw e;
			
		}
	}
	
}
