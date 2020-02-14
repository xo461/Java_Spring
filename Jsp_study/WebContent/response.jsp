<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    //사용컴퓨터에 저장되어 있는 캐시파일을 사용하지 않도록 설정
    //->소스가 자주 변경되는 경우만 사용
    response.setHeader
    ("Cache-Control", "no-cache"); 
    
    //페이지 이동
//    response.sendRedirect("url?k=v")

//서버 속도가 빠르다. 통신장비는 속도가 느리다. 클라이언트 컴퓨터도 속도가 다르다.
//가장 느린 것에 맞춰서 처리를 해야 제대로된 데이터가 넘어감.
//데이터를 한 개씩 처리하지 않고 한꺼번에 모아서 (버퍼) 처리하게 하자
//마지막에 남은 데이터를 넘겨주는 메소드 : flushbuffer
response.flushBuffer();
response.setContentType("text/html;charset=utf-8");
PrintWriter out2 = 
response.getWriter();



%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>response 객체</title>
</head>
<body>
변경되는 대로 바로 적용시키기 : header(Cache-Control) -> no-cache<br/>
변경되는 대로 바로 적용시키기 : &lt;F5&gt; 키 대신에 &lt;Ctrl&gt;-&lt;F5&gt;<br/>
버퍼 사이즈: <%= response.getBufferSize() %><br/>
버퍼 사이즈: <% out.print(response.getBufferSize()); %><br/>
버퍼 사이즈: <% out2.print(response.getBufferSize()); %><br/>

</body>
</html>