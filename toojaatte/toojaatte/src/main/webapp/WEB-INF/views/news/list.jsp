<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$(".news").click(function() {
			var no = $(this).find(".no").text();
			location = "view.do?no=" + no
			+ "&cnt=1"
			+ "&page=${pageObject.page }"
			+ "&perPageNum=${pageObject.perPageNum}";
		});
</script>
</head>
<body>
<c:forEach items="${dto }" var="dto">
<div class=news>
<div hidden="${dto.no }" class="no"></div>
<div>${dto.press }</div>
<div>${dto.title }</div>
<div>${dto.write_date }</div>
</div>
<br/>

</c:forEach>
</body>
</html>