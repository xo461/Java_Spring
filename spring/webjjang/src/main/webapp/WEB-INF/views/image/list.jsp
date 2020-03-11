<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- paging 처리를 위한 taglib. tagdir는 tag가 위치한 곳 -->
<%@ taglib prefix="p" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Webjjang:: Image List</title>

<style type="text/css">
.dataRow:hover {
	background-color: #eee;
	cursor: pointer;
}
</style>

<script type="text/javascript">
	$(function() {
		//dataRow클래스를 클릭하면 {}안에 함수 실행한다.
		$(".dataRow").click(
				function() {
					//클릭한 것 안에 글번호 찾기
					//클릭한게 this 그안에 찾아라. no 클래스를. 그안에 text가 글번호 -> 변수저장
					var no = $(this).find(".no").text();
					//글번호를 붙여서 글보기로 이동시킨다.
					//???????????????????cnt는뭐지?????????///
					location = "view.do?no=" + no + "&cnt=1"
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
					// 					alert(page + "-" + typeof page);

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
	})
</script>
</head>
<body>
	<div class="container">
		<h3>Image List</h3>

		<!-- 검색 -->
		<div class="row">
			<div id="searchDiv">
				<form action="list.do" class="form-inline">
					<input name="page" value="1" type="hidden" /> <input
						name="perPageNum" value="${pageObject.perPageNum }" type="hidden" />
					<div class="form-group">
						<select class="form-control" id="key" name="key">
							<option value="t" ${(param.key == "t")?"selected='selected'":"" }>Title</option>
							<option value="c" ${(param.key == "c")?"selected='selected'":"" }>Content</option>
							<option value="i" ${(param.key == "i")?"selected='selected'":"" }>Id</option>
							<option value="tc" ${(param.key=="tc")?"selected='selected'":"" }>Title/Content</option>
							<option value="ti"
								${(param.key == "ti")?"selected='selected'":""}>Title/Id</option>
							<option value="ci"
								${(param.key == "ci")?"selected='selected'":""}>Content/Id</option>
							<option value="tci"
								${(param.key == "tci")?"selected='selected'":""}>All</option>
						</select>
					</div>
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search"
							name="word" value="${param.word }">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
					<div class="input-group">
						<span class="input-group-addon">Rows/Page</span> <select
							class="form-control" id="perPageRow">
							<!-- 3항연산자 ??????????????????-->
							<option
								${(pageObject.perPageNum == 10)?"selected='selected'":"" }>10</option>
							<option
								${(pageObject.perPageNum == 15)?"selected='selected'":"" }>15</option>
							<option
								${(pageObject.perPageNum == 20)?"selected='selected'":"" }>20</option>
							<option
								${(pageObject.perPageNum == 25)?"selected='selected'":"" }>25</option>
						</select>
					</div>
				</form>
			</div>
		</div>



		<!-- 이미지 겔러리 리스트-->
		<div class="row">
			<!-- 데이터가 있는 만큼 반복 -->
			<c:forEach items="${list }" var="dto" varStatus="vs">
				<!-- col 시작 : no, title, id, writeDate, fileName -->
				<div class="col-md-3 dataRow">
					<div class="thumbnail">
						<img src="${dto.fileName }" alt="${dto.fileName }"
							style="width: 100%">
						<div class="caption">
							<p>
								<span class="no">${dto.no }</span>. ${dto.title }
							</p>
							<p>${dto.id }(${dto.name })-
								<fmt:formatDate value="${dto.writeDate}" pattern="yy.MM.dd" />
							</p>
						</div>
					</div>
				</div>
				<!-- 이미지를 4개 출력하면 줄을 바꾸는 처리 -->
				<c:if test="${vs.count % 4 == 0 }">
					<%="</div><div class='row'>"%>
				</c:if>
				<!-- col의 끝 -->
			</c:forEach>
		</div>

		<div>
			<p:pageNav endPage="${pageObject.endPage }"
				totalPage="${pageObject.totalPage }"
				startPage="${pageObject.startPage }" page="${pageObject.page }"></p:pageNav>
		</div>

		<div>
			<a href="write.do"><button>Upload Image</button></a>
		</div>
	</div>
</body>
</html>