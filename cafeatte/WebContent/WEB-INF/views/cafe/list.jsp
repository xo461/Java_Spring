<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tl" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카페어때</title>
<style type="text/css">
.dataRow:hover {
	background: #fff;
	color: orange;
	cursor: pointer;
}

ul {
	padding: 0px 0;
}

ul li {
	display: inline-block;
	margin: 2px 2px;
	font-size: 14px;
	letter-spacing: -.5px;
}

ul li.tag-item {
	padding: 4px 8px;
	list-style: none;
	background-color: #000;
	color: #fff;
}

ul li.searchTag-item {
	padding: 4px 8px;
	list-style: none;
	background-color: #000;
	color: #fff;
}

.tag-item:hover {
	background-color: orange;
	color: #fff;
}

.searchTag-item:hover {
	background-color: orange;
	color: #fff;
}
</style>
<script>
	$(document).ready(function() {
		$(function(){
			$(".searchTag-item").click(function(){
				var word = $(this).text();
				if(word === "전체"){
					word = "";
				}
				location="list.do?page=1"
					+ "&perPageNum=${pageObject.perPageNum}"
					+ "&word="+word;
			})
		});
		$(".pagination>li:not('.active')").click(
				function() {
					var page = $(this).data("page");
					location = "list.do?page=" + page
					+ "&perPageNum=${pageObject.perPageNum}"
					+ "&word=${pageObject.word}";
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
					+ "&perPageNum=" + perPageNum
					+ "&word=${pageObject.word}";
			}
		});
		
		$(".dataRow").click(function() {
			no = $(this).find(".no").val();
			location = "view.do?no=" + no
			+ "&cnt=1"
			+ "&page=${pageObject.page}"
			+ "&perPageNum=${pageObject.perPageNum}"
			//el 객체에서 empty -> null || ""체크 -> 데이터가 넘어오지 않았다.
			//el 객체에서 문자열 연결을 "+"로 사용 불가능 -> "+="으로 사용
		   ${(!empty pageObject.word)?
				   " + \"&word="
				   += pageObject.word +="\"":"" };
		});
		var tagValue = "";

		var str = "${searchTags}";
		if (str !== "") {
			tagValue = str.split(',');
			for (var i = 0; i < tagValue.length; i++) {
				$("#searchTag-list")
						.append(
								"<li class='searchTag-item'>"
										+ tagValue[i]
										+ "</li>");
			}
		}
	});
</script>
</head>
<body>
	<div>
		<h2>동네카페 리스트</h2>
		<c:if test="${login.grade == 9 }">
		<div style="float: right">
			<a href="writeForm.do"><button>카페 추가</button></a>
		</div>
		</c:if>
	</div>
	<br>
	<br>
	<form class="form-inline" action="list.do">
		<input name="page" value="${pageObject.page }" type="hidden" /> <input
			name="perPageNum" value="${pageObject.perPageNum }" type="hidden" />
		<div class="input-group" style="float: right">
			<span class="input-group-addon">Rows/Page</span> <select
				class="form-control" id="perPageRow">
				<option ${(pageObject.perPageNum == 10)?"selected='selected'":"" }>10</option>
				<option ${(pageObject.perPageNum == 15)?"selected='selected'":"" }>15</option>
				<option ${(pageObject.perPageNum == 20)?"selected='selected'":"" }>20</option>
				<option ${(pageObject.perPageNum == 25)?"selected='selected'":"" }>25</option>
			</select>
		</div>
	</form>
	<div id="hTagDiv">
		<h3>
			<ul id="searchTag-list"></ul>
		</h3>
	</div>
	
	<div class="row">
		<c:forEach var="dto" items="${list}">
			<div class="col-md-2 imgsDiv"
				style="padding-right: 0px; padding-left: 0px; max-width: 210px">
				<div class="img-thumbnail">
					<div class="dataRow">
						<img src="${dto.fileName1 }" alt="${dto.fileName1 }"
							id="ListImage" class="img-responsive"> <input type="hidden"
							class="no" value="${dto.no }">
						<div class="title">
							<font size="+2"><b>${dto.title }</b></font>
						</div>
					</div>
					<div class="caption">
						<div id="hTags" style="hteight: 20%">
							<ul id="tag-list">
								<c:forEach var="hTags" items="${hTags }">
									<c:if test="${hTags.no == dto.no }">
										<li class='tag-item searchTag-item'>${hTags.hTag }</li>
									</c:if>
								</c:forEach>
							</ul>
						</div>
						<div class="writeDate" align="right" style="color: #bbb">
							${dto.writeDate }</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<div><tl:pageNav  page="${pageObject.page }"
			 startPage="${pageObject.startPage }" endPage="${pageObject.endPage }" 
			 totalPage="${pageObject.totalPage }" /></div>

</body>
</html>