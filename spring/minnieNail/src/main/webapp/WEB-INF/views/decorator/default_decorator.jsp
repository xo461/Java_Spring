<!-- sitemesh 사용을 위한 설정 파일 -->
<!-- 작성자 : 유민아 -->
<!-- 작성일 : 2020-02-24 -->
<!-- 최종수정일 : 2020-02-24 -->


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!-- jstl: jsp별로 따로 설정한다. -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MinnieNail::<decorator:title /></title>


<!-- web라이브러리: 공통으로 사용: 여기서만 선언해주면 된다. bootstrap 사이트에서 최신버전으로 복붙한다. -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- jQuery UI: datepicker -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- icons: w3schools에서 복붙. Awesome5, 4, Bootstrap, Google iCOn -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>

<!-- ajax modal용 라이브러리 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
 

<style type="text/css">
header, footer {
	background: AntiqueWhite;
}

pre {
	background: white;
	border: 0px;
}

/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
}

.carousel-inner img {
	width: 100%; /* Set width to 100% */
	margin: auto;
	min-height: 200px;
}

/* Hide the carousel text when the screen is less than 600 pixels wide */
@media ( max-width : 600px) {
	.carousel-caption {
		display: none;
	}
}

article {
	min-height: 795px;
}

#welcome {
	color: grey;
	margin: 0 auto;
}
</style>
<script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
});
</script>
<decorator:head />
<!-- head안에 있어야 잘 동작 -->
</head>
<body>
	<header>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/main/main.do">MinnieNail</a>
					<a href="https://www.instagram.com/minnienailarts/"><i class='fab fa-instagram' style='font-size:35px;color:white'></i></a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<li><a href="${absUri }/notice/list.do">Notice</a></li>
						<li><a href="${absUri }/board/list.do">Board</a></li>
						<li><a href="${absUri }/image/list.do">Nail Pics</a></li>
						<li><a href="${absUri }/reserve/list.do">Message</a></li>
						<li><a href="${absUri }/member/list.do">Member</a></li>
						<%-- <c:if test="${!empty login }">
							<c:if test="${login.gradeNo==9 }">
								<li><a href="${absUri }/member/list.do">회원관리</a></li>
								<li><a href="${absUri }/schedule/view.do">스케줄 관리</a></li>
							</c:if>
						</c:if> --%>
						<!-- 요기에 관리자메뉴 작성한다. -->
						<%-- <c:if test="${login.gradeNo==9 }"> --%>
						<%-- </c:if> --%>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<c:if test="${empty login }">
							<li><a href="${absUri }/login/signup.do">Sign-up</a></li>
							<li><a href="${absUri }/login/login.do"><span
									class="glyphicon glyphicon-log-in"></span> Sign-in</a></li>
						</c:if>
						<c:if test="${!empty login }">
							<li id="welcome">Welcome, ${login.nickName}! <img alt="" src="${login.sns_profile}" height="30px" style="border-radius: 70%"> <a href="${absUri }/member/view.do?id=${login.id}">MyPage</a></li>
							<li><a href="${absUri }/login/signout.do" ><span
									class="glyphicon glyphicon-log-in" id="signout"></span> Sign-out</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<article>
		<decorator:body />
	</article>
	<footer class="container-fluid text-center">
		<p>©MinnieNail</p>
		
	</footer>
</body>
</html>