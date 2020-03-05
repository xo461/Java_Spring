<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>NaverLoginSDK Test with BootStrap</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- modal용 library -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />


<style type="text/css">
.header, body {
	padding-bottom: 20px
}

.header, .jumbotron {
	border-bottom: 1px solid #e5e5e5
}

body {
	padding-top: 20px
}

.footer, .header, .marketing {
	padding-right: 15px;
	padding-left: 15px
}

.header h3 {
	margin-top: 0;
	margin-bottom: 0;
	line-height: 40px
}

.footer {
	padding-top: 19px;
	color: #777;
	border-top: 1px solid #e5e5e5
}

@media ( min-width :768px) {
	.container {
		max-width: 730px
	}
}

.container-narrow>hr {
	margin: 30px 0
}

.jumbotron {
	text-align: center
}

.jumbotron .btn {
	padding: 14px 24px;
	font-size: 21px
}

.marketing {
	margin: 40px 0
}

.marketing p+h4 {
	margin-top: 28px
}

@media screen and (min-width:768px) {
	.footer, .header, .marketing {
		padding-right: 0;
		padding-left: 0
	}
	.header {
		margin-bottom: 30px
	}
	.jumbotron {
		border-bottom: 0
	}
}
</style>




</head>

<body>

	<div class="container">
		<div class="header clearfix">
			<h3 class="text-muted">Unleash your inner artist with
				MinnieNail.</h3>
		</div>

		<div class="jumbotron">
			<h1>SIGN UP</h1>
			<p class="lead">
				Select sign-up format<br>
			</p>
			<!-- (1) 버튼 event 처리를 위하여 id를 지정 id=loginButton -->
			<p></p>
			<div id="naverIdLogin">
				<a id="naverIdLogin_loginButton" href="/login/login.do"> <img
					src="https://static.nid.naver.com/oauth/big_g.PNG?version=js-2.0.0"
					height="60"></a>
			</div>

			<!-- 일반회원가입: ajax 띄우기 -->
			<a class="btn" href="#sup"><button>Sign-up without SNS</button></a>

			<!-- 회원가입폼 : 모달로 뜬다. -->
			<div id="sup" class="modal">
				Please fill out the form.
				<div>
					<label>userName</label> <input type="text" name="userName"
						id="userName">
				</div>
				<div>
					<label>password</label> <input type="text" name="pw" id="pw">
				</div>
				<div>
					<label>email</label> <input type="text" name="email" id="email">
				</div>
				<div>
					<label>nickname</label> <input type="text" name="nickName"
						id="nickName">
				</div>
				<button id="sendInfo">send</button>
			</div>

			<script>
				//일반회원가입하기 클릭시 모달창띄우기
				$('a[href="#sup"]').click(function(event) {
					event.preventDefault();
					$(this).modal({
						fadeDuration : 250
					});
				});

				//회원가입버튼누르면 콘드롤러로 데이터전송하기
				$('#sendInfo').click(function() {
					$.ajax({
						type : "POST",
						url : "/member/signup.do",
						data : {
							"userName" : $('#userName').val(),
							"pw" : $('#pw').val(),
							"email" : $('#email').val(),
							"nickName" : $('#nickName').val()
						}
					});
				});

				/* 회원가입 성공,실패시 처리 어케?	$.modal.close();*/
			</script>

			<p></p>
		</div>

		<div class="row marketing">
			<div class="col-lg-6">
				<h4>Minnie</h4>
				<p>Nail</p>
			</div>
			<div class="col-lg-6">
				<h4>Minnie</h4>
				<p>Nail</p>
			</div>
		</div>
	</div>






	<!-- --------------------------- -->
	<%-- 	<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
		aria-labelledby="login-modal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<h1>로그인</h1>
					<br> <label for="login-id">아이디</label> <input
						class="form-control" type="text" id="login-id" name="username"
						placeholder="아이디" required="required"> <br /> <label
						for="login-pw">암호</label> <input class="form-control"
						type="password" id="login-pw" name="password" placeholder="비밀번호"
						required="required"> <br />
					<button type="button" id="login-btn" name="login"
						class="btn btn-default">로그인</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="board-modal" tabindex="-1" role="dialog"
		aria-labelledby="board-modal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<h1>글쓰기</h1>
					<br> <label for="login-id">제목</label> <input
						class="form-control" type="text" id="title" name="title"
						placeholder="제목" required="required"> <br /> <label
						for="login-pw">내용</label>
					<textarea class="form-control" name="editor" id="editor" rows="15"
						cols="80"></textarea>
					<script>
						CKEDITOR.replace('editor');
					</script>
					<br /> <input type="hidden" id="adminid" value="${id}">
					<button type="button" id="create" name="create"
						class="btn btn-default">제출</button>
				</div>
			</div>
		</div>
	</div>


	<script>
		$(document).ready(function() {
			$('#home').click(function() {
				$('#notice').removeClass("active");
				$(this).addClass("active");
				$('#myBoard').hide();
				$('.jumbotron').slideDown();
			});
			$('#notice').click(function() {
				$('#home').removeClass("active");
				$(this).addClass("active");
				$('.jumbotron').slideUp(function() {
					$('#myBoard').show();
				});
			});
			$('#login-btn').click(function() {
				$.ajax({
					type : "POST",
					url : "/loginProcessing",
					data : {
						"username" : $('#login-id').val(),
						"password" : $('#login-pw').val()
					},
					success : function() {
						alert('로그인 성공');
						location.reload();
					},
					error : function() {
						alert('로그인 정보가 올바르지 않습니다.');
					}
				});
			});
			$('#create').click(function() {
				CKupdate();
				$.ajax({
					type : "POST",
					url : "/createBoard",
					data : {
						"title" : $('#title').val(),
						"text" : $('#editor').val(),
						"id" : $('#adminid').val()
					},
					success : function() {
						alert('게시글 등록 성공');
						location.reload();
					},
					error : function() {
						alert('게시글 등록 실패');
					}
				});
			});
		});
		function CKupdate() {
			for (instance in CKEDITOR.instances)
				CKEDITOR.instances[instance].updateElement();
		}
	</script>





 --%>

	<!--------------------------------  -->







</body>
</html>