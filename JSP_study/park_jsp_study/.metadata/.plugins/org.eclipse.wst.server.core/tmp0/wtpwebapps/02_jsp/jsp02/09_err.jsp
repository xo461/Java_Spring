<%@ page 
language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
 %>
<!-- true - 에러페이지라고 알려주기 -->
 <%@page isErrorPage="true" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>09_err.jsp</title>
</head>
<body>
<!-- 09_exception.jsp에서 에러가 발생하면 09_err.jsp로 오도록 한다. -->

<% 
String msg = exception.getMessage();
String obj = exception.toString();
%>
에러메시지: <%= msg %><br> 
에러 실체의 클래스명과 에러메시지 <%=obj %><br> 

</body>
</html>