<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>CSS Template</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<style>
* {
	box-sizing: border-box;
}

body {
	font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
	padding: 30px;
	text-align: center;
	font-size: 35px;
}

/* Container for flexboxes */
section {
	display: -webkit-flex;
	display: flex;
}

/* Style the navigation menu */
nav {
	-webkit-flex: 1;
	-ms-flex: 1;
	flex: 1;
	padding: 20px;
}

/* Style the content */
article {
	-webkit-flex: 3;
	-ms-flex: 3;
	flex: 3;
	padding: 10px;
}

.news:hover {
	background-color: #eee;
	cursor: pointer;
}

/*말줄임표 생략되게 수정해야함------------------------*/
.hitNews_contents{
overflow:hidden; 
text-overflow:ellipsis;
}


/* Responsive layout - makes the menu and the content (inside the section) sit on top of each other instead of next to each other */
@media ( max-width : 600px) {
	section {
		-webkit-flex-direction: column;
		flex-direction: column;
	}
}
</style>
<script type="text/javascript">
	$(function(){
		$(".news").click(
				function() {
					var nno = $(this).find("#nno").val();
					alert(nno);
					location = "view.do?nno=" + nno + "&cnt=1"
							+ "&page=${pageObject.page }"
							+ "&perPageNum=${pageObject.perPageNum}";
				});

		// 페이지 네이션의 클릭 이벤트 처리
		// /WEB-INF/tags에 있는 pagination클래스에있는 active클래스(현재페이지) 제외하고 - 클릭했을때
		$(".pagination > li:not('.active')").click(
				function() {
					// 		alert("페이지 이동 클릭");
					// .data("page") ==> 속성 중에서 data-page 라는 속성의 값을 가져온다.-->page..현재몇패이지인지 정보 들어있음.
					var page = $(this).data("page");
					//alert(page + "-" + typeof page);

					location = "list.do?page=" + page
							+ "&perPageNum=${pageObject.perPageNum}"
							+ "&key=${pageObject.key}"
							+ "&word=${pageObject.word}";
					// a tag의 페이지 이동을 취소 시킨다.???????????
					return false;
				});
		$("li.active").click(function() {
			return false; //현재페이지는 클릭이 안되게 한다.
		});
	});
</script>
</head>
<body>
	<div class="contaner">

		<h2>뉴스</h2>
		<header>
			<h2>Header</h2>
		</header>

		<section>
			<article>
				<div class="main" id="main">
					<c:forEach items="${dto }" var="dto">
						<div class=news style="padding: 5px" onclick="location.href='view.do';">
							<input id="nno" name="nno" value="${dto.nno }" type="hidden"/>
							<div>${dto.press }</div>
							<div>${dto.title }</div>
							<div>${dto.write_date }</div>
						</div>
						<br />
					</c:forEach>
					<!-- 페이지네비-------------------------- -->
					<div id="pageNav">
						<p:pageNav
						startPage="${pageObject.startPage }" 
						endPage="${pageObject.endPage }"
						totalPage="${pageObject.totalPage }"
						page="${pageObject.page }"></p:pageNav>
					</div>
				</div>
			</article>

			<!--사이드바 -------------------------------->
			<nav>
				<!--뉴스검색, 검색많은키워드 -------------------------------->
				<div class="newsB">
					<h4>뉴스 검색</h4>
					<div class="searchB">
						<form action="list.do" class="form-inline">
							<input name="page" value="1" type="hidden"/>
							<input type="text" name="word" class="form-control"
								style="color: #aaaaaa;" placeholder="검색어를 입력하세요." value="${param.word }"tabindex="0">
							<button>검색</button>
						</form>
					</div>

					<div class="hashtag">
						<h5>인기키워드</h5>
						<ul>
							<!--최다검색어 넣을 곳  -->
							<li class="ty01"><a
								href="/news?keyword=%EC%A7%84%EB%8B%A8%ED%82%A4%ED%8A%B8">#진단키트</a></li>
						</ul>
					</div>
				</div>

				<!-- 조회수높은뉴스 -->
				<div class="hitNews">
					<h4>많이본 뉴스</h4>
					<div class="hitNews_contents">
						<ul class="list">
							<c:forEach items="${mostViewed }" var="mostViewed">
							<!-- /*말줄임표 생략되게 수정해야함------------------------*/
							 -->
							<li style="list-style:none;"><a href="view.do?nno="+${mostViewed.nno}+"&cnt=1&page=&perPageNum=">
							${mostViewed.title }</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>

			</nav>
			<!-- ----------------------------------->
		</section>


	</div>
</body>
</html>