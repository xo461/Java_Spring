<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Let's use vector!!!</h2>
<h3>
<%= request.getAttribute("user")%>, what's in your cart? 

</h3>
<h3>${user }, you wanna buy these?:)</h3>

<!-- 1. 옛날 방식 -->
<ol>
<%
Vector vec = (Vector) request.getAttribute("vec");
for(int i=0; i<vec.size(); i++){
	%>
	<li><%=vec.get(i) %>
	<%
}//for
%>
</ol>

<!-- el사용 -->
<!-- hashmap -->
<h3>${user2 }, you have these in your cart:)</h3>
pum1:${map.pum1 }<br>
pum2:${map.pum2 }<br>
pum3:${map.pum3 }<br>

<!-- for each -->
<c:forEach var="m" items="${map }">
	${m.key} ==> ${m.value }<br>
</c:forEach>

</body>
</html>