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
<c:forEach items="${cm}" var="c">
	${c} - ${vmdata.get(c).opening_p} <br/>
	${c} - ${vmdata.get(c).closing_p} <br/>
	${c} - ${vmdata.get(c).max_p} <br/>
	${c} - ${vmdata.get(c).min_p} <br/>
</c:forEach>





</body>
</html>