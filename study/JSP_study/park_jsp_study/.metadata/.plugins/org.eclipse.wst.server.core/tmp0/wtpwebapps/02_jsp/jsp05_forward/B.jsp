<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>A.jsp</h2>

<%
String bloodType=request.getParameter("bloodType"); //html에서 name=bloodTyped으로 만들어서 보낸것
String name=request.getParameter("name"); //jsp에서 보낸것
%>

<b><%=name %></b>님의 혈액형은
<b><%=bloodType %></b>형이고
<br>
자유인입니다.