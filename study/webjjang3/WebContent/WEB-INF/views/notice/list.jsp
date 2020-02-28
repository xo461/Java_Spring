<%@page import="com.webjjang.main.Execute"%>
<%@page import="com.webjjang.bean.Beans"%>
<%@page import="com.webjjang.main.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 라이브러리 불러와야 데이터 불러올 수 있음... -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tl" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
<!-- bootstrap lib는 default_decorator에 적용했으므로 생략 -->

<style type="text/css">
.dataRow:hover {
	background: #eee;
	cursor: pointer;
}
</style>

<script type="text/javascript">
$(function(){
	// 하나의 글을 선택(tr tag를 클릭)하면 글번호를 받아내서 글보기로 보낸다.
	$(".dataRow").click(function(){
		var no = $(this).find(".no").text(); 
		location = "view.do?no=" + no;
	});
	
	// 페이지 네이션의 클릭 이벤트 처리
	$(".pagination > li:not('.active')").click(function(){
// 		alert("페이지 이동 클릭");
		// .data("page") ==> 속성 중에서 data-page 라는 속성의 값을 가져온다.
		var page = $(this).data("page");
// 		alert(page + "-" + typeof page);

		location = "list.do?page=" + page + "&perPageNum=${pageObject.perPageNum}"
		// a tag의 페이지 이동을 취소 시킨다.
		return false;
	});
	$("li.active").click(function(){
		return false;
	})
});
</script>

</head>
<body>

	<div class="container">
		<h1>공지사항 리스트</h1>
		<table class="table">
			<!-- 테이블의 한줄 -->
			<!-- 항목의 제목 -->
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>공지시작일</th>
				<th>공지종료일</th>
				<th>최종수정일</th>
			</tr>

			<!-- 데이터표시줄: 데이터가 있는 만큼 반복처리한다.에서 꺼내쓴다... -->
			<c:forEach items="${list }" var="dto">
				<tr class="dataRow">
					<td class="no">${dto.no }</td>
					<td>${dto.title }</td>
					<td>${dto.writeDate }</td>
					<td>${dto.startDate }</td>
					<td>${dto.endDate }</td>
					<td>${dto.updateDate }</td>
				</tr>
			</c:forEach>

	<!-- 페이지를 이동시키는 페이지네이션 -->
	<tr>
		<td colspan="5">
			<ul class="pagination">
			  	<li data-page=1>
			  		<a href="#">&lt;&lt;</a>
			  	</li>
				<c:if test="${pageObject.startPage > 1 }">
				  	<li data-page=${pageObject.startPage -1 }>
				  		<a href="#">&lt;</a>
				  	</li>
			  	</c:if>
				<c:forEach begin="${pageObject.startPage }" end="${pageObject.endPage }" var="cnt">
			  	<li ${(pageObject.page == cnt)?"class=\"active\"":"" } 
			  	 data-page=${cnt }>
			  		<a href="#">${cnt}</a>
			  	</li>
				</c:forEach>
				<c:if test="${pageObject.endPage < pageObject.totalPage }">
				  	<li data-page=${pageObject.endPage + 1 }>
				  		<a href="#">&gt;</a>
				  	</li>
			  	</c:if>
			  	<li data-page=${pageObject.totalPage }>
			  		<a href="#">&gt;&gt;</a>
			  	</li>
			</ul> 
		</td>
	</tr>
	
	<!-- pageNav.tag에서 taglibrary 만들어놔서 바로 쓸수있다. -->
	<tr>
		<td>
			<tl:pageNav  
			page="${pageObject.page }" 
			startPage="${pageObject.startPage }" 
			endPage="${pageObject.endPage }" 
			totalPage="${pageObject.totalPage }" >
			</tl:pageNav>
		</td>
	</tr>
			<!-- 글쓰기 버튼 -->
			<tr>
				<td colspan="6"><a href="writeForm.do"><button>공지 등록</button></a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
