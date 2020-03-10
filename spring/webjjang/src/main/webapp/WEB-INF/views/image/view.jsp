<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Webjjang:: Board View</title>
<style type="text/css">
.dataRow:hover {
	background-color: #eee;
	cursor: pointer;
}
#pwDiv{display: none;} /*비밀번호받는태그 일단 숨겨놓고 밑에 jquery에서 삭제버튼누르면보이게  */
</style>
<script type="text/javascript">
	$(function() {
		$("#deleteBtn").click(function(){
			$("#pwDiv").show(); //css에서 태그 숨겨놓았음. 삭제버튼클릭시 보이게 한다.
			//href="" -> 자신을 다시 호출함 -> false: 호출을 무시한다.
			return false;
			});
	})
</script>
</head>
<body>
	<div class="container">


		<h3>Board View</h3>
		<!-- table에 부트스트랩적용: clss명 table로 지정하면 된다. -->
		<table class="table">
			<tr>
				<th>No</th>
				<!-- dto.no는 getNo()를 호출한것임. 이걸 property라고 한다. -->
				<td>${dto.no }</td>
			</tr>
			<tr>
				<th>Title</th>
				<td>${dto.title }</td>
			</tr>
			<tr>
				<th>Writer</th>
				<td>${dto.writer }</td>
			</tr>

			<tr>
				<th>Write date</th>
				<td><fmt:formatDate value="${dto.writeDate}"
						pattern="yyyy.MM.dd" /></td>
			</tr>
			<tr>
				<th>Hit</th>
				<td>${dto.hit }</td>
			</tr>
			<tr>
				<th>Content</th>
				<td><pre>${dto.content }</pre></td>
			</tr>
			<tr>
				<td colspan="2">
					<!-- role은 bootstrap적용 위함(w3schools에서확인), class btn뒤에 btn-default도 w3schools에서 주는 스타일 확인 후 적용 -->
					<a href="update.do?no=${dto.no }" class="btn btn-default" role="button">Update</a> 
					<a href="" id="deleteBtn" class="btn btn-default" role="button">Delete</a>
					<a href="list.do" class="btn btn-default" role="button">Back to List</a>
					
					<!-- pw입력받기 (id로 css에서 숨겨놨다가 버튼클릭하면 jquery에서 보이게-->
					<div id="pwDiv">
						<form action="delete.do" method="post"><!-- 비번따문에 post로 넘겨야 해서 form 태그나 ajax로 넘겨야한다. -->
							<input type="hidden" name="no" value="${dto.no }" /><!-- controller에 아이디를 넘겨야 삭제되므로 hidden으로 넘긴다.  -->
							<div class="form-group">
								<label for="pw">Password:</label>
								<input type="password" class="form-control" id="pw" name="pw" autocomplete="off"
									title="비밀번호는 4~20 글자 사이로 입력하셔야 합니다." pattern="^.{4,20}$">
							</div>
						<button>Delete</button>
						</form>
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>