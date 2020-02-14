<%@page import="com.webjjang.main.Execute"%>
<%@page import="com.webjjang.bean.Beans"%>
<%@page import="com.webjjang.main.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 라이브러리 불러와야 데이터 불러올 수 있음... -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<!-- <script lang="javascript"> -->
<script type="text/javascript">
	$(function() {
		
		//1. datarow 클릭이벤트 (게시판 글 한줄)
		// 하나의 글을 선택(tr tag를 클릭)하면 글번호를 받아내서 글보기로 보낸다.
		$(".dataRow").click(function() {
// 		this는 이벤트가 일어난 곳을 가리킴. .뒤에 클래스. no클래스(밑에선언되어있음)를 찾아서 그 텍스트 .text를 var no에 넣어라
			var no = $(this).find(".no").text();
			//cnt는 조회수를 증가할지 말지 판단하는 변수.
			//주소창에 key=value&key=value...나오는것...
			location = "view.do?no=" + no
				+ "&cnt=1"
				+ "&page=${pageObject.page}" //현재 페이지
				+ "&perPageNum=${pageObject.perPageNum}" //한페이지에 표시할 데이터 개수
				// el 객체${}에서 empty -> null || "" 체크 -> 데이터가 넘어오지 않았다.
				// el 객체에서 문자열 연결을 "+" 로 사용 불가능 => "+=" 로 사용한다.
				// (조건?참일때할것:거짓일때할것)
				// pageObject에 word가 비어있지 않으면 
				   ${(!empty pageObject.word)? 
						   " + \"&key=" += pageObject.key += "&word="
						   += pageObject.word += "\"":""};
		});


		// 2. 페이지 네이션의 클릭 이벤트 처리
		//.pagination클래스 아래에 있는 li tag(아무것도 안붙어있으면 태그)에서 .active클래스를 제외한(not) li tag를 클릭할때 
		$(".pagination > li:not('.active')").click(
				function() {
// 							alert("페이지 이동 클릭");
					// .data("page") ==> 속성 중에서 data-page 라는 속성의 값을 가져온다.
					var page = $(this).data("page");
					//alert(page + "-" + typeof page);

					location = "list.do?page=" + page
							+ "&perPageNum=${pageObject.perPageNum}"
							+ "&key=${pageObject.key}"
							+ "&word=${pageObject.word}";
							// a tag의 페이지 이동을 취소 시킨다.
					return false;
				});
		//이미 그 페이지가 클릭된상태이면 다시클릭해도 실행안되게 해라.
		$("li.active").click(function() {
			return false;
		})
	});
</script>



</head>
<body>
	<div class="container">
		<h1>게시판 리스트</h1><br>

		<div id="searchDiv">
			<form action="list.do" class="form-inline">
			<input name="page" value="1" type="hidden"/>
				<div class="form-group">
					<select class="form-control" id="key" name="key">
						<option value="t" ${(param.key == "t")?"selected='selected'":"" }>제목</option>
						<option value="c" ${(param.key == "c")?"selected='selected'":"" }>내용</option>
						<option value="w" ${(param.key == "w")?"selected='selected'":"" }>작성자</option>
						<option value="tc" ${(param.key == "tc")?"selected='selected'":"" }>제목/내용</option>
						<option value="tw" ${(param.key == "tw")?"selected='selected'":"" }>제목/작성자</option>
						<option value="cw" ${(param.key == "cw")?"selected='selected'":"" }>내용/작성자</option>
						<option value="tcw" ${(param.key == "tcw")?"selected='selected'":"" }>전체</option>
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
			</form>
		</div>
		<table class="table">
			<!-- 테이블의 한줄 -->
			<!-- 항목의 제목 -->
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>

			<!-- 데이터표시줄: 데이터가 있는 만큼 반복처리한다.에서 꺼내쓴다... -->
			<!-- list에서 글보기로 가니까 cnt는 1로 셋팅. 새로고침할때마다 올라간다. -->
			<c:forEach items="${list }" var="dto">
				<tr class="dataRow">
					<td class="no">${dto.no }</td>
					<td>${dto.title }</td>
					<td>${dto.writer }</td>
					<td>${dto.writeDate }</td>
					<td>${dto.hit }</td>
				</tr>

			</c:forEach>

			<!-- 페이지를 이동시키는 페이지네이션 -->
			<tr>
				<td colspan="5">
					<ul class="pagination">
						<li data-page=1><a href="#">&lt;&lt;</a></li>
						<c:if test="${pageObject.startPage > 1 }">
							<li data-page=${pageObject.startPage -1 }><a href="#">&lt;</a>
							</li>
						</c:if>
						<c:forEach begin="${pageObject.startPage }"
							end="${pageObject.endPage }" var="cnt">
							<li ${(pageObject.page == cnt)?"class=\"active\"":"" }
								data-page=${cnt }><a href="#">${cnt}</a></li>
						</c:forEach>
						<c:if test="${pageObject.endPage < pageObject.totalPage }">
							<li data-page=${pageObject.endPage + 1 }><a href="#">&gt;</a>
							</li>
						</c:if>
						<li data-page=${pageObject.totalPage }><a href="#">&gt;&gt;</a>
						</li>
					</ul>
				</td>
			</tr>

			<!-- 글쓰기 버튼 -->
			<tr>
				<td colspan="5"><a href="/board/writeForm.do"><button>글쓰기</button></a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
