<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>MinnieNail Admin Page</h1>
		<h4>MinnieNail Member List</h4><br/><br/>

		<table class="table">
			<!-- 테이블의 한줄 -->
			<!-- 항목의 제목 -->
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
					<td>${dto.gradeName }</td>
					<td>${dto.stateName }</td>
					<td><fmt:formatDate value="${dto.create_date }"
							pattern="yyyy-MM-dd" /></td>
					<td><fmt:formatDate value="${dto.modify_date }"
							pattern="yyyy-MM-dd" /></td>
					<td><fmt:formatDate value="${dto.condate }"
							pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
			<!-- 회원 관리하기 -->
			<tr>
				<td colspan="5">
				<a href="manage.do"><button>Member Management</button></a></td>
			</tr>

		</table>

	</div>
</body>
</html>