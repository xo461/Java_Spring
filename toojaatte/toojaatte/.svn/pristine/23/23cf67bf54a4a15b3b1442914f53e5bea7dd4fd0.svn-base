<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글수정</title>
</head>
<body>
	<h1>게시판 글수정</h1>
	<form method="post" action="update.do" id="updateForm">
		<!-- bootstrap의 폼 : form-> form-group -> form-control -->
		<!-- 넘겨질 글번호 : 수정불가(readonly) -->
		<div class="form-group">
			<label for="no">글번호</label>
			<input type="text" class="form-control" id="no" name="no"
				value="${dto.no }" readonly="readonly">
		</div>
		<!-- 제목 입력 -->
		<div class="form-group">
			<label for="title">제목</label>
			<input type="text" class="form-control" id="title" name="title"
				value="${dto.title }" title="제목을 4~100 글자 사이로 입력하셔야 합니다.">
		</div>
		<!-- 내용 입력 -->
		<div class="form-group">
			<label for="content">내용</label>
			<textarea class="form-control" rows="5" id="content" name="content">${dto.content }</textarea>
		</div>
		<!-- 작성자(익명-제한없이 아무거나 입력 가능) -->
		<div class="form-group">
			<label for="writer">작성자</label>
			<input type="text" class="form-control" id="writer" name="writer"
				autocomplete="off" value="${dto.writer }" title="작성자는 4~10 글자 사이로 입력하셔야 합니다.">
		</div>
		<!-- 비밀번호 입력 - 별로 중요하지 않으므로 보이도록 처리한다. 나중에 확인용 비밀번호는 안보이게 처리. -->
		<div class="form-group">
			<label for="pw">비밀번호:자신글 확인용</label>
			<input type="password" class="form-control" id="pw" name="pw"
			 autocomplete="off" title="비밀번호는 4~20 글자 사이로 입력하셔야 합니다." pattern="^.{4,20}$">
		</div>
		<!-- 버튼 처리 : button은 기본 type이 submit이다.(데이터 넘기는 함수 호출)-->
		<button>수정</button>
		<button type="reset">다시입력</button>
		<button class="cancelBtn" type="button">취소</button>
		
	</form>
</body>
</html>