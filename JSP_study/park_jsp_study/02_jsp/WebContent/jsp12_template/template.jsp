<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String pageFile=request.getParameter("page"); 
//page가 key고 그뒤에 value를 pageFile에 저장

if(pageFile==null){
	pageFile="newItem.jsp";
}
%>

<html>
	<body bgcolor="orange">
		<table width="90%" height="99%" border="1" align="center">
		
		<!-- 		상단메뉴 -->
		<tr>
			<td colspan="2" width="15%" align="right" valign="top">
			<br>
			<jsp:include page="top.jsp"/>
			</td>
		</tr>		
		
		<tr>
			<!-- 			왼쪽메뉴 -->
			<td width="15%" align="left" valign="top">
			<br>
			<jsp:include page="left.jsp"/>
			</td>
			
			<!-- 			중앙 -->
			<td align="center">
			<jsp:include page="<%=pageFile %>"/>
			</td>
		</tr>		
		
		
		</table>
	</body>
</html>