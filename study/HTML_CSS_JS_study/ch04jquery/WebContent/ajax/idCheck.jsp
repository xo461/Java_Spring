<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
String[] ids = {"test", "admin", "webjjang", "abcd"};
String id = request.getParameter("id");
boolean checkId = false;//기본값설정 false면 중복안되고, true면 중복가능으로 설정
System.out.println("idCheck.jsp - id :" + id);

//넘어온 데이터가 현재 가지고 있는 아이디에 있는지 검사하는 프로그램
//db에 있는 아이디를 가져오는 문장(where id = ?) : 가져오면: 중복됨, 가져오지 못하면: 중복안됨.
for (int i = 0; i < ids.length; i++){
	if(id.equals(ids[i])){
		checkId = true;
		break; // switch, 반복문(for, while)을 빠져나간다.
		
	}
}

if(checkId){
	//중복이 된 경우
	out.print("<span style='color:red'>중복된 아이디 : 사용이 불가능합니다.</span>");
	
} else{
	//중복이 안된경우
	out.print("<span style='color:blue'>사용가능한 아이디입니다.</span>");
}
%>