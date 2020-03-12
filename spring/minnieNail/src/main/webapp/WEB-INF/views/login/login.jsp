<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-1.12.1.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/js/naveridlogin_js_sdk_2.0.0.js"></script>


<!-- 네이버로그인css -->
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

<!-- bootstrap sns로그인 -->
<style type="text/css">
* {
	box-sizing: border-box
}

/* style the container */
.container {
	position: relative;
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px 0 30px 0;
}

/* style inputs and link buttons */
input, .btn {
	width: 100%;
	padding: 12px;
	border: none;
	border-radius: 4px;
	margin: 5px 0;
	opacity: 0.85;
	display: inline-block;
	font-size: 17px;
	line-height: 20px;
	text-decoration: none; /* remove underline from anchors */
}

input:hover, .btn:hover {
	opacity: 1;
}

/* add appropriate colors to fb, twitter and google buttons */
.fb {
	background-color: #3B5998;
	color: white;
}

.twitter {
	background-color: #55ACEE;
	color: white;
}

.google {
	background-color: #dd4b39;
	color: white;
}

/* style the submit button */
input[type=submit] {
	background-color: #4CAF50;
	color: white;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

/* Two-column layout */
.col {
	float: left;
	width: 50%;
	margin: auto;
	padding: 0 50px;
	margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

/* vertical line */
.vl {
	position: absolute;
	left: 50%;
	transform: translate(-50%);
	border: 2px solid #ddd;
	height: 175px;
}

/* text inside the vertical line */
.inner {
	position: absolute;
	top: 50%;
	transform: translate(-50%, -50%);
	background-color: #f1f1f1;
	border: 1px solid #ccc;
	border-radius: 50%;
	padding: 8px 10px;
}

/* hide some text on medium and large screens */
.hide-md-lg {
	display: none;
}

/* bottom container */
.bottom-container {
	text-align: center;
	background-color: #666;
	border-radius: 0px 0px 4px 4px;
}

/* Responsive layout - when the screen is less than 650px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 650px) {
	.col {
		width: 100%;
		margin-top: 0;
	}
	/* hide the vertical line */
	.vl {
		display: none;
	}
	/* show the hidden text on small screens */
	.hide-md-lg {
		display: block;
		text-align: center;
	}
}
</style>
<script type="text/javascript">
	//로그인 정보 부정확시 메시지 팝업
	if ("${msg}") {
		window.alert("${msg}");
	}
</script>
</head>

<body>

	<div class="container">
		<div class="header clearfix">
			<h3 class="text-muted">Unleash your inner artist with MinnieNail</h3>
		</div>
		<div class="row">
			<h2 style="text-align: center">Login with Social Media or
				Manually</h2>
			<div class="vl">
				<span class="vl-innertext">or</span>
			</div>

			<div class="col">
				<a href="#" class="fb btn"> <i class="fa fa-facebook fa-fw"></i>
					Login with Facebook
				</a> <a href="#" class="twitter btn"> <i class="fa fa-twitter fa-fw"></i>
					Login with Twitter
				</a> <a href="#" class="google btn"> <i class="fa fa-google fa-fw"></i>
					Login with Google+
				</a> <a id="naverIdLogin_loginButton" href="${url}"> <img
					src="https://static.nid.naver.com/oauth/big_g.PNG?version=js-2.0.0"
					height="43.98"></a>
			</div>

			<div class="col">
				<div class="hide-md-lg">
					<p>Or sign in manually:</p>
				</div>

				<form action="/login/normallogin.do" method="post">
					<input type="text" name="userName" placeholder="Username" required>
					<input type="password" name="pw" placeholder="Password" required>
					<input type="submit" value="Login">
				</form>
				<div>
					<span></span>
				</div>


			</div>
		</div>
	</div>

	<div class="bottom-container">
		<div class="row">
			<div class="col">
				<a href="/login/signup.do" style="color: white" class="btn">Sign up</a>
			</div>
			<div class="col">
				<a href="#" style="color: white" class="btn">Forgot password?</a>
			</div>
		</div>
	</div>






	<script>
		//네아로
		var naverLogin = new naver.LoginWithNaverId({
			/* clientId : "e5mCPDnVvHz5Ekhetc6r",*/
			clientId : "JBa7U4P0ATdyXYHr5WAg",
			callbackUrl : "http://localhost/login/callback.do",
			isPopup : false,
			loginButton : {
				color : "green",
				type : 3,
				height : 60
			}
		});
		/* (4) 네아로 로그인 정보를 초기화하기 위하여 init을 호출 */
		naverLogin.init();

		/* (4-1) 임의의 링크를 설정해줄 필요가 있는 경우 */
		$("#gnbLogin").attr("href", naverLogin.generateAuthorizeUrl());
		/* (5) 현재 로그인 상태를 확인 */
		window.addEventListener('load', function() {
			naverLogin.getLoginStatus(function(status) {
				if (status) {
					/* (6) 로그인 상태가 "true" 인 경우 로그인 버튼을 없애고 사용자 정보를 출력합니다. */
					setLoginStatus();
				}
			});
		});
		/* (6) 로그인 상태가 "true" 인 경우 로그인 버튼을 없애고 사용자 정보를 출력합니다. */
		function setLoginStatus() {
			var profileImage = naverLogin.user.getProfileImage();
			var nickName = naverLogin.user.getNickName();
			$("#naverIdLogin_loginButton").html(
					'<br><br><img src="' + profileImage + '" height=50 /> <p>'
							+ nickName + '님 반갑습니다.</p>');
			$("#gnbLogin").html("Logout");
			$("#gnbLogin").attr("href", "#");
			/* (7) 로그아웃 버튼을 설정하고 동작을 정의합니다. */
			$("#gnbLogin").click(function() {
				naverLogin.logout();
				location.reload();
			});
		}
	</script>



</body>
</html>