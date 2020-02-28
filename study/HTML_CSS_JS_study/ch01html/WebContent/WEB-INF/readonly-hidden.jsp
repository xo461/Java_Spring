<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<ti5tle>Read Only / Hidden</title>
</head>
<body>
	<form action="accept.jsp">
		<!-- 데이터는 넘어가나 사용자에게는 보이지 않게 함 -->
		<input type="hidden" value="3" name="refNo"/>

		<!-- readonly : 수정 불가 설정 -->
		글번호: <input type="text" value="10" readonly="readonly"
			onkeydown="alert('수정이 안되는 항목입니다.')" name="no"/><br />
			<button>답변달기</button>
	</form>
</body>
</html>