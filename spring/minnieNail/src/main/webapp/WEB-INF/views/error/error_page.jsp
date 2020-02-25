<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 500번 에러 처리하기 -->	
	<!-- el객체: pageContext, request, session, application -->
	<!-- 그중에 exception은 request에 담겨있다.  -->
	<!-- 중괄호 안에 exception은 CommonExceptionAdvice.java에서 "exception"이름으로 넘겨받은것... -->
	<h4>${exception.getMessage() }</h4>
	<ul>
		<c:forEach items="${exception.getStackTrace() }" var="stack">
			<li>${stack }</li>
		</c:forEach>
	</ul>
</body>
</html>