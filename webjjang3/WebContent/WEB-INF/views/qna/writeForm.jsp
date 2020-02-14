<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>질문하기 폼</title>
</head>
<body>

	<div class="container">


		<h1>질문하기</h1>

		<!-- 많은 데이터를 넘길 때 : form --post방식...-->

		<form action="write.do" method="post">
			<!-- input, select, textarea: 입력항목만들기: 생략 -->


			<fieldset disabled>
				<div class="form-group row">
					<div class="col-md-2">
						<label for="id">아이디:</label>
						<textarea class="form-control" id="id" name="id" 
						type="text"> ${login.id }</textarea>
					</div>
				</div>

			</fieldset>

	<!-- 제목: 한줄짜리, 키보드로 입력 -->
			<div class="form-group">
				<label for="title">제목:</label> 
				<input type="text"
					class="form-control" id="title" name="title">
			</div>

			<!-- 			내용 입력: 여러줄, 키보드로 입력 -->
			<div class="form-group">
				<label for="content">내용:</label>
				<textarea class="form-control" rows="5" id="content" name="content"></textarea>
				<br/>
			</div>

		<!-- 			submit 호출데이터를 넘겨준다. / reset: value속성이 없으면 비워진 상태, value속성이 있으면 value의 값으로 셋팅.
button: 형태만 버튼이고 아무런 동작을 하지 않는다. 동작은 따로 정의한다.  -->
			<!-- button tag의 기본 타입은 submit이다. 그래서 생략 가능  -->
	<button type="submit" class="btn btn-default">등록</button>
			<button type="reset" class="btn btn-default">다시입력</button>
			<button type="button" class="btn btn-default"
				onclick="history.back()">취소</button>

			<!-- 버튼기능만 사용하고 다른동작은 하지 않도록: button -->
			<!-- 동작을 따로 정의 onclick 클릭했을때 동작. history.back : 이전페이지로 가자. -->



		</form>
	</div>

<%-- 			<% --%>
// 				if (session.getAttribute("login") != null) {
<%-- 			%> --%>

<%-- 	<% --%>
// 		} else {
<%-- 	%> --%>

<%-- 	<% --%>
// 		response.sendRedirect("/member/loginForm.do");
// 		}
<%-- 	%> --%>


</body>
</html>