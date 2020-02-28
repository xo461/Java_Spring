/*
 * 서비스 객체를 실행하기 위해 만들어놓은 인터페이스
 * 모든 서비스 객체들은 이 인터페이스를 반드시 상속받아야만 한다.
 */

package com.webjjang.main;

public interface Service {

	//각각의 서비스들마다 필요한 데이터 타입(List, boardDTO 등)이 다른데 서비스들을 하나의 인터페이스로 상속받게 만들려면
	//모든 객체가 상속받고 있는 Object로 만들면 casting받아서 사용가능
	
//	메소드는 클래스랑 이름은 같은데 소문자로 보통 해줌.
//	list는 전체 다 가져오면 되기 때문에 파라메터가 필요 없다. 
//	view는 하나의 글을 지정해서 가져와야하기때문에 no가 필요
//	update는 수정해서 db로 보내야되니까 dto필요.
//	서비스별로 필요한 파라메터가 다르므로 공통으로 상속받는 Object를 파라메터로 넣어준다. 
//	Object 실제 처리할때 쓰는 파라메터 - 처리할때 필요한거(조회수,넘버 등) 여러개이므로 배열형태로 만들어준다...
	
	public Object service(Object[] objs) throws Exception;
		
	
}
