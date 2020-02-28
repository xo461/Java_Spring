<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko"><head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>NaverLoginSDK Test with BootStrap</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<style type="text/css">
	.header,body{padding-bottom:20px}.header,.jumbotron{border-bottom:1px solid #e5e5e5}body{padding-top:20px}.footer,.header,.marketing{padding-right:15px;padding-left:15px}.header h3{margin-top:0;margin-bottom:0;line-height:40px}.footer{padding-top:19px;color:#777;border-top:1px solid #e5e5e5}@media (min-width:768px){.container{max-width:730px}}.container-narrow>hr{margin:30px 0}.jumbotron{text-align:center}.jumbotron .btn{padding:14px 24px;font-size:21px}.marketing{margin:40px 0}.marketing p+h4{margin-top:28px}@media screen and (min-width:768px){.footer,.header,.marketing{padding-right:0;padding-left:0}.header{margin-bottom:30px}.jumbotron{border-bottom:0}}
	</style>

</head>

<body>

	<div class="container">
		<div class="header clearfix">
			<nav>
				<ul class="nav nav-pills pull-right">
					<li role="presentation" class="active"><a href="#">Home</a></li>
					<li role="presentation"><a id="gnbLogin" href="https://nid.naver.com/oauth2.0/authorize?response_type=token&amp;client_id=jyvqXeaVOVmV&amp;state=4efae0ff-80db-464f-9cc9-9a190277b3ed&amp;redirect_uri=http%3A%2F%2Fstatic.nid.naver.com%2Foauth%2Fsample%2Fcallback.html&amp;version=js-2.0.0&amp;svctype=1">Login</a></li>
				</ul>
			</nav>
			<h3 class="text-muted">Login With NaverID Javascript SDK</h3>
		</div>

		<div class="jumbotron">
			<h1>SAMPLE PAGE</h1>
			<p class="lead">네이버 아이디로 로그인 Javascript 샘플 페이지.<br> 간단한 적용 예제를 포함합니다.</p>
			<!-- (1) 버튼 event 처리를 위하여 id를 지정 id=loginButton -->
			<p>
				</p><div id="naverIdLogin"><a id="naverIdLogin_loginButton" href="#"><img src="https://static.nid.naver.com/oauth/big_g.PNG?version=js-2.0.0" height="60"></a></div>
			<p></p>
		</div>

		<div class="row marketing">
			<div class="col-lg-6">
				<h4>네이버 아이디로 로그인</h4>
				<p>별도의 아이디, 비밀번호없이 네이버 아이디로 간편하게 외부 서비스에 로그인 할 수 있도록 하는 서비스입니다. 이용자는 복잡하고 번거로운 회원 가입 절차 없이 편하게 서비스를 이용하고, 사업자는 회원 가입, 로그인에
					대한 허들을 낮춰 회원수가 늘고 매출은 오르는 경험을 할 수 있습니다. </p>

				<h4>다양한 사용자 정보를 손쉽게 조회</h4>
				<p>이름, 이메일, 별명, 생일, 연령대, 성별 등을 API로 간단한 조회를 통해 많은 사용자의 정보를 손쉽게 얻을 수 있습니다. 또한 블로그 등 다양한 네이버 서비스 들로 매시업이 가능합니다. </p>
			</div>

			<div class="col-lg-6">
				<h4>4,200만 네이버 회원을 여러분의 사용자로!</h4>
				<p>네이버 회원이라면, 여러분의 사이트를 간편하게 이용할 수 있습니다. 전 국민 모두가 가지고 있는 네이버 아이디 한개만 있으면 별도 가입없이 어떤 플랫폼에서도 간편하게 로그인할 수 있습니다. </p>

				<h4>빠른개발, 간편한 운영</h4>
				<p>플랫폼 별 SDK를 제공하여 쉽고 빠르게 개발할 수 있도록 지원합니다. 또한 환경별 로그인, 누적 사용자 등 다양한 통계를 제공하여 성과를 확인할 수 있습니다. </p>
			</div>
		</div>

		<footer class="footer">
		</footer>

	</div>
	<!-- /container -->
	<script src="https://code.jquery.com/jquery-1.12.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<!-- (2) LoginWithNaverId Javscript SDK -->
	<script src="/js/naveridlogin_js_sdk_2.0.0.js"></script>

	<!-- (3) LoginWithNaverId Javscript 설정 정보 및 초기화 -->
	<script>
		
		var naverLogin = new naver.LoginWithNaverId(
			{
				clientId: "e5mCPDnVvHz5Ekhetc6r",
				callbackUrl: "http://localhost/member/loginPostNaver.do",
				isPopup: false,
				loginButton: {color: "green", type: 3, height: 60}
			}
		);
		/* (4) 네아로 로그인 정보를 초기화하기 위하여 init을 호출 */
		naverLogin.init();
		
		/* (4-1) 임의의 링크를 설정해줄 필요가 있는 경우 */
		$("#gnbLogin").attr("href", naverLogin.generateAuthorizeUrl());

		/* (5) 현재 로그인 상태를 확인 */
		window.addEventListener('load', function () {
			naverLogin.getLoginStatus(function (status) {
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
			$("#naverIdLogin_loginButton").html('<br><br><img src="' + profileImage + '" height=50 /> <p>' + nickName + '님 반갑습니다.</p>');
			$("#gnbLogin").html("Logout");
			$("#gnbLogin").attr("href", "#");
			/* (7) 로그아웃 버튼을 설정하고 동작을 정의합니다. */
			$("#gnbLogin").click(function () {
				naverLogin.logout();
				location.reload();
			});
		}
	</script>



</body></html>

<%-- 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- '네이버 아이디로 로그인하기' 버튼 -->
 	<!-- 원하는 곳에 넣습니다. -->
	<div id="naver_id_login"></div>
	
	<!-- 네이버아이디로로그인 버튼 노출 영역 -->
	<script type="text/javascript">
 		var naver_id_login = new naver_id_login("e5mCPDnVvHz5Ekhetc6r", "http://localhost");	// Client ID, CallBack URL 삽입
											// 단 'localhost'가 포함된 CallBack URL
 		var state = naver_id_login.getUniqState();
		
 		naver_id_login.setButton("white", 2, 40);
 		naver_id_login.setDomain("http://127.0.0.1");	//  URL
 		naver_id_login.setState(state);
 		naver_id_login.setPopup();
 		naver_id_login.init_naver_id_login();
	</script>
</head>
<body>
test
</body>
</html> --%>