<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<!-- bootstrap 라이브러리 등록: CDN 방식 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>


</head>
<body>



	<div class="container">


		<h1 style="border: 3px solid red">로그인</h1>
		<form action="login.jsp" method="post">


			<!-- header - h1 : 첫번째 나오는 제목 -->

			<!-- 태그에 css적용 -->
			<!-- 개인정보 공개하면 안되므로 post방식 -->
			<!-- maxlength 최대입력글자수 pattern 입력글자의 형식 -->
			<!-- title 마우스를 올려놨을때의 메시지, 또는 형식에 맞지 않을 때의 메시지 -->

			<div class="form-group">
				<label for="id">아이디:</label> <input type="text" class="form-control"
					id="id" placeholder="아이디 입력" name="id" required="required"
					pattern="^[A-Za-z][A-za-z0-9]{1,19}$" maxlength="20"
					title="2-20자 영숫자, 맨 앞자는 영문자" />
			</div>

			<!-- password비밀번호 표시 땡땡이로 해줌 -->
			<!-- .점은 모든 문자 입력 가능 $는 문장의 끝 -->
			<div class="form-group">
				<label for="pw">비밀번호:</label>
				 <input type="password"
					class="form-control" id="pw" placeholder="비밀번호 입력" name="pw"
					maxlength="20" required="required" pattern="^.{4,20}$"
					title="4-20이내의 글자 입력" />

			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</body>
</html>