<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>menu.jsp</title>
</head>
<body>
<h2>구매CD를 고르세요</h2>

<form method="post">
<select name="item">
	<option value="bts">bts</option>
	<option value="Justin Bieber">Justin Bieber</option>
	<option value="Pitbull">Pitbull</option>
	<option value="Ariana Grande">Ariana Grande</option>
	<option value="아이유">아이유</option>
</select>

<!-- 장바구니에 추가 -->
	<input type="hidden" name="step" value="add">
	<input type="submit"  value="select">
</form>
</body>
</html>