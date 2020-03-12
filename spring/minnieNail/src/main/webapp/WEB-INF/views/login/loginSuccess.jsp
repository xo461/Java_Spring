<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="ko">
<head>
<!-- 3초 뒤 메인페이지로 이동 -->
<meta http-equiv="refresh" content="3; url=/main/main.do">
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<style type="text/css">
</style>

</head>
<body>
<br/>
	<div class="container">
		<div id="welcome">
			Welcome, ${login.nickName}! <img alt="" src="${login.sns_profile }"
				height="30px" style="border-radius: 70%">
		</div>
	</div>
</body>
</html>