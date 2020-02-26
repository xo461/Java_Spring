<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NoticeWrite</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

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
<script type="text/javascript">
	$(function() {
		$("#writeForm").submit(function() {
			//데이터를 검사하는 regExUtil.js 파일 사용한 데이터 검사. 데이터가 유효하지 않으면(!) 더 이상 진행하지 않고 false를 리턴한다.
			if (!inputDataCheck(title_RegEx, "#title", title_err_msg))
				return false;
			if (!inputDataCheck(content_RegEx, "#content", content_err_msg))
				return false;
		});
	});
</script>
</head>
<body>
	<div class="container">
		<h1>공지사항 쓰기</h1>
		<!-- 많은 데이터를 넘길 때 : form --post방식...-->
		<form action="write.do" method="post" id="writeForm">
			<div class="form-group">
				<label for="title">제목:</label> 
				<input type="text" class="form-control" id="title" name="title">
			</div>
			<div class="form-group">
				<label for="content">내용:</label>
				<textarea class="form-control" rows="5" cols="100" id="content" name="content"></textarea>
			</div>
			<div class="form-group">
				<label for="startDate">공지시작일:</label>
				<input type="text" class="form-control" id="startDate" name="startDate" maxlength="10"
					required="required" pattern="^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$"
					title="날짜형식은 yyyy-mm-dd" /><br/>
			</div>
			<div class="form-group">
				<label for="endDate">공지종료일:</label> 
				<input type="text" class="form-control" id="endDate" name="endDate" maxlength="10"
					required="required" pattern="^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$"
					title="날짜형식은 yyyy-mm-dd" /><br/>
			</div>
			<!-- button tag의 기본 타입은 submit이다. 그래서 생략 가능  -->
			<button>등록</button>
			<button type="reset">다시입력</button>
			<button onclick="history.back()">취소</button>
		</form>
	</div>
</body>
</html>