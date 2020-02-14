package com.webjjang.image.service;

import com.webjjang.image.dao.ImageDAO;
import com.webjjang.main.Service;

public class ImageDeleteService implements Service {

	
	private final ImageDAO dao;

	public ImageDeleteService(ImageDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao=dao;
	}
	@Override
	// 데이터 Controller <-> service - DAO
	// 입력받은 글번호(ImageDTO)를 Controller 에서 받아서 처리한다.
	public Integer service(Object[] objs)  throws Exception{		
		// 데이터 처리부분에 해당된다.
		int no = (int) objs[0];
		System.out.println("ImageDeleteService.service()");
		// 이미지 글삭제에서 오류가 나고 있다는 처리를 할때 예외처리를 해준다.
		// - 예외가 발생이되면 알맞은 메시지로 바꿔서 던진다.
			return dao.delete(no);

	}
	
}
