<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/view/color.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>writeForm.jsp</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript" src="script.js"></script>
</head>
<%
int num=0;//변수
int ref=1;//글그룹
int re_step=0;//글순서
int re_level=0;//글깊이(들여쓰기)
String reddate="";

if(request.getParameter("num") != null){//->not null이면 답글
	num=Integer.parseInt(request.getParameter("num"));
	ref=Integer.parseInt(request.getParameter("ref"));
	re_step=Integer.parseInt(request.getParameter("re_step"));
	re_level=Integer.parseInt(request.getParameter("re_level"));
}
%>
<body>
<h2><center>글쓰기, 답글쓰기</center></h2>
<form method="post" action="writePro.jsp" onSubmit="return writeSave()">

	<input type="hidden" name="num" value="<%=num %>">
	<input type="hidden" name="ref" value="<%=ref %>">
	<input type="hidden" name="re_step" value="<%=re_step %>">
	<input type="hidden" name="re_level" value="<%=re_level %>">

	<table width="500" cellpadding="3" bgcolor="<%=bodyback_c %>" align="center">
		<tr>
			<td colspan="2" align="right" bgcolor="<%=value_c %>">
				<a href="list.jsp">글목록보기</a>
			</td>
		</tr>
	
		<%--이름 --%>
		<tr bgcolor="<%=value_c %>">
			<td width="70">이름</td>
			<td width="330">
				<input type="text" name="writer" id="writer" size="12">
			</td>
		</tr>
		
		<%--글제목 --%>
		<tr bgcolor="<%=value_c %>">
			<td>글제목</td>
			<td>
			<%
				if(request.getParameter("num")==null){//원글
					%>
					<input type="text" name="subject" id="subject" size="40">
					<%
				}else{//답글
					%>
					<input type="text" name="subject" id="subject" size="40" value="[답글]">
					<%
				}//else end--
			%>
			</td>
		</tr>

		<%--email --%>
		<tr bgcolor="<%=value_c %>">
			<td>이메일</td>
			<td><input type="text" name="email" id="email" size="30" placeholder="aaa">
			</td>
		</tr>


		<tr bgcolor="<%=value_c %>">
			<td>글내용</td>
			<td>
				<textarea rows="10" cols="50" name="content" id="content"></textarea>
			</td>
		</tr>

		<%--pw--%>
		<tr bgcolor="<%=value_c %>">
			<td>패스워드</td>
			<td><input type="password" name="passwd" id="passwd" size="12" >
			</td>
		</tr>
		
		<tr bgcolor="<%=value_c %>">
			<td colspan="2" align="center">
				<input type="submit" value="글쓰기">
				<input type="submit" value="수정">
				<input type="submit" value="삭제">
			</td>
	</table>
</form>
</body>
</html>