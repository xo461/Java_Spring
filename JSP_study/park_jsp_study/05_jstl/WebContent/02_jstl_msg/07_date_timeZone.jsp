<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <c:set var="now" value='<%= new java.util.Date()%>'/>
     
       Korea KST :
		<fmt:formatDate value="${now}" type="both" dateStyle="full" 
		timeStyle="full"/>
		<br>

		UK GMT : 
		<fmt:timeZone value="GMT">
			<fmt:formatDate value="${now}" type="both" dateStyle="full"
			 timeStyle="full"/>
		</fmt:timeZone>

</body>
</html>