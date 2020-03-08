<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 폼</title>rnote
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.16/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.16/dist/summernote.min.js"></script>
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script> 
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
	<link href="./dist/summernote.css" rel="stylesheet">
	<script src="./dist/summernote.js"></script>
 	<script type="text/javascript">
        /* summernote에서 이미지 업로드시 실행할 함수 */
	 	function sendFile(file, editor) {
            // 파일 전송을 위한 폼생성
	 		data = new FormData();
	 	    data.append("uploadFile", file);
	 	    $.ajax({ // ajax를 통해 파일 업로드 처리
	 	        data : data,
	 	        type : "POST",
	 	        url : "./summernote_imageUpload.jsp",
	 	        cache : false,
	 	        contentType : false,
	 	        processData : false,
	 	        success : function(data) { // 처리가 성공할 경우
                    // 에디터에 이미지 출력
	 	        	$(editor).summernote('editor.insertImage', data.url);
	 	        }
	 	    });
	 	}
	</script>

 
 
 
 
<%--  
 
 
 <!--<%@ page language="java" contentType="text/html; charset=UTF-8"
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

	<form action="write.do" method="post" enctype="multipart/form-data">
		<input type="hidden" value="${login.id }" name="id"> <input
			type="text" id="title" name="title"
			title="제목을 4~100 글자 사이로 입력하셔야 합니다."> <input type="text"
			id="writer" name="writer" title="작성자는 2~10 글자 사이로 입력하셔야 합니다.">
		<textarea name="content" id="editor1" rows="10" cols="80">
                This is my textarea to be replaced with CKEditor.
        </textarea>
		<script>
			// Replace the <textarea id="editor1"> with a CKEditor
			// instance, using default configuration.
			CKEDITOR.replace('editor1', {
				filebrowserImageUploadUrl : '${path}/image/imageupload.do' //이 경로로 파일 전달
			});
/* 	window.parent.CKEDITOR.tools.callFunction('${CKEditorFuncNum}',
					"${url}", "전송완료");  */
			 
		</script>
		<script type='text/javascript'>

 		
/*    			window.parent.CKEDITOR.tools.callFunction(" + 
    		callback + ",'" + fileUrl + "','이미지를 업로드 하였습니다.'" + ")
 */		</script>


		<input type="file" name="file" id="file"> <input type="submit">
		<script src="${pageContext.request.contextPath}/resources/ckeditor.js"></script>

	</form>



















	<div class="container">
		<!-- container가 있어야 자동레이아웃을 잡아줘서 사이드에 여백이 생긴다. -->
		<h1>글쓰기</h1>
		<!-- url 작성시 *.do :  spring 3.1까지의 기본 url에 *.do pattern 기본으로 사용 -->
		<form action="write.do" method="post" id="writeForm"
			enctype="multipart/form-data">
			<div class="form-group">
				<input type="hidden" value="${login.id }" name="id"> <label
					for="title">Title</label>
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
					<input type="file" name="file" /> <a href='#this'
						name='file-delete'>삭제</a>
				</div>
			</div>

			<button>Submit</button>
			<!-- form tag안에 있으니 default type은 submit이므로 별도로 설정해주지 않아도 된다. -->
			<button type="button" onclick="history.back()">Back to list</button>
		</form>
	</div>
</body>
</html>  -->




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

</head>
<body>
	<div class="container">


	<form name="writeForm" action="./summernote_insert.jsp" method="post">
		<textarea id="summernote">Hello Summernote</textarea>
        <script>
            $(document).ready(function() {
                $('#summernote').summernote({ // summernote를 사용하기 위한 선언
                    height: 400,
					callbacks: { // 콜백을 사용
                        // 이미지를 업로드할 경우 이벤트를 발생
					    onImageUpload: function(files, editor, welEditable) {
						    sendFile(files[0], this);
						}
					}
				});
			});
		</script>
</form>


	</div>
</body>
</html> --%>