<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글보기</title>
<style type="text/css">
#pwDiv {
	display: none;
} /* 안보이게 처리 */
.chat {
	list-style: none;
}
</style>
<script type="text/javascript">
	//댓글 객체 - 속성, 함수
	var replyService = (function() {
		//getList를 저장하는 프로그램 작성->필요한 데이터 param(no, page), callback-처리되는 함수, error-오류가 났을 때 객체
		function getList(param, callback, error) {
			var no = param.no;
			var page = param.page;

			//$.getJSON (여기서의 $는 jquery)
			$.getJSON(
			//데이터 요청 uri
			"/reply/pages/" + no + "/" + page + ".json",
			//데이터 가져오기를 성공하면 처리되는 함수.) data : 서버에서 넘어오는 데이터
			function(data) {
				//데이터 가져오기를 성공하면 실행되는 함수를 밖에 선언해서 넣어주는 경우 처리
				if (callback) { //사용하는 태그들이 다르기 때문에 콜백함수를 선언하는 것이 해당 코드를 다른 소스에서도 사용할 수 있다
					callback(data);
				}
			}
			//데이터 가져오는 것을 실패했을 때의 처리
			).fail(function(xhr, status, err) {
				if (err) {
					err();
				}
			});
		}
		//날짜 timestamp 숫자를 받아서 날짜 형식으로 리턴해주는 함수->json 데이터로 받을 때 timestamp로 전달된다.
		function display(timeValue) {
			var today = new Date(); //오늘 날짜 셋팅
			//today.getTime() - timeValue //현재 날짜 시간과 댓글 작성일의 차이
			//차이가 24시간이 지나지 않았으면 시간을 지났으면 날짜를 표시할 수 있도록 한다.
			var dateObj = new Date(timeValue); //댓글을 작성한 날짜 객체
			var str = "";
			str += dateObj.getFullYear() + ".";
			str += (dateObj.getMonth() + 1) + "."; //month는 0~11까지 사용하기 때문에 +1
			str += dateObj.getDate();

			//[yy, mm, dd].join(".") - 중간에 .을 이용해서 이어붙인다.
			return str;
		}
		// 댓글 등록처리함수 선언
		function add(reply, callback, error){
			//데이터 확인
			alert("댓글 등록 : reply :"+JSON.stringify(reply))
			//ajax를 이용해서 데이터 넘기기 처리 - load(), $.getJSON, $.ajax()
			$.ajax({
				type:'post',
				url:'/reply/new',
				//data : ?뒤에 쿼리를 의미 k=v&&k=v : JSON.stringify(json)로 변환
				data:JSON.stringify(reply),
				contentType:"application/json; charset=utf-8",
				//등록이 성공했을 때 처리 -> 댓글 리스트를 다시 불러와서 표시한다.
				success:function(result, status, xhr){
					if(callback){
						callback(result);
						}
				},
				//등록 오륲가 발생된 경우 처리
				error:function(xhr, status, er){
					if(error){
						error(er);
						}
				}
			});
		}
		// 댓글 수정처리함수 선언
		function update(reply, callback, error){
			//데이터 확인
			alert("댓글 수정 : reply :"+JSON.stringify(reply))
			//ajax를 이용해서 데이터 넘기기 처리 - load(), $.getJSON, $.ajax()
			$.ajax({
				type:'patch',
				url:'/reply/'+reply.rno,
				//data : ?뒤에 쿼리를 의미 k=v&&k=v : JSON.stringify(json)로 변환
				data:JSON.stringify(reply),
				contentType:"application/json; charset=utf-8",
				//등록이 성공했을 때 처리 -> 댓글 리스트를 다시 불러와서 표시한다.
				success:function(result, status, xhr){
					if(callback){
						callback(result);
						}
				},
				//등록 오륲가 발생된 경우 처리
				error:function(xhr, status, er){
					if(error){
						error(er);
						}
				}
			});
		}
		return {
			//댓글 리스트가 처리된 결과를 만들어내는 함수
			getList : getList,
			displayDate : display,
			add : add,
			update : update
		}
	})();//함수 만들고 그 함수 바로 호출(맨뒤 ();)

	$(function() { //(여기서의 $는 jquery), 콜백함수이다.
		// 댓글을 처리하는 프로그램 작성
		var no = ${dto.no};
		//댓글 리스트를 표시할 객체 저장
		var replyUL = $(".chat")
		//댓글 리스트를 가져와서 보여주는 함수 호출
		showList(1);
		//alert(replyService.getList);
		//댓글 리스트 : 글보기를 호출하면 바로 보여주는 부분이므로 페이지는 1페이지이다.
		function showList(page) {
			//getList({no, page}, callback function(data), error)
			replyService.getList(
			{
				no : no,
				page : page
			},
			function(list) {
				var str = "";
				//댓글이 없는 경우의 처리
				if (list == null || list.length == 0) {
					replyUL
							.html("<li class='left clearfix'> 댓글이 존재하지 않습니다. </li>");
					return;
				}
				//댓글이 있는 경우의 처리
				for (var i = 0; i < list.length; i++) {
					var dto = list[i];
					str += "<li class='left clearfix' data-rno='"+dto.rno+"'>";
					str += "<div>";
					str += "<div class='header'><strong class='primary-font writer'>"
							+ dto.writer + "</strong>";
					str += "<small class='pull-right text-muted'>"
							+ replyService
									.displayDate(dto.writeDate)
							+ "</small>";
					str += "</div>";
					str += "<p class='content'>" + dto.content + "</p>";
					str += "<span class='pull-right'>"
						+"<button class='btn btn-default btn-xs replyUpdateBtn'>수정</butten>"
						+"<button class='btn btn-default btn-xs replyDeleteBtn'>삭제</butten>"
						+"</span>";
					str += "</div>";
					str += "<hr>";
					str += "</li>";
				}
				replyUL.html(str);
			});
		}
		//댓글 처리에 대한 이벤트 처리
		//댓글 달기 버튼 처리-> 모달창을 보이게 한다.
		$("#writeReplyBtn").click(function() {
			// 댓글 등록으로 제목과 버튼이름을 바꿔야 한다.
			$("#updateModalTitle").text("댓글 등록");
			$("#updateModal_updateBtn").text("등록");
			//등록을 위해서 submit이 일어나도록 버튼 변경
			$("#updateModal_updateBtn").attr("type", "submit");
			//모달 창을 보여주자
			$("#updateModal").modal("show");
		});
		//댓글 등록 버튼 클릭 이벤트->폼의 데이터를 넘기는 이벤트
		$("#modal_form").submit(function(){
			//Ajax로 넘길 데이터를 가저온다.
			var reply =	{
					no:$("#modal_no").val(),
				content:$("#modal_content").val(),
				writer:$("#modal_writer").val(),
				pw:$("#modal_pw").val()
			}
// 			alert(JSON.stringify(reply));
			replyService.add(
				reply, 
				function(result){
					//결과를 경고창으로 보여준다. -> ReplyController에서 리턴해준다.
					alert(result);
					//사용한 모달창의 입력란을 비워둔다.
					$("#updateModal").find("input, textarea").val("");
					// 모달창 숨기기
					$("#updateModal").modal("hide");					

					
					//댓글 리스트를 다시 뿌린다.
					showList(1);
				}
			);
			//submit을 무시시킨다 -> Ajax 처리를 하기 위해서
			return false;
		});

		//댓글의 수정, 삭제 버튼 처리 -> Ajax후에 나타난 버튼이므로 여기서 직접 찾을 때는 Ajax 전이므로 적용이 안된다.
		//->그래서 on(이벤트, 선택자, 함수) : 선택자는 find()에 의해  Ajax후에 다시 찾는다. 
		$(".chat").on("click", ".replyUpdateBtn", function(){
			alert("댓글의 수정 버튼이 클릭됨");
			//클릭한 것이 this, 그 것의 위에서 찾자 : closest
			var replyRow = $(this).closest("li");
			var rno = replyRow.data("rno");
			var content = replyRow.find(".content").text();
			var writer = replyRow.find(".writer").text();
			alert(rno+"/"+content+"/"+writer); 

			//모달 창에 찾은 정보 집어 넣기
			$("#modal_rno").val(rno);
			$("#modal_content").val(content);
			$("#modal_writer").val(writer);

			//수정을 위해서 submit이 안일어나도록 일반 버튼으로 변경
			$("#updateModal_updateBtn").attr("type", "button");
			//버튼 이름을 수정으로 변경
			$("#updateModal_updateBtn").text("수정");

			//작성자를 고칠 수 없게 readonly 설정
			$("#modal_writer").attr("readonly","readonly");

			//패스워드의 타입을 password으로 변경
			$("#modal_pw").attr("type", "password");

			//모달창 열기
			$("#updateModal").modal("show");
		});

		$("#updateModal_updateBtn").click(function(){
			//같은 버튼을 등록과 삭제에서도 사용하기 때문에 등록과 삭제인 경우는 처리를 안하도록 시킨다.
			if($(this).text()=="등록" || $(this).text()=="삭제")
				return;
			alert("수정처리");
			
			// Ajax로 넘길 데이터를 가져온다.
			var reply ={
				rno : $("#modal_rno").val(),
				content :  $("#modal_content").val(),
				pw : $("#modal_pw").val()
			}
	 		alert(JSON.stringify(reply));
			replyService.update(
				reply,
				function(result){
					// 결과를 경고창으로 보여준다. -> ReplyController에서 리턴해준다.
					alert(result);
					// 사용한 모달창의 입력란을 비워둔다.
					$("#updateModal").find("input, textarea").val("");
					// 모달 창은 숨긴다.
					$("#updateModal").modal("hide");
					
					// 댓글 리스트를 다시 뿌린다.
					showList(1);
				}
			);
		});
		//게시판 글보기의 이벤트 처리
		$("#deleteBtn").click(function() {
			if (!confirm("정말 삭제하시겠습니까?"))
				return false; //a tag의 href를 취소시킨다->location.href를 변경하는 태그
		});
	});
</script>
</head>
<body>
	<!-- 제목 -->
	<h1>게시판 글보기</h1>
	<div style="line-height:30px; width:100%; height:30px; border-top: 1px solid #ddd">
		<div style="display:table-cell; vertical-align:middle; width:100px; float:left; text-align: left;"><span style="display:inline-block; width:50px">글 번호</span>&nbsp;<span style="display:inline-block; width:5px">|</span>&nbsp;<span name = "no">${dto.no }</span></div>
		<div style="width:200px; float:right; text-align: right;"><span style="display:inline-block; width:50px">조회수</span>&nbsp;<span style="display:inline-block; width:5px">|</span>&nbsp;<span name="hit" style="display:inline-block; width:80px">${dto.hit }</span></div>
	</div>
	<div style="line-height:30px; vertical-align:middle; width:100%; height:30px; border-top: 1px solid #ddd;">
		<div style="width:200px; float:left"><span style="display:inline-block; width:50px">작성자</span>&nbsp;<span style="display:inline-block; width:5px">|</span>&nbsp;<span name="id">${dto.id }</span></div>
		<div style="width:200px; float:right; text-align: right;"><span style="display:inline-block; width:50px">작성일</span>&nbsp;<span style="display:inline-block; width:5px">|</span>&nbsp;<span name="writeDate" style="display:inline-block; width:80px"><fmt:formatDate value="${dto.writeDate }"
						pattern="yyyy-MM-dd" /></span></div>
	</div>
	<div style="vertical-align:middle; width:100%; border-top: 1px solid #ddd;">
	<div style="line-height:30px; width:100%; height:30px; border-bottom: 1px solid #ddd; text-align: left;"><span style="display:inline-block; width:50px">제목</span>&nbsp;<span style="display:inline-block; width:5px">|</span>&nbsp;<span name="title">${dto.title }</span></div>
	<div><span name="content"><pre>${dto.content }</pre></span></div>
	</div>
	<div style="line-height:30px; width:100%; height:30px; border-top: 1px solid #ddd; border-bottom:1px solid #ddd">
	<div style="text-align:center;">추천수 |&nbsp;<span name="RorN">${dto.r_cnt } / ${dto.n_cnt }</span></div>
	</div>
	<div style="margin: 10px; text-align: right">
	<a href="list.do?page=${param.page }&key=${param.key }&word=${param.word }&gradeNoType=${param.gradeNoType}&orderType=${param.orderType}" class="btn btn-default" role="button"><span class="glyphicon glyphicon-menu-left">돌아가기</span></a>
<%-- 	<c:if test="${login.id == dto.id }"> --%>
	<a href="update.do?no=${dto.no }&page=${param.page }&key=${param.key }&word=${param.word }&gradeNoType=${param.gradeNoType}&orderType=${param.orderType}"
		class="btn btn-default" role="button">수정</a>
	<a href="delete.do?no=${dto.no }&page=${param.page }&key=${param.key }&word=${param.word }&gradeNoType=${param.gradeNoType}&orderType=${param.orderType}" id="deleteBtn" class="btn btn-default" role="button">삭제</a> <!-- 처음엔 안보이게 삭제버튼을 누르면 보이게 -->
<%-- 	</c:if> --%>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<i class="fa fa-comments fa-fw"></i> Reply
			<button id="writeReplyBtn"
				class="btn btn-primary btn-xs pull-right">new Reply</button>
		</div>
		<div class="panel-body">
			<ul class="chat">
				<!-- <li class="left clearfix" data-rno="4">
					<div>
						<div class="header">
							<strong class="primary-font">writer</strong>
							<small class="pull-right text-muted">2020.03.17</small>
						</div>
						<p>
							jjang jjang
						</p>
						<hr>
					</div>
				</li>
				<li class='left clearfix'> 
					댓글이 존재하지 않습니다. 
				</li> -->
			</ul>
		</div>
	</div>
	<%-- <table class="table">
		<tr>
			<td>글번호</td>
			<td>${dto.no }</td>
		</tr>
		<tr>
			<td>글제목</td>
			<td>
				<font color="${(dto.gradeNo == 8) ? 'blue':''}">
				${dto.title }
				</font>
			</td>
		</tr>
		<tr>
			<td>글내용</td>
			프로퍼티로 출력만하면 html에서 줄바꿈을 무시한다. => pre tag 사용해라.
			<td><pre>${dto.content }</pre></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${dto.id }</td>
		</tr>
		<tr>
			<td>작성일</td>
			<td><fmt:formatDate value="${dto.writeDate }"
					pattern="yyyy-MM-dd" /></td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${dto.hit }</td>
		</tr>
		<tr>
			<td colspan="2"><a href="update.do?no=${dto.no }"
				class="btn btn-default" role="button">수정</a> <a href=""
				id="deleteBtn" class="btn btn-default" role="button">삭제</a> <!-- 처음엔 안보이게 삭제버튼을 누르면 보이게 -->
				<a href="list.do?page=${param.page }&perPageNum=${param.perPagenum }&key=${param.key }&word=${param.word }">목록</a>
				</td>
		</tr>
		<!-- 댓글 -->
		<tr>
			<td colspan="2">
				
			</td>
		</tr>
	</table> --%>
	<!-- 댓글 달기와 수정을 위한 Modal -->
  <div class="modal fade" id="updateModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-pencil"></span> 
          	<span id="updateModalTitle">댓글 수정</span>
          </h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form role="form" method="post" id="modal_form">
          	<input type="hidden" name="rno" id="modal_rno">
            <input name="no" type="hidden" id="modal_no" value="${dto.no }" />
			<input name="page" type="hidden" value="${param.page }" />
            <div class="form-group">
              <label for="modal_content">
                <span class="glyphicon glyphicon-pencel"></span>
               	내용
              </label>
              <textarea class="form-control" id="modal_content" name="content"
               rows="3"></textarea>
            </div>
            <div class="form-group">
              <label for="modal_content">
                <span class="glyphicon glyphicon-user"></span>
               	작성자
              </label>
              <input class="form-control" id="modal_writer" name="writer">
            </div>
            <div class="btn-group right">
             <button type="submit" class="btn btn-primary"
              id="updateModal_updateBtn">수정</button>
          	 <button type="button" class="btn btn-warning" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> 취소</button>
			</div> 
          </form>
        </div>
    </div>
  </div> 
</div>
</body>
</html>