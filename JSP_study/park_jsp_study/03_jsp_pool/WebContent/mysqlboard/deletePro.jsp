<%@page import="boardmysql.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");

int num=Integer.parseInt(request.getParameter("num"));
String pageNum=request.getParameter("pageNum");
String passwd=request.getParameter("passwd");

BoardDAO dao = BoardDAO.getDao();
int check = dao.deleteArticle(num, passwd);

if(check==1){//정상적으로 삭제
	response.sendRedirect("list.jsp?pageNum="+pageNum);
}else{//암호틀림
%>
<script>
alert("암호가 틀립니다.");
history.back();
</script>
<%
}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>