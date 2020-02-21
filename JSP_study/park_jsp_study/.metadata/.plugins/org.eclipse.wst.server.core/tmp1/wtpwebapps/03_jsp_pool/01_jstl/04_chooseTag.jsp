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

<c:choose>
	<c:when test="${param.name=='yomi' }">
		<li>당신의이름은 ${param.name }입니다.
	</c:when>
	
	    <c:when test="${param.age>'30'}">
      <li>당신의 나이는 ${param.age}살이며 늙었습니다.
    </c:when>
 
	    <c:when test="${param.age<='30'}">
      <li>당신의 나이는 ${param.age}살이며 애기입니다.
    </c:when>

	<c:otherwise>
		<li>당신의이름은 mini가 아닙니다.
	</c:otherwise>

</c:choose>

</body>
</html>