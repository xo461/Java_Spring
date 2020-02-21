<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movie insert</title>
<!-- jquery lib는 default_decorator.jsp에서 등록 -->
<!-- bootstrap lib는 site-mesh 프로그램을 적용하지 않는 경우는 아래와같이 반드시 등록 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript" src="/js/regExUtil.js"></script>
<script type="text/javascript">
	$(function() {
		$("#writeForm").submit(function() {
			//데이터를 검사하는 regExUtil.js 파일 사용한 데이터 검사
			// 제목 - 데이터가 유효하지 않으면(!) 더 이상 진행하지 않고 false를 리턴한다.
			if (!inputDataCheck(title_RegEx, "#title", title_err_msg))
				return false;
			if (!inputDataCheck(content_RegEx, "#content", content_err_msg))
				return false;
			if (!inputDataCheck(writer_RegEx, "#writer", writer_err_msg))
				return false;
		});
	});
</script>
</head>
<body>
	<div class="container"> <!-- container가 있어야 자동레이아웃을 잡아줘서 사이드에 여백이 생긴다. -->
		<h1>글쓰기</h1>
		<form action="insert" method="post" id="writeForm">
			<div class="form-group">
				<label for="title">제목</label>
				<input type="text" class="form-control" id="title" name="title"
					title="제목을 4~100 글자 사이로 입력하셔야 합니다.">
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea class="form-control" rows="5" id="content" name="content"></textarea>
			</div>
			<div class="form-group">
				<label for="writer">작성자</label>
				<input type="text" class="form-control" id="writer" name="writer"
					title="작성자는 2~10 글자 사이로 입력하셔야 합니다.">
			</div>
			<button>등록</button>
			<button type="reset">다시입력</button>
			<button onclick="history.back()">취소</button>
		</form>
	</div>
</body>
</html>