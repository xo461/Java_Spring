<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");//post요청 한글처리
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--include 액션 태그는 처리 결과가 들어온다  --%>
includeTag.jsp<br>
includeTag.jsp<br>
<jsp:include page="includeTagTop.jsp"/>

<%
String name="Korea Football";//변수
%>
<%=name %> 
<!-- getparameter를 한 적이 없으므로 includeTag.html에서 정의한 name이 들어오지 않고, 위에서 정의한 name=korea football이 들어온다. -->
includeTag.jsp<br>
includeTag.jsp<br>
</body>
</html>