<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forward3.jsp</title>
</head>
<body>
<h2>forward액션 태그 forward3.jsp</h2>
	<table border="1">
		<tr>
			<td>이름</td>
			<td><%=request.getParameter("name") %></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><%=request.getParameter("age") %></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><%=request.getParameter("addr") %></td>
		</tr>
		<tr>
			<td>전화</td>
			<td><%=request.getParameter("tel") %></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><%=request.getParameter("email") %></td>
		</tr>


</body>
</html>