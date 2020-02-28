package com.webjjang.qna.service;

import java.util.List;

import com.webjjang.main.Service;
import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.qna.dto.QnaDTO;
import com.webjjang.util.page.PageObject;

public class QnaListService implements Service {

	private final QnaDAO dao;
	
	public QnaListService(QnaDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<QnaDTO> service(Object objs[]) throws Exception{
		// 데이터 변환
		PageObject pageObject = (PageObject) objs[0];
		// 데이터 처리부분에 해당된다.
				
		
		System.out.println("QnaListService.service()");
		
		// 데이터를 오라클에서 가져오기 위해서 객체를 생성하고 호출한다.
		// QnaController - QnaListService - [QnaDAO]
		return dao.list(pageObject);
	}
	
}
