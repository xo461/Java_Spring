<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Webjjang Board</title>
</head>
<body>
<div class="container">


<h1>Webjjang Board</h1>
<table>
	<tr>
		<th>No</th>
		<th>Title</th>
		<th>Writer</th>
		<th>Wrte date</th>
		<th>Hit</th>
	</tr>
	<!-- 데이터갯수만큼 반복문: taglib의 core jstl사용 'c'라는 이름으로 foreach기능. -->
	<!-- boardcontroller에서 key값으로 준 이름'list'를 사용해야 데이터를 받을 수 있다. -->
	<!-- jsp에서 저장할수있는 기본객체 4가지 pagecontext(jsp페이지에서만), request(화면에나타날때까지만), session(사용자가 서버에있을동안만), application(서버시작후서버종료될때까지) -->
	<!-- list가 어디에 있는지 위에 4개중하나에서 찾는다.(request에 잇음)  -->
	<!-- 반복문돌따마다 list가져오면 데이터가 너무 많아지므로 var에 dto로 넣어서 pageContext에서만 사용하도록 한다. -->
	<!-- dto.no라고 함은 BoardDTO에 있는 변수인데 원래는 private변수라 다른데서 못가져오는데 jsp에서 java로 컴파일할떄 자동으로 getNo()로 바꿔줘서 가능하다(getter호출). -->
	<!-- 이 no는 변수(내맘대로 값넣으루있는것)가아니고 property다(getter로 가져오는것. private이므로내맘대로 변경 불가). jsp에서 property를 쓰도록 강제한다. -->
	<c:forEach items="${list }" var="dto">
		<tr>
			<td>${dto.no}</td>
			<td>${dto.title}<span>[{dto.reply_cnt}]</span></td>
			<td>${dto.writer}</td>
			<td>${dto.writeDate}</td>
			<td>${dto.hit}</td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>