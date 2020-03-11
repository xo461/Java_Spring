<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Webjjang:: Gallary</title>
</head>
<body>
	<div class="container">
		<h3>Upload Image</h3>
		<form action="write.do" method="post" id="writeForm"
			enctype="multipart/form-data">
			<!-- bootstrap사용(w3schools): form그룹 안에 form-group만들어서 그안에 form-control이 있어야 한다. -->
			<div class="form-group">
				<label for="title">Title</label>
				<!-- name을 dto이름과 맞춰야 한다. -->
				<input type="text" class="form-control" id="title" name="title"
					title="제목을 4~100 글자 사이로 입력하셔야 합니다.">
			</div>
			<div class="form-group">
				<label for="content">Content</label>
				<textarea class="form-control" rows="5" id="content" name="content"></textarea>
			</div>

			<!-- login사용: controller에서 session사용 -->

			<div class="form-group">
				<label for="multiFile">File</label> <input type="file"
					class="form-control" id="multiFile" name="multiFile" required="required">
			</div>
			<button>Submit</button>
			<button type="reset">Reset</button>
			<button class="cancelBtn" type="button">Cancel</button>
		</form>
	</div>
</body>
</html>