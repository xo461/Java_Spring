<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
out.println("서버정보<br>");
out.println(application.getServerInfo());
out.println("<br><br>");

out.println("aa.html MIME type 은<br>");
out.println(application.getMimeType("aa.html"));


%>

<br><br>

메이저 버전: <%= application.getMajorVersion() %><br>
마이너 버전: <%= application.getMinorVersion() %><br>
실제 경로: <%= application.getRealPath("/") %><br>
<!-- jsp3.1버전 사용중 -> 메이저 3, 마이너 1 -->


<%
application.log("오늘 불출석한 사람");
%>
</body>
</html>