<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<hr size="3">
<c:if test="${param.id != null }">
  [HEADER] ${param.id }님의 방문을 완전 환영합니다 
</c:if>
<hr size="3">


</body>
</html>