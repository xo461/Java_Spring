<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

/* dropdown보이게  */
.rownav {
	overflow: visible;
	zoom: 1.0;
}

.rownav:after {
	content: " ";
	display: block;
	clear: both;
	height: 0;
	visibility: hidden;
}

.dropdown-item:hover {
	background-color: #eee;
}
</style>
<script type="text/javascript">
	/*dropdown클릭하면 버튼의 내용을 dropdown내용으로 바꾸기*/
	$(function() {
		$(".dropdown-item").click(function() {
			$("#gradeBtn").attr("value", $(this).text());
		})
	})
</script>


</head>
<body>
	<div class="container">
		<h1>MinnieNail Admin Page</h1>
		<h4>MinnieNail Member List</h4>
		<br /> <br />
		<form action="manage.do" method="post">
			<table class="table">
				<tr>
					<th>id</th>
					<th>email</th>
					<th>username</th>
					<th>nickname</th>
					<th>sns_type</th>
					<th>sns_profile</th>
					<th>grade</th>
					<th>state</th>
					<th>created date</th>
					<th>modified date</th>
					<th>last connection date</th>
				</tr>
				<!-- 데이터 표시줄 : 데이터가 있는 만큼 반복 처리한다. -->
				<c:forEach items="${list }" var="dto">
					<tr class="dataRow">
						<td class="id">${dto.id }</td>
						<td>${dto.email }</td>
						<td>${dto.username }</td>
						<td>${dto.nickname }</td>
						<td>${dto.sns_type }</td>
						<td>${dto.sns_profile }</td>
						<td>



							<div class="row [B]rownav[/B]">
								<!-- dropdown보이게 -->
								<div class="twocol">
									<div class="dropdown">
										<input id="gradeBtn" type="button" value="${dto.gradeName }"
											name="gradeName" class="btn btn-primary dropdown-toggle"
											data-toggle="dropdown">
										<!-- <button id="gradeBtn" class="btn btn-primary dropdown-toggle" type="button"
											data-toggle="dropdown"><span
												class="caret"></span>
								</button> -->
										<ul class="dropdown-menu">
											<li class="dropdown-item">Nail Customer</li>
											<li class="dropdown-item">Self Nailer</li>
											<li class="dropdown-item">Nail Shop</li>
											<li class="dropdown-item">Admin</li>
										</ul>
									</div>
								</div>
							</div>


						</td>
						<td>${dto.stateName }</td>
						<td><fmt:formatDate value="${dto.create_date }"
								pattern="yyyy-MM-dd" /></td>
						<td><fmt:formatDate value="${dto.modify_date }"
								pattern="yyyy-MM-dd" /></td>
						<td><fmt:formatDate value="${dto.condate }"
								pattern="yyyy-MM-dd" /></td>
					</tr>
				</c:forEach>
			</table>

	<button>end managing
	</button>






		</form>
	</div>







</body>
</html>