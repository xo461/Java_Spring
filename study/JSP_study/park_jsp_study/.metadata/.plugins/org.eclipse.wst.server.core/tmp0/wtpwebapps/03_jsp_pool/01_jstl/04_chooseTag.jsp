<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

choose태그 실습
<ul>
<c:choose>
	<c:when test="${param.name=='yomi' }">
		<li>당신의이름은 ${param.name }입니다.</li>
	</c:when>
	
	    <c:when test="${param.age>'30'}">
      <li>당신의 나이는 ${param.age}살이며 늙었습니다.</li>
    </c:when>
 
	    <c:when test="${param.age<='30'}">
      <li>당신의 나이는 ${param.age}살이며 애기입니다.</li>
    </c:when>

	<c:otherwise>
		<li>당신의이름은 mini가 아닙니다.
	</c:otherwise>
<!-- 주소창에 입력해서 확인 -->
<!-- 맨뒤에 ?name=mini&age=27 -->
<!-- 이라고 입력 -->
</c:choose>
</ul>




</body>




</html>