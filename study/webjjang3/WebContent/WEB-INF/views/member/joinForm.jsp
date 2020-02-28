<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<!-- bootstrap 라이브러리 등록: CDN 방식 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet"	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- #birth라고 이름 통일시켜서 사용해야 함 -->
<script>
	$(function() {
		//생년월일 날짜 캘린더 사용
		$("#birth").datepicker();
		$("#birth").datepicker("option", "dateFormat", "yy-mm-dd");
	
		//keyup이벤트 처리
		$("#id").on("keyup", function(){
// 			alert("아이디 입력");
			//입력한 아이디의 값을 가져와서 앞뒤 공백을 제거한다.
			var id = $("#id").val().trim();
			//공백을 제거한 아이디를 다시 아이디 입력란에 셋팅해준다.
			$("#id").val(id);
			if(id.length == 0){
				$("#idCheck").html("아이디를 입력하셔야만 합니다.");
			} else if(id.length < 4  || id.length > 20) {
				$("#idCheck").html("아이디는 4자 이상 20자 이내로 작성하셔야 합니다.");				
			} else{
				//Ajax를 이용해서 서버에 갔다오면서 결과를 idCheck에 넣는다. 
				$("#idCheck").load("/ajax/idCheck.do?id="+id);		
			}
		});//아이디 중복체크의 끝
	});
	//데이터를 넘기기 전 데이터 확인 처리
	$("#joinForm").on("submit", function(){
		if($("#idCheck").text().indexOf("사용 가능한") <= -1){
			alert("사용 가능한 아이디를 입력해 주세요.");
			
	}
	});
</script>
</head>
<body>
	<div class="container">
		<h1>회원가입</h1><br />
	<form action="join.do" method="post">

	<!-- 아이디입력-->
	<!-- 개인정보 공개하면 안되므로 post방식 -->
	<!-- maxlength 최대입력글자수 pattern 입력글자의 형식 -->
	<!-- title 마우스를 올려놨을때의 메시지, 또는 형식에 맞지 않을 때의 메시지 -->
	<div class="form-group">
		<label for="id">아이디:</label> 
		<input type="text" class="form-control"
			id="id" placeholder="아이디 입력" name="id" required="required"
			pattern="^[A-Za-z][A-za-z0-9]{1,19}$" maxlength="20"
			title="2-20자 영숫자, 맨 앞자는 영문자" autocomplete="off" />
		<div id="idCheck">아이디를 입력하셔야 합니다.</div>
	</div>

	<!-- 비밀번호 입력 -->
	<!-- password비밀번호 표시 땡땡이로 해줌 -->
	<!-- .점은 모든 문자 입력 가능 $는 문장의 끝 -->
	<div class="form-group">
		<label for="pw">비밀번호:</label> <input type="password"
			class="form-control" id="pw" placeholder="비밀번호 입력" name="pw"
			maxlength="20" required="required" pattern="^.{4,20}$"
			title="4-20이내의 글자 입력" />
	</div>



			<!-- 비밀번호 확인 -->
			<!-- password비밀번호 표시 땡땡이로 해줌 -->
			<!-- .점은 모든 문자 입력 가능 $는 문장의 끝 -->
			<div class="form-group">
				<label for="pw2">비밀번호 확인:</label> <input type="password"
					class="form-control" id="pw2" placeholder="비밀번호 입력" name="pw2"
					maxlength="20" required="required" pattern="^.{4,20}$"
					title="4-20이내의 글자 입력" />
			</div>


			<!-- 이름입력 -->
			<div class="form-group">
				<label for="name">이름:</label> <input type="text"
					class="form-control" id="name" placeholder="이름 입력" name="name"
					maxlength="10" required="required" pattern="^[가-힣]{2,10}$"
					title="2-10자 한글" />
			</div>


			<!-- 성별입력 -->
			<!-- input type, name이 같아야 함꼐 쌍으로 움직임 - 한개 체크시 한개 해제 -->
			<!-- 한쪽에만 checked 해놓으면 됨 -->
			<div class="form-group">
				<label for="gender">성별: </label> <label class="radio-inline">
					<input type="radio" name="gender" checked value="남자"> 남자
				</label> <label class="radio-inline"> <input type="radio"
					name="gender" value="여자">여자
				</label>
			</div>


			<!-- 생년월일입력 -->
			<!-- 패턴은 0-9중에서만 쓸수 있음{4}는 네자리, {1,2}는 한자리나 두자리 -->
			<div class="form-group">
				<label for="birth">생년월일:</label>
				<!-- input type= date이지만, bootstrap에서 날짜 형식 가져오면 형식 중복되므로 text형식으로 바꿔줌 -->
				<input type="text" class="form-control" id="birth"
					placeholder="생년월일 입력" name="birth" maxlength="10"
					required="required" pattern="^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$"
					title="날짜형식은 yyyy-mm-dd" />
			</div>


			<!-- 전화번호입력 -->
			<!-- 			form group row - 한 열을 3분할함... div class col - md - 3.. -->
			<!-- 패턴은 0-9중에서만 쓸수 있음{4}는 네자리, {1,2}는 한자리나 두자리 -->
			<div class="form-group row">
				<div class="col-md-2">
					<label for="tel">핸드폰: </label>
				</div>
				<div class="col-md-2">

					<select class="form-control" id="sel1" name="tel">
						<option selected="selected">010</option>
						<option>011</option>
						<option>016</option>
						<option>017</option>
						<option>018</option>
						<option>019</option>
					</select>
				</div>

				<div class="col-md-2">
					<input type="number" class="form-control" id="tel2"
						placeholder="3-4자리숫자" name="tel" maxlength="4" required="required"
						pattern="^[0-9]{3,4}$" title="숫자로 3-4자리 입력" />
					<!-- 	      패턴 0-9까지 입력 가능, 3~4자리 -->
				</div>

				<div class="col-md-2">

					<input type="number" class="form-control" id="tel3"
						placeholder="4자리숫자" name="tel" maxlength="4" required="required"
						pattern="^[0-9]{4}$" title="숫자로 4자리 입력" />
					<!-- 	      패턴 0-9까지 입력 가능, 4자리 -->
					<!-- 인터넷 익스플로러에서는 4자리로 잘리지만 크롬에서는 계속 보임 -->

				</div>
			</div>





			<!-- 이메일입력 -->
			<div class="form-group">
				<label for="email">이메일:</label> <input type="email"
					class="form-control" id="email" placeholder="이메일 입력" name="email"
					maxlength="50" required="required" /><br /> 이메일 형식 예:
				mayu11@naver.com
			</div>



			<button type="submit" class="btn btn-default">회원가입</button>
		</form>
	</div>
</body>
</html>