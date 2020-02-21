<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="boardmysql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>  

<%@ include file="/view/color.jsp" %>
   
<%--list.jsp --%>
<%
request.setCharacterEncoding("utf-8");
%>

<%!
int pageSize=10;
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>

<%
String pageNum=request.getParameter("pageNum");//페이지 번호 받기
if(pageNum==null){//처음 list.jsp로 실행하면 pageNum없기때문에 이를 처리하기 위해
	pageNum="1";
}//if

int currentPage=Integer.parseInt(pageNum);//문자열을 정수로 변환 
int startRow=(currentPage-1)*pageSize+1;//페이지의 시작 글번호
int endRow=currentPage*pageSize;//페이지의 끝번호

int count=0;//글 갯수
int number=0;//글번호
List <BoardDTO>list=null;//dao로부터 데이터 받기 

BoardDAO dao = BoardDAO.getDao();//dao 객체 얻기 
count=dao.getArticlCount();//글 갯수 얻기 

if(count>0){//글이 존재할때만 
	list=dao.getList(startRow, pageSize);
  //                  시작위치           갯수
}//if

number=count-(currentPage-1)*pageSize;//보여줄 글번호
%>

<html>
 <head>
  <link rel="stylesheet" href="style.css" type="text/css">
 </head>
 <body>
  <h1><center>글목록(전체글):<%=count %></center></h1>
  
   <table width="80%" align="center">
     <tr>
      <td align="right" bgcolor="<%=value_c %>">
        <a href="writeForm.jsp">새글글쓰기</a>
      </td>
     </tr>
   </table>
   <%
    if(count==0){//글이 없으면
    %>
     <table width="70%" align="center">
     <tr>
      <td align="center" bgcolor="<%=value_c %>">
                     게시판에 저장된 글이 없습니다
      </td>
     </tr>
    </table>
    <%
    }else{//글이 있으면 
    %>
    <table width="80%" align="center" border="1" cellpadding="3">
     <tr>
      <td align="center" width="100">번호</td>
      <td align="center" width="300">글제목</td>
      <td align="center" width="150">글쓴이</td>
      <td align="center" width="200">작성일</td>
      <td align="center" width="200">조회수</td>
      <td align="center" width="100">ip</td>
     </tr>
    <%
    for(int i=0; i<list.size(); i++){
    	BoardDTO dto=(BoardDTO)list.get(i);
    	%>
    	<tr height="30">
    	
			<!--     	글번호 -->
    	  <td align="center"><%=number-- %></td>
    	
    		<%--글제목 출력 , 답글 들여쓰기 --%>
    	<td>
    	<%
    	//답글 들여 쓰기 계산
    	int wid=0;//변수
    	if(dto.getRe_level()>0){//답글이면
    		wid=5*dto.getRe_level();
    	%>
    	<img src="../imags/level.gif" width="<%=wid%>" height="16">
    	<img src="../imags/re.gif">
    	<%
    	}else{//원글이면
    	%>
    	<img src="../imags/level.gif" width="<%=wid%>" height="16">
    	    	<%
    	}//else end--
    	%>
    	<%--글제목 출력  --%>
    	 <a href="content.jsp?num=<%=dto.getNum()%>&pageNum=<%=currentPage%>">
    	   <%=dto.getSubject() %>
    	 </a> 
    	 <%
    	 //조횟수 20번 이상이면 hot.gif 표시하기
    	 if(dto.getReadcount()>20){
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
	
	    <td align=center><%=sdf.format(dto.getReg_date())%></td>
	    <td align=center><%=dto.getReadcount() %></td>
	    <td align=center><%=dto.getIp() %></td>
    	</tr>

    	<%
    }//for end
     %>
    </table>
     <%	
    }//else end ---글이 있으면  끝
   %>
   
   <%--페이지 처리, 블럭 처리  --%>
   <%
   if(count>0){//글이 있으면 
  %>
  <table width="70%" align="center">
	<tr>
	<td align="center">
	<%
	int pageCount=count/pageSize+(count%pageSize==0?0:1);
	//int pageCount=(int)(Math.ceil(count/pageSize));
	
	int pageBlock=10;//블럭당 페이지 수 10개
	int startPage=(int)(currentPage/pageBlock)*10+1;//시작 페이지 
	int endPage=startPage+pageBlock-1;//끝 페이지 
	
	if(endPage>pageCount){//에러 방지를 위해서
		endPage=pageCount;
	}
	
	//이전블럭
	if(startPage>10){
	%>
	<a href="list.jsp?pageNum=<%=startPage-10%>">[이전블럭]</a>
	<%
	}//if
	
	//page 처리 
	
	for(int i=startPage; i<=endPage; i++){
	%>
	<a href="list.jsp?pageNum=<%=i%>">
	[<%= i%>]
	</a>
	<%
	}//for end
	
	
	//다음 블럭
	if(endPage<pageCount){
	%>
	<a href="list.jsp?pageNum=<%=startPage+10%>">[다음블럭]</a>
	<%
	}//if
	%>
	</td>
	</tr> 
  </table>
	   <%
   }//if end 글이 존재 할때
   
   %>
 </body>
</html>

