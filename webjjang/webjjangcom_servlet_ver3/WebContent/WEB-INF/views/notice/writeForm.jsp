<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<!-- #뒤에 이름 통일시켜서 사용해야 함 -->
<script>
	$(function() {
		$("#startDate").datepicker();
		$("#startDate").datepicker("option", "dateFormat", "yy-mm-dd");
	});

</script>

	<script>
	$(function() {
		$("#endDate").datepicker();
		$("#endDate").datepicker("option", "dateFormat", "yy-mm-dd");
	});
</script>


<title></title>
</head>
<body>

	<div class="container">


		<h1>공지사항 쓰기</h1>

		<!-- 많은 데이터를 넘길 때 : form --post방식...-->

		<form action="write.jsp" method="post">
			<!-- input, select, textarea: 입력항목만들기: 생략 -->



			<div class="form-group">
				<label for="title">제목:</label> <input type="text" class="form-control"
					name="title">
			</div>



			<div class="form-group">
				<label for="content">내용:</label>
				<textarea rows="5" cols="100" name="content"></textarea>
				<br />
			</div>



			<div class="form-group">
				<label for="startDate">공지시작일:</label> 
				<input type="text"
					class="form-control" id="startDate" name="startDate" maxlength="10"
					required="required" pattern="^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$"
					title="날짜형식은 yyyy-mm-dd" /><br />
			</div>


	<div class="form-group">
				<label for="endDate">공지종료일:</label> 
				<input type="text"
					class="form-control" id="endDate" name="endDate" maxlength="10"
					required="required" pattern="^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$"
					title="날짜형식은 yyyy-mm-dd" /><br />
			</div>

			
			<!-- button tag의 기본 타입은 submit이다. 그래서 생략 가능  -->
			<button type="submit">등록</button>
			<button>다시입력</button>
			<!-- 버튼기능만 사용하고 다른동작은 하지 않도록: button -->
			<!-- 동작을 따로 정의 onclick 클릭했을때 동작. history.back : 이전페이지로 가자. -->
			<button type="button" onclick="history.back()">취소</button>


		</form>
	</div>
</body>
</html>