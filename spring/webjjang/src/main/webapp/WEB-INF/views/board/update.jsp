<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Webjjang:: Board Update</title>
</head>
<body>
	<div class="container">
		<h3>Board Update</h3>
		<form action="update.do" method="post" id="updateForm">
			<!-- bootstrap사용(w3schools): form그룹 안에 form-group만들어서 그안에 form-control이 있어야 한다. -->
			<div class="form-group">
				<label for="no">No</label>
				<!-- name을 dto이름과 맞춰야 한다. 
				글번호: 수정불가 -->
				<input type="text" class="form-control" id="no" name="no"
					value="${dto.no }" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="title">Title</label>
				<input type="text" class="form-control" id="title" name="title"
					title="제목을 4~100 글자 사이로 입력하셔야 합니다."
					value="${dto.title }">
			</div>
			<div class="form-group">
				<label for="content">Content</label>
				<textarea class="form-control" rows="5" id="content" name="content">${dto.content }</textarea>
			</div>
			<div class="form-group">
				<label for="writer">Writer</label> <input type="text"
					class="form-control" id="writer" name="writer" autocomplete="off"
					title="작성자는 4~10 글자 사이로 입력하셔야 합니다." value="${dto.writer }">
			</div>
			<div class="form-group">
				<label for="pw">Password</label> <input type="password"
					class="form-control" id="pw" name="pw" autocomplete="off"
					title="비밀번호는 4~20 글자 사이로 입력하셔야 합니다." pattern="^.{4,20}$">
			</div>
			<button>Submit</button>
			<button type="reset">Reset</button>
			<button class="cancelBtn" type="button">Cancel</button>
		</form>
	</div>
</body>
</html>