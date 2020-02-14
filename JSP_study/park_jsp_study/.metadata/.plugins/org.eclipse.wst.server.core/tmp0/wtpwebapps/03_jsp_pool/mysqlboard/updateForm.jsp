<%@page import="boardmysql.BoardDTO"%>
<%@page import="boardmysql.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/view/color.jsp" %>    
    

<%
request.setCharacterEncoding("utf-8");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
 <%
  int num=Integer.parseInt(request.getParameter("num"));
  String pageNum=request.getParameter("pageNum");
  
  BoardDAO dao=BoardDAO.getDao();//dao객체 얻기 
  BoardDTO dto=dao.updateGetArticle(num);
  %>

<body>
<h2><center>글수정</center></h2>
<form name="writeForm" method="post" action="updatePro.jsp?pageNum=<%=pageNum %>">
	<table width="60%" cellpadding="5"  align="center">
		<tr bgclor=<%=value_c %>>
			<td align="right"  width="70"	>이름</td>
			<td width="330"	>
				<input type="text" name="writer" id="writer" size="16" value=<%=dto.getWriter() %>>
		</td>		
		       <tr bgcolor="<%=value_c%>">
         <td width="70" align="center">글제목</td>
         <td width="330">
           <input type="text" name="subject" id="subject" size="16" value="<%=dto.getSubject()%>">
          </td>
       </tr>


	       <tr bgcolor="<%=value_c%>">
         <td width="70" align="center">이메일</td>
         <td width="330">
           <input type="text" name="email" id="email" size="16" value="<%=dto.getEmail()%>">
          </td>
       </tr>
	
	       <tr bgcolor="<%=value_c%>">
         <td width="70" align="center">글내용</td>
         <td width="330">
			<textarea rows="10" cols="50" name="content" id="content"><%=dto.getContent() %></textarea>
          </td>
       </tr>

       <tr bgcolor="<%=value_c%>">
         <td width="70" align="center">암호</td>
         <td width="330">
           <input type="password" name="passwd" id="passwd" size="16" >
          </td>
       </tr>
       
       <tr height="30">
       <td colspan="4" bgcolor="<%=value_c%>" align="right">
       <input type="submit" value="글수정" >
       <input type="reset" value="취소" >
       <input type="button" value="글목록보기" onClick="document.location.href='list.jsp?pageNum=<%=pageNum%>'">
       </td>
     </tr>
     </form>
</body>
</html>

