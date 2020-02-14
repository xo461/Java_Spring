<%@page import="org.apache.catalina.util.SessionIdGenerator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");//post요청 한글처리

String season=request.getParameter("season");
String fruit=request.getParameter("fruit");

//****** id 얻기
String id=(String) session.getAttribute("id");

//session ID 얻기. session ID는 자동으로 부여된다.
String sessionId=session.getId();

int intervalTime=session.getMaxInactiveInterval();//세션유지시간얻기
%>

<%
if(id !=null){//로그인 상태이면
%>
<b><%=id %></b>님이 좋아하는 계절과 과일은 <br>
<b><%=season %></b>과 <b><%= fruit %></b>입니다.
<br>

sessionID:<%=sessionId %><br>
session유지시간:<%=intervalTime %>초<br>
<%
session.invalidate();
}else{//로그인 상태가 아니면
%>
세션시간이 경과하였거나 다른 이유로 연결할 수 없습니다.<br>
<a href="Session.html">로그인</a>
<%
}//else end
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>	