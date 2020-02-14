package com.webjjang.qna.service;

import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.qna.dto.QnaDTO;

public class QnaAnswerService {

	// 데이터 Controller <-> DAO
	// 입력받은 글(QnaDTO)를 Controller 에서 받아서 처리한다.
	public void service(QnaDTO dto) throws Exception{
		// 데이터 처리부분에 해당된다.
		System.out.println("QnaAnserService.service()");
		
		// 질문답변기에서 오류가 나고 있다는 처리를 할때 예외처리를 해준다.
		// - 예외가 발생이되면 알맞은 메시지로 바꿔서 던진다.
		try {
			// 데이터Controller에서 오라클에 저장하기 위해서 객체를 생성하고 호출한다.
			// QnaController - QnaWriteService - [QnaDAO]
			QnaDAO dao = new QnaDAO();
			//관련글 번호가 같으면서 순서번호가 들어온 순서번호보다 크거나 같으면 +1 해줘야 한다.
			//
			dao.increaseOrdNo(dto);
			// 답변 데이터 처리
			dao.answer(dto);
		} catch (Exception e) {
			// TODO: handle exception
			// 상세한 내용의 예의메시지를 셋팅해서 다시 던지기를 할 수 있다.
			throw new Exception("게시판 글쓰기 중 오류가 발생되었습니다.");
		}
	}
	
}
