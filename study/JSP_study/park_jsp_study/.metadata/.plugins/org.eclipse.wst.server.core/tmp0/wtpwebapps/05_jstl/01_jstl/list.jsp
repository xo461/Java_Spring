<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="boardmysql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ include file="/view/color.jsp" %>

<%--list.jsp--%>
<%
request.setCharacterEncoding("utf-8");
%>

<%!
int pageSize=10;
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>

<%
String pageNum=request.getParameter("pageNum");//페이지를 받아서 
if(pageNum==null){pageNum="1";}//페이지가 없으면 1 로한다 

int currentPage=Integer.parseInt(pageNum);//현재 페이지 
int startRow=(currentPage-1)*pageSize+1;//페이지의 시작 글번호
											//(1-1)*10+1=1
											//(2-1)*10+1=11
											//(3-1)*10+1=21
											//(4-1)*10+1=31
											//(5-1)*10+1=41
int endRow=currentPage*pageSize;//페이지의 끝 번호
//                   1*10=10
//                   2*10=20
//                   3*10=30
//                   4*10=40
//                   5*10=50

int count=0;//글 갯수 
int number=0;//글번호
List list=null;//데이터 받을 변수

BoardDAO dao=BoardDAO.getDAO();//dao객체 얻기
count=dao.getArticleCount();//dao메서드 호출하여,글 갯수 얻기

if(count>0){//글이 존재 하면 
	list=dao.getList(startRow, pageSize);//dao메서드 호출 
	//                시작위치,갯수
}

number=count-(currentPage-1)*pageSize;//보여줄 글번호
       //37 -(3-1)*10=17

//1 페이지 1~10
//2 페이지 11~20
//3 페이지 21~30-----17  number--
//4 페이지 31~37
%>

<html>

<head>
<link rel="stylesheet" href="style.css" type="text/css">
</head>

<body>
<center><b><h1>글목록(전체글):<%=count %></h1></b></center>

<table width="700" align="center">
<tr>
<td align="right" bgcolor="<%=value_c%>">
  <a href="writeForm.jsp"><h3>새글쓰기</h3></a>
</td>
</tr>
</table>
<%
if(count==0){//글이 없으면
	%>
	<table width="700" border=1>
	<tr>
	<td align="center">
	게시판에 저장된 글이 없습니다
	</td>
	</tr>
	</table>
	<%
}else{//글이 있으면
	%>
<table width="700" border="1" cellpadding="3" align="center">
<tr>
<td align="center" width=50>번호</td>
<td align="center" width=200>글제목</td>
<td align="center" width=100>작성자</td>
<td align="center" width=200>작성일</td>
<td align="center" width=50>조회수</td>
<td align="center" width=100>ip</td>
</tr>
<%
for(int i=0;i<list.size(); i++){
	BoardDTO dto=(BoardDTO)list.get(i);
	%>
	<tr height="30">
	
	<td align="center"><%=number-- %></td>
 
	<%--글제목 출력 , 답글 들여쓰기 --%>
	
	<td>
	<%
	//답글 들여쓰기계산
	int wid=0;//변수
	
	if(dto.getRe_level()>0){//답글이면
		wid=5*(dto.getRe_level());
	%>
	
	<img src="../imags/level.gif" width="<%=wid %>" height="16">
	<img src="../imags/re.gif">
	<%
	}else{//원글
	%>
	<img src="../imags/level.gif" width="<%=wid %>" height="16">
	<%
	}//else---
	%>
	
	<%--글제목 --%>
	<a href="content.jsp?num=<%=dto.getNum()%>&pageNum=<%=currentPage%>">
	<%=dto.getSubject() %>
	</a>
	<%="조횟수:"+dto.getReadcount() %>
	<%
	if(dto.getReadcount()>20){//조회수가 20번 이상이면 hot.gif표시
	%>
	<img src="../imags/hot.gif" height="10" border="0">
	<%
	}//if
	%>
	</td>
	
	<%--글쓴이 --%>
	<td align="center">
	 <a href="mailto:<%=dto.getEmail()%>">
	 <%=dto.getWriter() %>
	 </a>
	</td>
	
	<td align=center><%=sdf.format(dto.getReg_date()) %></td>
	<td align=center><%=dto.getReadcount() %></td>
	<td align=center><%=dto.getIp() %></td>
	
	</tr>
	<%
}//for end---------------
%>
</table>
	
	<%
}//else -------------------------
%>

<%--블럭처리,페이지 처리  --%>

<%
if(count>0){//글이 있을때
 %>
	
<table border="1" width="700" align="center">

<tr>
<td align="center">
<%
int pageCount=count/pageSize+(count%pageSize==0?0:1);
//int pageCount=(int)(Math.ceil(count/pageSize));

int pageBlock=10;//블럭당 페이지수 10개
int startPage=(int)(currentPage/pageBlock)*10+1;//시작페이지
														//(1/10)*10+1=1 page
														//(5/10)*10+1=1 page
		
int endPage=startPage+pageBlock-1;//끝 페이지 
//                  1+10-1=10 page
//                  11+10-1=20 page
//                  21+10-1=30 page

if(endPage>pageCount){//에러방지를 위해
	endPage=pageCount;
}//if

//이전블럭
if(startPage>10){
%>
<a href="list.jsp?pageNum=<%=startPage-10 %>">[이전블럭]</a>
<%
}//if

//page 처리
for(int i=startPage;i<=endPage; i++){
	%>
	<a href="list.jsp?pageNum=<%=i%>">[<%=i %>]</a>
	<%
}//for

//다음블럭
if(endPage<pageCount){
%>
<a href="list.jsp?pageNum=<%=startPage+10 %>">[다음블럭]</a>
<%
}//if
%>
</td>
</tr>
	
</table>
<%
}//if 글이 존재 할때 
%>
</body>

</html>
