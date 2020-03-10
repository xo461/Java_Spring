<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 폼</title>
<!-- ckeditor cdn -->
<script src="https://cdn.ckeditor.com/4.14.0/standard-all/ckeditor.js"></script>
<!-- <script src=${path}/ckeditor/ckeditor.js"></script> -->

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
		<form action="write.do" method="post" id="writeForm"
			enctype="multipart/form-data">

			<input type="hidden" value="${login.id }" name="id">
			<div class="form-group">
				<input type="text" id="title" name="title"
					title="제목을 4~100 글자 사이로 입력하셔야 합니다.">
			</div>
			<div class="form-group">
				<input type="text" id="writer" name="writer"
					title="작성자는 2~10 글자 사이로 입력하셔야 합니다.">
			</div>
			<div class="form-group">
				<textarea name="content" id="content" rows="10" cols="80">
                This is my textarea to be replaced with CKEditor.
        </textarea>
			</div>
			<script>
				// Replace the <textarea id="content"> with a CKEditor
				// instance, using default configuration.
				CKEDITOR.replace('content', {
					filebrowserImageUploadUrl : '${path}/image/imageupload.do' //이 경로로 파일 전달
				});
				/* 	window.parent.CKEDITOR.tools.callFunction('${CKEditorFuncNum}',"${url}", "전송완료");  */
			</script>

			<div class="form-group">
				<label for="file">File</label> <a href="#this" onclick="addFile()"
					class="fileAdd_btn">Add a file</a>
				<div id="file-list">
					<input type="file" name="file" /> <a href='#this'
						name='file-delete'>Remove</a>
				</div>
			</div>
			<button>Submit</button>
			<!-- form tag안에 있으니 default type은 submit이므로 별도로 설정해주지 않아도 된다. -->
			<button type="button" onclick="history.back()">Back to list</button>





			<script
				src="${pageContext.request.contextPath}/resources/ckeditor.js"></script>
		</form>
	</div>



</body>
</html>
