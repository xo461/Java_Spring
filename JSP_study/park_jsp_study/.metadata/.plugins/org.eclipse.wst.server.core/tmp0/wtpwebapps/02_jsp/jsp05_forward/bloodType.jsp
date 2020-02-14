<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
 request.setCharacterEncoding("utf-8"); //post요청 한글처리
%>

<%
String name="미니";
String bloodType=request.getParameter("bloodType");//bloodType.html에서 name=해서 정의한 것 받는것
bloodType=bloodType+".jsp";//A.jsp
%>

<<jsp:forward page="<%=bloodType %>">
	<jsp:param name="name" value="<%=name %>"/>

</jsp:forward>