<%@page import="emailupload.EmailUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
request.setCharacterEncoding("utf-8");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EmailUpload.jsp</title>
</head>
<body>

<jsp:useBean id="emailUpload" class="emailupload.EmailUpload"/>

<%-- 위에 jsp:useBean이 java의 객체생성역할을 함 : emailupload.EmailUpload emailUpload = new emailupload.EmailUpload(); --%>

<%= emailUpload.upload(request)%>
</body>
</html>