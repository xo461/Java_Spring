<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 폼</title>
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

	$(document).ready(function() {
		$("a[name='file-delete']").on("click", function(e) {
			e.preventDefault();
			deleteFile($(this));
		});
	})

	function addFile() {
		var fileIndex = 1;
		var str = "<div class='file-group'><input type='file' name='file'><a href='#this' name='file-delete'>삭제</a></div>";
		$("#file-list").append(str);
		$("a[name='file-delete']").on("click", function(e) {
			e.preventDefault();
			deleteFile($(this));
		});
	}

	function deleteFile(obj) {
		obj.parent().remove();
	}
</script>
</head>
<body>
	<div class="container">
		<!-- container가 있어야 자동레이아웃을 잡아줘서 사이드에 여백이 생긴다. -->
		<h1>글쓰기</h1>
		<!-- url 작성시 *.do :  spring 3.1까지의 기본 url에 *.do pattern 기본으로 사용 -->
		<form action="write.do" method="post" id="writeForm"
			enctype="multipart/form-data">
			<div class="form-group">
				<label for="title">Title</label>
				<!-- 입력한 데이터의 앞뒤 공백문자는 제거(trim())
    			 id, class : 화면 컨트롤을 위해서(빠른 선택), name : 넘어가는 데이터 이름 -->
				<!-- 			<input type="text" class="form-control" id="title" name="title" -->
				<!-- 				required="required" pattern="^.{4,100}$" -->
				<!-- 				title="제목을 4~100 글자 사이로 입력하셔야 합니다."> -->
				<input type="text" class="form-control" id="title" name="title"
					title="제목을 4~100 글자 사이로 입력하셔야 합니다.">
			</div>
			<div class="form-group">
				<label for="content">Content</label>
				<textarea class="form-control" rows="5" id="content" name="content"></textarea>
			</div>
			<div class="form-group">
				<label for="writer">Writer</label>
				<!-- 입력한 데이터의 앞뒤 공백문자는 제거(trim())
    			 id, class : 화면 컨트롤을 위해서(빠른 선택), name : 넘어가는 데이터 이름 -->
				<input type="text" class="form-control" id="writer" name="writer"
					title="작성자는 2~10 글자 사이로 입력하셔야 합니다.">
			</div>
			<div class="form-group">
				<label for="file">File</label> <a href="#this" onclick="addFile()"
					class="fileAdd_btn">파일추가</a>
				<div id="file-list">
					<input type="file" name="file"/> <a href='#this'
						name='file-delete'>삭제</a>
				</div>
			</div>

			<button>Submit</button>
			<!-- form tag안에 있으니 default type은 submit이므로 별도로 설정해주지 않아도 된다. -->
			<button type="button" onclick="history.back()">Back to list</button>
		</form>
	</div>
</body>
</html>