<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String control = request.getParameter("control");
String contentPage=request.getParameter("contentPage");
String pageTitle=request.getParameter("pageTitle");

String left=control+"left.jsp"; //dcleft.jsp, pmpleft.jsp
%>
<html>
<body bgcolor="orange" topmargin="5%">
<h1>MyHome Page</h1>

<table width="90%" height = "95%" align="center" bgColor="margenta"
border="1" cellpadding="2" cellspacing="0">
<tr>
<td colspan="2" height="10%">
<font size="3">
<jsp:include page="top.jsp" flush="false"/>
</font>
</td>
</tr>

<tr>
<!-- 왼쪽메뉴 -->
	<td width="100" valign="top">
		<jsp:include page="<%= left%>" flush="false"/>
	</td>
	
<!-- 중앙 -->
	<td width="450" valign="top">
		<jsp:include page="<%= contentPage%>" flush="false"/>
	</td>
</tr>


<tr>
<td colspan="2" align="center">
		<jsp:include page="bottom.jsp" flush="false"/>
</td>
</tr>


</table>
</body>
</html>