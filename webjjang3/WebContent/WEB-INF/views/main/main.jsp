<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main page</title>
<script type="text/javascript">
	
	$(function() {
		// 하나의 글을 선택(tr tag를 클릭)하면 글번호를 받아내서 글보기로 보낸다.
		$(".dataRow").click(function() {
			var uri = "";
			var no = $(this).find(".no").text();
			if (no ==""){
				no = $(this).data("no");
			}
			alert(no);
			if($(this).hasClass("image"))
				uri = "/image/view.do";
			else if($(this).hasClass("notice"))
				uri = "/notice/view.do";
			location = uri+"?no=" + no+"&page=1&perPageNum=10";
			
			//  /?/ ?에따라 이미지로 갈수도 잇고 노티스로 갈수도 있다.
		});
	});

	
</script>
</head>

<body>
	<h2>Main Page</h2>
	<!-- 공지사항 글 7개를 나타내는 부분 -->
	<div>
		<div class="panel panel-default">
			<div class="panel-heading">Notice List</div>
			<div class="panel-body">Panel Content</div>
			<div class="container">
				<h1>공지사항 리스트</h1>
				<table class="table">
					<!-- 테이블의 한줄 -->
					<!-- 항목의 제목 -->
					<tr>
						<th>제목</th>
						<th>시작일</th>
						<th>종료일</th>
					</tr>

					<!-- 데이터표시줄: 데이터가 있는 만큼 반복처리한다.에서 꺼내쓴다... -->
					<c:forEach items="${noticeList }" var="dto">
						<tr class="dataRow notice" data-no="${dto.no }" >
							<td>${dto.title }</td>
							<td>${dto.startDate }</td>
							<td>${dto.endDate }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<!-- 이미지 8개를 나타내는 부분 -->
	<div>
		<div class="panel panel-default">
			<div class="panel-heading">Image Gallery</div>
			<div class="panel-body">Panel Content</div>
		<!-- 이미지 겔러리 리스트 작성 -->
		<div class="row">
		 <!-- 데이터가 있는 만큼 반복문처리 시작. -->
		 <c:forEach items="${imageList }" var="dto">
			<!-- col 시작 : no, title, id, writeDate, fileName -->
		    <div class="col-md-3 dataRow image">
		      <div class="thumbnail">
		          <img src="${dto.fileName }" alt="${dto.fileName }" style="width:100%">
		          <div class="caption">
		            <p><span class="no">${dto.no }</span>. ${dto.title }</p>
		            <p>${dto.id } (${dto.writeDate })
		            </p>
		          </div>
		      </div>
		    </div>
		    <!-- col의 끝 -->
		   </c:forEach>
		 <!-- 데이터가 있는 만큼 반복문처리 끝. -->
		   
		</div>
		<!-- row의 끝 -->
		
		</div>
	</div>
</body>
</html>



