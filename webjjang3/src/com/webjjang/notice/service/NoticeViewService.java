package com.webjjang.notice.service;

import com.webjjang.main.Service;
import com.webjjang.notice.dao.NoticeDAO;

public class NoticeViewService implements Service {

	// ������ controller <->DAO
	// �۹�ȣ�� controller���� �޾Ƽ� ó���Ѵ�.

	private final NoticeDAO dao;

//		생성자 (사용해야 할 dao 객체를 초기화. 밖에서 생성할 때 넣어준다.)
//		객체가 의존하고 있음. 의존성. 그 객체를 주입해줌.의존성주입 dependency injection DI
	public NoticeViewService(NoticeDAO dao) {
		//dao 값을 넣기
		this.dao = dao;
	}
	@Override
	public Object service(Object[] objs) throws Exception{
		
			
		System.out.println("NoticeViewService.service()");
		
		int no = (int)objs[0];
		
		//������ ó�� �κп� �ش�ȴ�. 
		//�����͸� ����Ŭ���� �������� ���� ��ü ���� ȣ��.
		if(objs.length==2 && (int) objs[1] == 1)
			dao.increaseHit(no);
		return dao.view(no);
}
}
