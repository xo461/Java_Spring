<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--1 방법 --%>
<c:url var="u1" value="../shopping.do"/>

<%--2 방법--%>
<c:url var="u2" value="../shopping/do">
  <c:param name="id" value="park"/>
</c:url>

<%--3 방법--%>
<c:url var="u3" value="http://localhost:9000/12_JSTL/01_jstl/01_set_remove.jsp"/>

<ul>
<li>u1=${u1} 
<li>u2=${u2} 
<li>u3=${u3} 
</ul>


</body>
</html>