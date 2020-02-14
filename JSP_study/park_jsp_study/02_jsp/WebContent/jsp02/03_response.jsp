<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

//out.println("현재 설정된 인코딩 문자 내용 알아보기<br>");
//out.println(response.getCharacterEncoding());

//2초 후에 네이버로 이동
//response.setHeader("Refresh", "2;URL=https://www.naver.com");

//response.sendRedirect("https://www.daum.net");
//response.sendRedirect("02_request.jsp");

%>

forward 액션 태그. 같은 프로젝트 내의 로컬 url만 가능
<%-- <jsp:forward page="02_request.jsp"></jsp:forward>  --%>

</body>
</html>