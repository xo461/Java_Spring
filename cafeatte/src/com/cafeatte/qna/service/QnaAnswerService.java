package com.cafeatte.qna.service;

import com.cafeatte.main.Service;
import com.cafeatte.qna.dao.QnaDAO;
import com.cafeatte.qna.dto.QnaDTO;

public class QnaAnswerService implements Service{

	private QnaDAO dao;
	
	public QnaAnswerService(QnaDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}

	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QnaAnswerService.service() : "+ objs[0]);
		QnaDTO dto = (QnaDTO) objs[0];
		try {
			// 관련글 번호 가 같으면서 순서번호가 들어온 순서번호 보다 크거나 같으면 +1해줘야한다. 
			dao.increaseOrdNo(dto);

			// 답변데이터 처리 
			dao.answer(dto);
			
			return null;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("질문답변 답변 중 오류 발생 되었습니다.");
		}
	}
}

