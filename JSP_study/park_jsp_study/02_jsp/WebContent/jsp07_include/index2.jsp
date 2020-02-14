<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index2.jsp</title>
</head>
<body bgcolor="#ffe5e5">
<%@ include file="top.jsp" %>

<table width="70%" align=center height="90%" 
 bgcolor="#ffff99">
<%
if(id !=null){ //로그인상태이면
	%>
	<tr>
		<td align="center">
		<%=id %>님 방문해 주셔서 감사합니다.
		</td>
	</tr>
	<% 
}else{//로그인 상태가 아니면
	%>
	<tr>
		<td align ="center">
		로그인 하신 후에 방문해 주세요.
		</td>
	</tr>
	
	<%
}//else end

%>

</table>

<%@ include file="bottom.jsp" %>

</body>
</html>