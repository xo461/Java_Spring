<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글보기</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- bootstrap lib는 default_decorator에 적용했으므로 생략 -->
<!-- bootstrap lib는 site-mesh 프로그램을 적용하지 않는 경우는 반드시 등록 -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
.modal-header, .modal-header h4, .close {
	background: black;
	color: white;
	font-size: 30px;
}
</style>

<script type="text/javascript">
	$(function() {
		// 버튼 이벤트 처리
		$("#deleteBtn").click(function() {
			if (!confirm("정말 삭제하시겠습니까?"))
				return false; // a tag의 href를 취소 시킨다. -> location.href를 변경하는 태그 a	
		});

		$("#writeBtn")
				.click(
						function() {
							// 모달창 제목 셋팅
							$(".modal-header > h4")
									.html(
											"<span class='glyphicon glyphicon-pencil'></span> 댓글 쓰기");

							// 값을 비운다.
							$("#modal_content").val("");
							$("#modal_writer").val("");

							//전송 버튼의 글자 셋팅
							$("#updateModal_updateBtn").text("등록");

							// 작성자 수정 가능르로 만든다.
							$("#modal_writer").attr("disabled", false);

							// 받는 url을 정한다.
							$("#modal_form").attr("action", "replyWrite.do")

							$("#updateModal").modal();
						});

		$(".updateBtns")
				.click(
						function() {
							// 데이터 수집
							var row = $(this).closest(".dataRow");
							var rno = row.data("rno");
							var writer = row.find(".writer").text();
							var content = row.find(".content").text();

							// 모달창 제목 셋팅
							$(".modal-header > h4")
									.html(
											"<span class='glyphicon glyphicon-pencil'></span> 댓글 수정");

							// 전송 버튼의 글자 셋팅
							$("#updateModal_updateBtn").text("수정");

							// 모달창에 셋팅
							$("#modal_rno").val(rno);
							$("#modal_content").val(content);
							$("#modal_writer").val(writer);

							// 작성자 수정 불가로 만든다.
							$("#modal_writer").attr("disabled", true);

							// 받는 url을 정한다.
							$("#modal_form").attr("action", "replyUpdate.do")

							$("#updateModal").modal();
						});

		$(".deleteBtns").click(function() {
			var row = $(this).closest(".dataRow");
			var rno = row.data("rno");
			var content = row.find(".content").text();
			$("#delete_modal_content").text(content);
			$("#delete_modal_rno").val(rno);
			$("#deleteModal").modal();
		});

	});
</script>

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
			<th>작성자</th>
			<td>${dto.writer }</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${dto.hit}</td>
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
				<h3 style="border-bottom: 1px solid #ccc">댓글
				<i class="fa fa-commenting-o" style="font-size:25px;color:red"></i>
				</h3>
				
	</table>
    </div>
</body>
</html>