<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String contentPage=request.getParameter("contentPage");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>template.jsp</title>
</head>
<body>
<table align="center" width="90%" height="90%" border=3 
bgColor="orange">

<!-- 상단메뉴 -->
<tr>
<td colspan="2" bgcolor="margenta" height="10%">
	<jsp:include page="top.jsp" flush="false"/>
	<%--flush="false"는 출력버퍼를 비우지 않는다. --%>
</td>
</tr>

<!-- 왼쪽메뉴 -->
<tr>
<td width="10%" valign="top" bgcolor="pink">
	<jsp:include page="left.jsp" flush="false"/>
</td>

<!-- 중앙배치 -->
<td width="80%" valign="top" bgcolor="orange">
	<jsp:include page="<%=contentPage %>" flush="false"/>
</td>
</tr>


<!-- 바닥배치 -->
<tr>
<td colspan="2" align="center" bgcolor="lightGray" height="10%">
	<jsp:include page="bottom.jsp" flush="false"/>
</td>


</table>

</body>
</html>