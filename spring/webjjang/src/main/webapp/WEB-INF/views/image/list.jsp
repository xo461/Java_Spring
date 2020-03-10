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
		$(".dataRow").click(function() {
			//클릭한 것 안에 글번호 찾기
			//클릭한게 this 그안에 찾아라. no 클래스를. 그안에 text가 글번호 -> 변수저장
			var no = $(this).find(".no").text();
			//글번호를 붙여서 글보기로 이동시킨다.
			//???????????????????cnt는뭐지?????????///
			location = "view.do?no=" + no
			+ "&cnt=1"
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
					<input name="page" value="1" type="hidden" /> 
					<input name="perPageNum" value="${pageObject.perPageNum }" type="hidden" />
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
						<span class="input-group-addon">Rows/Page</span> 
						<select class="form-control" id="perPageRow">
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


		<!-- table에 부트스트랩적용: clss명 table로 지정하면 된다. -->
		<!-- 1.위에 w3schools라이브러리등록 2.body밑에 container담기 3.그외필요객체: class명으로 적용. bootstrap에 있는 클래스로.-->
		<table class="table">
			<tr>
				<th>No</th>
				<th>Image</th>
				<th>Title</th>
				<th>Name(Id)</th>
				<th>Write date</th>
			</tr>
			<!-- 데이터갯수만큼 반복문: taglib의 core jstl사용 'c'라는 이름으로 foreach기능. -->
			<!-- imagecontroller에서 key값으로 준 이름'list'를 사용해야 데이터를 받을 수 있다. -->
			<!-- jsp에서 저장할수있는 기본객체 4가지 pagecontext(jsp페이지에서만), request(화면에나타날때까지만), session(사용자가 서버에있을동안만), application(서버시작후서버종료될때까지) -->
			<!-- list가 어디에 있는지 위에 4개중하나에서 찾는다.(request에 잇음)  -->
			<!-- 반복문돌따마다 list가져오면 데이터가 너무 많아지므로 var에 dto로 넣어서 pageContext에서만 사용하도록 한다. -->
			<!-- dto.no라고 함은 ImageDTO에 있는 변수인데 원래는 private변수라 다른데서 못가져오는데 jsp에서 java로 컴파일할떄 자동으로 getNo()로 바꿔줘서 가능하다(getter호출). -->
			<!-- 이 no는 변수(내맘대로 값넣으루있는것)가아니고 property다(getter로 가져오는것. private이므로내맘대로 변경 불가). jsp에서 property를 쓰도록 강제한다. -->
			<c:forEach items="${list }" var="dto">
				<!-- 한줄전체에서 아무데나 눌르면 글보기로 가게하기: 1개면 id, 여러개는 class. -->
				<!-- 여기선 반복문으로 여러개의글이 나오므로 class로 붙여야함. -->
				<tr class="dataRow">
					<!-- 클릭했을때 글번호를 가져가서 보여줘야하니 class속성 적용 -> javascript에서 가져다가 보낸다. -->
					<td class="no">${dto.no}</td>
					<td>${dto.title}</td>
					<td><img src="${dto.fileName}" style="width:50px; height: 80px"/></td>
					<td>${dto.name}(${dto.id })</td>
					<td><fmt:formatDate value="${dto.writeDate}" pattern="yyyy.MM.dd" /></td>
				</tr>
			</c:forEach>

			<tr>
				<td colspan="5" align="center">
					<!-- ??????????????/ -->
					<!-- p누르고 ctrl spacebar누르면 다 나온다. --> 
					<p:pageNav
						endPage="${pageObject.endPage }"
						totalPage="${pageObject.totalPage }"
						startPage="${pageObject.startPage }" 
						page="${pageObject.page }"></p:pageNav>
				</td>
			</tr>

			<tr>
				<td colspan="5">
					<!-- 합치기 --> <!-- 주소로 입력하므로 get방식에 적용되어 write.do로 이동, write.jsp로 간다. -->
					<a href="write.do"><button>Write</button></a>
				</td>
		</table>
	</div>
</body>
</html>