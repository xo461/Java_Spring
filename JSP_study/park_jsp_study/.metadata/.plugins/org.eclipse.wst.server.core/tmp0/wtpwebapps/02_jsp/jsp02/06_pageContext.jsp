<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>06_pageContext.jsp</title>
</head>
<body>
<%
JspWriter out2 = pageContext.getOut();
out2.println("2019년 12월 10일 화요일<br><br>");
%>

요청 객체:<%=pageContext.getRequest() %><p>
세션 객체:<%=pageContext.getSession() %><p>
예외 객체:<%=pageContext.getException() %><p>

<%
pageContext.getOut().println("오늘은 화요일<br><br>");

String name = pageContext.getServletContext().getInitParameter("name");
out.println("name : " + name);
%>

</body>
</html>