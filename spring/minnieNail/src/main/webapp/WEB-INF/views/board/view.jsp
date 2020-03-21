
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글보기</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- bootstrap lib는 default_decorator에 적용했으므로 생략 -->
<!-- bootstrap lib는 site-mesh 프로그램을 적용하지 않는 경우는 반드시 등록 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
.modal-header, .modal-header h4, .close {
	background: black;
	color: white;
	font-size: 30px;
}

body {
	margin-top: 20px;
}

.comment-wrapper .panel-body {
	max-height: 650px;
	overflow: auto;
}

.comment-wrapper .commentList .media img {
	width: 64px;
	height: 64px;
	border: 2px solid #e5e7e8;
}

.comment-wrapper .commentList .media {
	border-bottom: 1px dashed #efefef;
	margin-bottom: 25px;
}
</style>
</head>
<body>
	<div class="container">
		<h1>게시판 글보기</h1>
		<table class="table">
			<tr>
				<th>글번호</th>
				<td>${dto.no}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${dto.title}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><pre>${dto.content}</pre></td>
			</tr>
			<tr>
				<th>nickName</th>
				<td>${dto.nickName }</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${dto.hit}</td>
			</tr>
			<tr>
				<th>좋아요수</th>
				<td><button id="likeBtn">like me</button></td>
			</tr>

			<!-- 여러개 파일 반복문으로 가져온다. -->
			<tr>
				<th>attached file</th>
				<td>
					<!-- c:foreach var명으로  el객체를 가져다 쓴다. --> <c:forEach var="fList"
						items="${fList}">
						<!-- 첨부파일 다운로드하기 : 콘트롤러로 글번호와 파일번호를 넘긴다.-->
						<form action="/board/downloadFile.do" id="download">
							<input type="hidden" name="No" value="${dto.no }"> <input
								type="hidden" name="file_no" value="${fList.FILE_NO }">
							<button>${fList.ORG_FILE_NAME}(${fList.FILE_SIZE}kb)</button>
							<br />
						</form>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="2"><a
					href="update.do?no=${dto.no }&page=${param.page }&perPageNum=${param.perPageNum}&key=${param.key}&word=${param.word}"><button>수정</button></a>
					<a href="delete.do?no=${dto.no }&perPageNum=${param.perPageNum }"
					id="deleteBtn"><button>삭제</button></a> <a
					href="list.do?page=${param.page }&perPageNum=${param.perPageNum }&key=${param.key }&word=${param.word}"><button>목록</button></a>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<h3 style="border-bottom: 1px solid #ccc">
						댓글 <i class="fa fa-commenting-o"
							style="font-size: 25px; color: red"></i>
					</h3>
		</table>

		<!--댓글 ---------------------------------------------------- -->
		<div class="row bootstrap snippets">
			<div class="col-md-6 col-md-offset-2 col-sm-12">
				<div class="comment-wrapper">
					<div class="panel panel-info">
						<div class="panel-heading">Comments..</div>
						<div class="panel-body">
							<!-- 댓글달기 ------------------------------>
							<form name="commentInsertForm">
								<input type="hidden" name="id" value="${login.id}" /> 
								<input
									type="hidden" name="no" value="${dto.no}" />
								<textarea class="form-control" id="content" name="content"
									placeholder="write a comment..." rows="3"></textarea>
								<br>
								<button type="button" id="commentBtn"
									class="btn btn-info pull-right" name="commentInsertBtn">Post</button>
								<button type="button" id="signinBtn"
									class="btn btn-info pull-right" name="signinBtn" style="display: none;">Sign-in</button>
								<div class="clearfix"></div>
							</form>
								<script>
								var id = null;
								id = "${login.id}";
								if (!id){
									  document.getElementById("commentBtn").style.display = "none";
									  document.getElementById("content").placeholder = "Sign-in to write a comment...";
									  //document.getElementById("content").readOnly = true;
									  document.getElementById("signinBtn").style.display = "block";
									  document.getElementById("signinBtn").onclick = function(){
										  //다른컨트롤러로 보내고싶으면 앞에 슬래쉬/붙여야 한다. /가 루트를 의미.
										  //붙이지 않으면 /board/login/login.do 이주소를 찾아서 에러난다. 
									location.replace("/login/login.do");
									  }
									  document.getElementById("content").onclick = function(){
										  //다른컨트롤러로 보내고싶으면 앞에 슬래쉬/붙여야 한다. /가 루트를 의미.
										  //붙이지 않으면 /board/login/login.do 이주소를 찾아서 에러난다. 
									location.replace("/login/login.do");
										   }
									}
								</script>
							<hr>
							<!-- 댓글리스트 ----------------------------->
							<div class="container">
								<div class="commentList"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 댓글 아작스처리 파일 include : script이기떄문에 head나 body 안에 include해야됨 -->
	<%@ include file="comments.jsp"%>
</body>
</html>
