<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>includeTagTop.jsp</title>
</head>
<body>
<%
String id=request.getParameter("id");
String pwd=request.getParameter("pwd");
String name=request.getParameter("name");
String addr=request.getParameter("addr");
String tel=request.getParameter("tel");
%>
<hr>
<h2>includeTagTop.jsp</h2>
ID:<%=id %><br>
PWD:<%=pwd %><br>
Name:<%=name %><br>
addr:<%=addr %><br>
tel:<%=tel %><br>

<hr>
</body>
</html>