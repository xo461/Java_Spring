<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><!-- fmt태그: 숫자, 날짜, 시간을 formatting하는 기능과 국제화, 다국어 지원 기능을 제공. prefix는 밑에서 쓸때 fmt이름으로 쓰겠다는 뜻 -->
<!-- paging 처리를 위한 taglib. tagdir는 tag가 위치한 곳 -->
<%@ taglib prefix="p" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<!-- bootstrap lib는 default_decorator에 적용했으므로 생략 -->
<!-- bootstrap lib는 site-mesh 프로그램을 적용하지 않는 경우는 아래와같이 반드시 등록 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<style type="text/css">
.dataRow:hover {
	background: #eee;
	cursor: pointer;
}
</style>

<!-- <script lang="javascript"> -->
<!-- <script> -->
<script type="text/javascript">
	$(function() {
		// 하나의 글을 선택(tr tag를 클릭)하면 글번호를 받아내서 글보기로 보낸다.
		$(".dataRow").click(function() {
			var no = $(this).find(".no").text();
			location = "view.do?no=" + no
					+ "&cnt=1"
					+ "&page=${pageObject.page}"
					+ "&perPageNum=${pageObject.perPageNum}"
					// el 객체에서 empty -> null || "" 체크 -> 데이터가 넘어오지 않았다.
					// el 객체에서 문자열 연결을 "+" 로 사용 불가능 => "+=" 로 사용한다.
				   ${(!empty pageObject.word)?				
						   " + \"&key=" += pageObject.key += "&word="
						   += pageObject.word += "\"":""}
				    ;
		});

		// 페이지 네이션의 클릭 이벤트 처리
		$(".pagination > li:not('.active')").click(
				function() {
					// 		alert("페이지 이동 클릭");
					// .data("page") ==> 속성 중에서 data-page 라는 속성의 값을 가져온다.
					var page = $(this).data("page");
// 					alert(page + "-" + typeof page);

					location = "list.do?page=" + page
							+ "&perPageNum=${pageObject.perPageNum}"
							+ "&key=${pageObject.key}"
							+ "&word=${pageObject.word}";
					// a tag의 페이지 이동을 취소 시킨다.
					return false;
				});
		$("li.active").click(function() {
			return false;
		});
		
		
		// 한페이지에 나타날 글의 갯수 변경 이벤트 처리
		$("#perPageRow").on({
			"change":function(){
				perPageNum = $("#perPageRow").val();
				location="list.do?page=1"
					+"&perPageNum=" + perPageNum
					+"&key=${pageObject.key}"
					+"&word=${pageObject.word}";
			}
		});
	});	
	
</script>

</head>

<body>
	<div class="container">
		<h1>All about your nailart...</h1>
		<h4>Share your ideas, designs, techniques and etc about nailart!</h4>
		<div class="row">
			<div id="searchDiv">
				<form action="list.do" class="form-inline">
					<input name="page" value="1" type="hidden" /> <input
						name="perPageNum" value="${pageObject.perPageNum }" type="hidden" />
					<div class="form-group">
						<select class="form-control" id="key" name="key">
							<option value="t" ${(param.key == "t")?"selected='selected'":"" }>제목</option>
							<option value="c" ${(param.key == "c")?"selected='selected'":"" }>내용</option>
							<option value="w" ${(param.key == "w")?"selected='selected'":"" }>작성자</option>
							<option value="tc" ${(param.key=="tc")?"selected='selected'":"" }>제목/내용</option>
							<option value="tw"
								${(param.key == "tw")?"selected='selected'":""}>제목/작성자</option>
							<option value="cw"
								${(param.key == "cw")?"selected='selected'":""}>내용/작성자</option>
							<option value="tcw"
								${(param.key == "tcw")?"selected='selected'":""}>전체</option>
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
					<div class="input-group right">
						<span class="input-group-addon">Rows/page</span> <select
							class="form-control" id="perPageRow">
							<!-- 					selected되면 selected된걸 표시해라 -->
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
		<table class="table">
			<!-- 테이블의 한줄 -->
			<!-- 항목의 제목 -->
			<tr>
				<th>No</th>
				<th>Title</th>
				<th>Writer</th>
				<th>Write date</th>
				<th>Hit</th>
			</tr>
			<!-- 데이터 표시줄 : 데이터가 있는 만큼 반복 처리한다. -->
			<c:forEach items="${list }" var="dto">
				<tr class="dataRow">
					<td class="no">${dto.no }</td>
					<td>${dto.title }</td>
					<td>${dto.writer }</td>
					<td><fmt:formatDate value="${dto.writeDate }"
							pattern="yyyy-MM-dd" /></td>
					<td>${dto.hit }</td>
				</tr>
			</c:forEach>

			<!-- 페이지를 이동시키는 페이지네이션 -->
			<!-- pageNav.tag에서 taglibrary 만들어놔서 바로 쓸수있다. -->
			<tr>
				<td colspan="5" align="center">
				<p:pageNav
						page="${pageObject.page }" startPage="${pageObject.startPage }"
						endPage="${pageObject.endPage }"
						totalPage="${pageObject.totalPage }">
					</p:pageNav></td>
			</tr>
			<!-- 글쓰기 버튼 -->
			<tr>
				<td colspan="5"><a
					href="write.do?perPageNum=${pageObject.perPageNum }"><button>Wirte</button></a>
					<a href="list.do?page=1&perPageNum=${pageObject.perPageNum }"><button>전체목록</button></a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>