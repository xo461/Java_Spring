<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/view/color.jsp" %>

<%--deleteForm.jsp--%>
<%
int num=Integer.parseInt(request.getParameter("num"));
String pageNum=request.getParameter("pageNum");
%>

<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function deleteSave() {
	if(document.delForm.passwd.value==''){
		alert("Enter your password");
		document.delForm.passwd.focus();
		return false;
	}//if
}//del end

</script>
</head>
<body>
<h2 align="center">글삭제</h2>
<form action="deletePro.jsp?pageNum=<%=pageNum %>"  onsubmit="return deleteSave()" method="post"  name="delForm">

	<table width="360" cellpadding="5"  align="center">
		<tr bgcolor=<%=value_c %> height="30">
		<td align="center"  width="70"	>Enter your password
		</td>
		</tr>		
		
		<tr bgcolor="<%=value_c%>"height="30">
         <td width="70" align="center">pw:
           <input type="password" name="passwd" id="passwd" size="30" >
           <input type="hidden" name="num" value="<%=num%>">
          </td>
       </tr>
		
		<tr bgcolor="<%=value_c%>"height="30">
         <td width="70" align="center">
           <input type="submit"  value="글삭제" >
           <input type="button"  value="글목록보기" onclick="document.location='list.jsp?num=<%=num%>&pageNum=<%=pageNum%>'">
          </td>
       </tr>

</table>
</form>

</body>
</html>