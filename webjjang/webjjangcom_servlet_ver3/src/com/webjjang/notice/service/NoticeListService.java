package com.webjjang.notice.service;
import java.util.List;
import com.webjjang.main.Service;
import com.webjjang.notice.dao.NoticeDAO;
import com.webjjang.notice.dto.NoticeDTO;
import com.webjjang.util.page.PageObject;

//서비스 인터페이스 상속
public class NoticeListService implements Service{

	private final NoticeDAO dao;
	
	//생성자 (사용해야 할 dao 객체를 초기화. 밖에서 생성할 때 넣어준다.)
	//beans에서 한번만 생성해서 생성된 dao를 넣어준다.(inject)
	//noticelistservice는 noticedao에 의존한다.(dependency)
	//실행되는 것으로는 dao를 변수에 넣어준다. - 주입(injection)
	//의존성주입(DI, Dependency Injection)
	public NoticeListService(NoticeDAO dao) {
		//dao 값을 넣기
		this.dao = dao;
	}
	
		@Override
		//서비스 인터페이스와 같은 형식으로 씀
		public List<NoticeDTO> service(Object[] objs) throws Exception{
			
			PageObject pageObject = (PageObject) objs[0];
			
			System.out.println("NoticeListService.service()");
			
			//objs는 파라메터로 받고 있으나 사용하지는 않는다.
			//데이터를 오라클에서 가져오기 위해 선언된 dao 객체의 메소드를 호출한다.
			//미리 생성을 하고 여러 사람이 같이 쓰더라도 한번만 생성이 될 수 있도록 프로그램한다.
			System.out.println("NoticeListService.service()");
			//������ ó�� �κп� �ش�ȴ�. 
			//�����͸� ����Ŭ���� �������� ���� ��ü ���� ȣ��.
//			NoticeDAO dao = new NoticeDAO(); 
			//예전에는 필요할때마다 호출해서 썼는데 이제는 여기에 한번만 지역변수로 선언하고 생성자 를 이용하여 (final붙여서 값 고정) 쓰도록한다....
			//(인터페이스 설계와 구현)
			//new한것을 미리 생성해서 하도록 만드는 것 : 리팩토링
			//여기서 new하지 않고 밖에서 new해서 불러와서 씀.
			
			//미리 생성을 하고 여러 사람이 같이 쓰더라도 한 번 만 생성이 될 수 있도록 프로그램한다.
			//총 데이터의 갯수를 가져오는 프로그램 호출
			//오라클에서 테이블의 데이터갯수를 가져와서 넣어주어야 totalPage, startpage, endpage 자동계산된다.
			pageObject.setTotalRow(dao.getTotalRow()); 
			System.out.println("NoticeListService.service().pageObject:"+pageObject);
			return dao.list(pageObject);
			//NoticeController - NoticeListService - [NoticeDAO]

}
}
