package com.webjjang.main;

public class Execute {
	// 서비스를 실행하는 메소드
	// service(실행객체, 넘겨질 파라미터) -> 넘겨질 파라미터는 캐스팅해서 사용
	public static Object service(Service service, Object ...objs) throws Exception {
		return service.service(objs);
	}
	
	
}
