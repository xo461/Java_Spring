<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 세선에서 설정해준attribute 값을 jsp에서 간단히 사용 -->
${sessionScope.id }님 환영합니다.<br><br>


이름:${param.name }<br>
취미:${paramValues.hobby[0] }<br><br> 
${paramValues.hobby[1] }<br>
${paramValues.hobby[2] }<br>
${paramValues.hobby[3] }<br>
${paramValues.hobby[4] }
</body>
</html>