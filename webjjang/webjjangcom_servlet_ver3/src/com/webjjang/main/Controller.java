package com.webjjang.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	//메소드 controller를 다른데서도 써야되니까 public... 메소드 이름 execute... ()파라메터로 서블릿내용 받는다...
	//	request만 받고 response는 받지 않게 하기 (forward시킨건 다 frontcontroller에서 받기 때문에 response가 필요 없음)
	//return으로 사용되는 string을 jsp나 url이 된다. 
	
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri)
	throws Exception;
	
}
