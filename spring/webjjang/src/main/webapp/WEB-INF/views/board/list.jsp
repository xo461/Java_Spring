<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Webjjang:: Board List</title>
<style type="text/css">
	.dataRow:hover{
		background-color: #eee;
		cursor: pointer;
	}
</style>
<script type="text/javascript">
$(function(){
	//dataRow클래스를 클릭하면 {}안에 함수 실행한다.
	$(".dataRow").click(function(){
		//클릭한 것 안에 글번호 찾기
		//클릭한게 this 그안에 찾아라. no 클래스를. 그안에 text가 글번호 -> 변수저장
		var no = $(this).find(".no").text(); 
		//글번호를 붙여서 글보기로 이동시킨다.
		location = "view.do?no=" + no;
	});
})
</script>
</head>
<body>
<div class="container">
<h3>Board List</h3>
<!-- table에 부트스트랩적용: clss명 table로 지정하면 된다. -->
<!-- 1.위에 w3schools라이브러리등록 2.body밑에 container담기 3.그외필요객체: class명으로 적용. bootstrap에 있는 클래스로.-->
<table class="table">
	<tr>
		<th>No</th>
		<th>Title</th>
		<th>Writer</th>
		<th>Write date</th>
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
		<!-- 한줄전체에서 아무데나 눌르면 글보기로 가게하기: 1개면 id, 여러개는 class. -->
		<!-- 여기선 반복문으로 여러개의글이 나오므로 class로 붙여야함. -->
		<tr class="dataRow">
			<!-- 클릭했을때 글번호를 가져가서 보여줘야하니 class속성 적용 -> javascript에서 가져다가 보낸다. -->
			<td class="no">${dto.no}</td>
			<td>${dto.title} <span>[${dto.reply_cnt}]</span></td>
			<td>${dto.writer}</td>
			<!-- 날짜형을 형식에 맞춰 출력: jstl - fmt -->
			<td><fmt:formatDate value="${dto.writeDate}" pattern="yyyy.MM.dd"/></td>
			<td>${dto.hit}</td>
		</tr>
	</c:forEach>
	<!-- paging -->
	<tr>
		<td colspan="5"><!-- 합치기 -->
			<!-- 주소로 입력하므로 get방식에 적용되어 write.do로 이동, write.jsp로 간다. -->
			<a href="write.do"><button>Write</button></a>
		</td>
</table>
</div>
</body>
</html>