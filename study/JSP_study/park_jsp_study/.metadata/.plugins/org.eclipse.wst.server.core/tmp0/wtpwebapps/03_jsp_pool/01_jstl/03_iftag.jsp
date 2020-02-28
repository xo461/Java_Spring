<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${param.name=='mini' }">
	${param.name }님 환영합니다.
</c:if>

<c:if test="${param.style=='cute한' }">
	당신은 ${param.style } 스타일입니다.
</c:if>

<!-- 주소창에 입력해서 확인 -->
<!-- 맨뒤에 ?name=mini&style=cute한 -->
<!-- 이라고 입력 -->

</body>
</html>