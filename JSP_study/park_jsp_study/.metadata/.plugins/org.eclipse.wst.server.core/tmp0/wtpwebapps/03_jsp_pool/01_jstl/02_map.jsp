<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//map : dto와 같다.
Map <String, String> map = new HashMap <>();
map.put("name", "미니");
map.put("hobby", "등산");
map.put("style", "귀여움");

%>

이름:<%=map.get("name") %><br>
취미:<%=map.get("hobby") %><br>
스타일:<%=map.get("style") %><br>

<c:set var="map" value="<%=new HashMap() %>" scope="page"/>

<c:set target="${map }" property="name" value="요미"/>
<c:set target="${map }" property="hobby" value="드라이브"/>
<c:set target="${map }" property="style" value="댄디"/>

<br>
이름:${map.name}<br>
취미:${map.hobby}<br>
스타일:${map.style}<br>

</body>
</html>