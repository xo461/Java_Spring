<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");

String id=request.getParameter("id");
String pwd=request.getParameter("pwd");

session.setAttribute("id", id); //session에 값 설정 *****
session.setMaxInactiveInterval(60*5); //300초 유효기간 설정

%>

<form method="post" action="Session_2.jsp">

1. 가장 좋아하는 계절은 무엇인가요?<br>
<input type="radio" name="season" value="봄">봄<br>
<input type="radio" name="season" value="여름">여름<br>
<input type="radio" name="season" value="가을">가을<br>
<input type="radio" name="season" value="겨울">겨울<br>
<br>

1. 가장 좋아하는 과일은 무엇인가요?<br>
<input type="radio" name="fruit" value="감">감<br>
<input type="radio" name="fruit" value="복숭아">복숭아<br>
<input type="radio" name="fruit" value="수박">수박<br>
<input type="radio" name="fruit" value="포도">포도<br>
<br>

<input type="submit" value="전송">
</form>