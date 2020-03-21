<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Webjjang:: Board View</title>
<style type="text/css">
.chat {
	list-style-type: none;
}

.dataRow:hover {
	background-color: #eee;
	cursor: pointer;
}

#pwDiv {
	display: none;
} /*비밀번호받는태그 일단 숨겨놓고 밑에 jquery에서 삭제버튼누르면보이게  */
</style>
<script type="text/javascript">
	//댓글 객체 - 속성, 함수
	var replyService = (function() {

		//---------------------------------------------------------------------------------------------
		//getList를 저장하는 프로그램 작성 -> 필요한 데이터 param(no, page), callback(처리되는함수를 넣는다.), error(오류가났을때 객체)
		function getList(param, callback, error) {
			var no = param.no;
			var page = param.page;

			//jSON데이터 받아오기 . ajax말고 이런식으로도 가능
			//달러.getJSON(데이터요청URI, 데이터받기성공시처리)
			$.getJSON("/reply/pages/" + no + "/" + page + ".json",
					function(data) { //data: 서버에서 넘어오는 데이터
						//데이터가져오기성공하면 실행되는 함수를 밖에서 선언해서 넣어주는경우 처리
						if (callback) {
							callback(data);
						}
					}
			//데이터 가져오는 것 실패했을때 처리
			).fail(function(xhr, status, err) {
				if (err) { //에러가 존재하면
					err(); //에러를 호출한다.
				}
			});
		}

		//---------------------------------------------------------------------------------------------
		//날짜 timestamp 숫자를 받아서 날짜 형식을 리턴해주는 함수. -> json데이터로 받을떄 timestamp로 전달된다.
		function displayDate(timeValue) {
			var today = new Date(); //오늘 날짜 셋팅
			// today.getTime() - timeValue // 현재 날짜 시간과 댓글작성일의 차이를 알수있다.
			// 차이가 24시간이 지나지 않았으면 시간을 표시, 지났으면 날짜를 표시.
			var dateObj = new Date(timeValue); //댓글을 작성한 날짜 객체
			var str = "";
			//[yy.mm.dd].join(".") 마침표로 이어붙인다.
			str += dateObj.getFullYear() + ".";
			str += (dateObj.getMonth() + 1) + "."; //month는 0~11까지라서 +1해야 한다.
			str += dateObj.getDate();

			return str;
		}

		//댓글 등록 처리 함수 선언(reply는 json데이터, callback함수, error함수)
		// JSON.stringify 함수를 이용하고, contentType을 "application/json"으로 설정해주어야 한다는 것입니다. 그렇지 않으면 @RequestBody로 정보를 받을 수 없다.
		function add(reply, callback, error) {
			//ajax로 데이터 넘기는 방법: load(), 달러.getJSON, 달러.ajax()
			$.ajax({
				type : 'post',
				url : '/reply/new',
				//data: ?뒤에 쿼리를 의미. k=v&k=v. stringify는 json데이터로 만들어준다.
				data : JSON.stringify(reply),
				contentType : "application/json; charset=utf-8",
				//등록 성공시: 댓글리스트를 불러와서 표시
				success : function(result, status, xhr) {
					if (callback) {
						callback(result);
					}
				},
				//등록오류발생시
				error : function(xhr, status, er) {
					if (error) {
						error(er);
					}
				}

			})
		}

		//댓글 수정 처리 함수 선언(reply는 json데이터, callback함수, error함수)
		// JSON.stringify 함수를 이용하고, contentType을 "application/json"으로 설정해주어야 한다는 것입니다. 그렇지 않으면 @RequestBody로 정보를 받을 수 없다.
		function update(reply, callback, error) {
			//ajax로 데이터 넘기는 방법: load(), 달러.getJSON, 달러.ajax()
			$.ajax({
				type : 'patch',
				url : '/reply/' + reply.rno,
				//data: ?뒤에 쿼리를 의미. k=v&k=v. stringify는 json데이터로 만들어준다.
				data : JSON.stringify(reply),
				contentType : "application/json; charset=utf-8",
				//등록 성공시: 댓글리스트를 불러와서 표시
				success : function(result, status, xhr) {
					if (callback) {
						callback(result);
					}
				},
				//등록오류발생시
				error : function(xhr, status, er) {
					if (error) {
						error(er);
					}
				}

			})
		}

		return {
			//댓글리스트가 처리된 결과를 만들어내는 함수를 넣는다.
			getList : getList, //댓글리스트
			displayDate : displayDate,
			add : add, //댓글추가
			update : update
		//댓글수정
		}

	})();

	$(function() {

		//댓글을 처리하는 프로그램 작성(선언은 위에 하고 밑에 . 화면 로드가 실행되면 실행된다.)
		var no = ${dto.no};
		//댓글리스트를 표시할 객체 저장
		var replyUL = $(".chat")

		//댓글리스트를 가져와서 보여주는 함수 호출 (1페이지 넘긴다.)
		showList(1);

		//댓글 리스트를 보여주는 function: 글보기를 호출하면 바로 보여주는 부분이므로 페이지는 1페이지이다.
		function showList(page) { //(1페이지 받는다))
			//alert(replyService.);
			replyService
					.getList(
							//함수호출(param, callback, error) 전달.
							{
								no : no,
								page : page
							}, //처음 board/view.do로드할때 댓글 페이지는 1
							function(list) {
								//alert(list);
								//alert(list[0].rno);
								var str = "";
								//댓글이 없는 경우
								if (list == null || list.length == 0) {
									replyUL
											.html("<li class='left clearfix'>댓글 존재하지 않습니다.</li>")
									return;
								}
								//댓글이 있는 경우의 처리
								for (var i = 0; i < list.length; i++) {
									var dto = list[i];
									str += "<li class='left clearfix' data-rno='"+dto.rno+"'>";
									str += "<div><div class='header'><strong class='primary-font writer'>"
											+ dto.writer + "</strong>";
									str += "<small class='pull-right text-muted'>"
											+ replyService
													.displayDate(dto.writeDate)
											+ "</small></div>";
									str += "<p class='content'>"
											+ dto.content
											+ "</p>"
											+ "<span class='pull-right'>"
											+ "<button class='btn btn-default btn-xs replyUpdateBtn'>update</button>"
											+ "<button class='btn btn-default btn-xs replyDeleteBtn'>delete</button>"
											+ "</span>";
									str += "</div><hr></li>";
								}
								replyUL.html(str);
							});
		}

		//댓글에 대한 이벤트 처리
		//댓글달기 버튼처리 -> 모달창을 보이게 한다.
		$("#writeReplyBtn").click(function() {
			//밑에 버튼들에 수정에 관한 text가 젹혀있는데, 여기서는 write 처리이기때문에 writeReplyBtn클릭시 write관련 text로 바꿔준다.(코드재활용) update버튼클릭시 원래의 텍스트내용이 보인다.
			$("#updateModalTitle").text("Write a new comment.");
			$("#updateModal_updateBtn").text("write");
			// 등록을 위해서 submit이 되도록 변경
			$("#updateModal_updateBtn").attr("type", "submit");
				
			//모달창을 보여준다.
			$("#updateModal").modal("show");
		});

		//댓글의 수정,삭제 버튼 처리
		//ajax 후에 나타나는 버튼이므로 그냥 .click()으로 여기서 직접 찾을대는 적용이 안된다. 
		//.click()은 처음에 나타난 태그에만 적용되고, onclick()은 동적으로 추가된 이벤트에도 적용이 된다.
		//★그래서 on(event, 선택자, 함수) : 선택자는 find()함수에 의해 찾기가 진행되어 뒤에있는 function이 붙게되어 다 있는 상테에서 적용이 된다.
		$(".chat").on("click", ".replyUpdateBtn", function(){
			//alert("댓글 수정버튼 클릭됨");
			//클릭한 것에서 가장 가까운 li태그 
			var replyRow = $(this).closest("li"); 
			var rno = replyRow.data("rno"); //★data-rno으로 써진거는 .data(rno)으로 가져온다.
			var content = replyRow.find(".content").text();
			var writer = replyRow.find(".writer").text();
			//alert(rno+"/"+content+"/"+writer);

			//모달창에 수정할 기존 데이터 셋팅
			$("#modal_rno").val(rno);
			$("#modal_content").val(content);
			$("#modal_writer").val(writer);
			$("#modal_pw").val("");
			//작성자 수정못하게
			$("#modal_writer").attr("readonly", "readonly");
			//수정을 위해 submit에서 동작되지 않는 button으로 변경
			$("#updateModal_updateBtn").attr("type", "button");
			//버튼이름 수정으로. (코드재사용)
			$("#updateModal_updateBtn").text("update");
			//password타입으로 바꾸기(비번안보이게)
			$("#modal_pw").attr("type", "password"); 
			$("#updateModal").modal("show");
			
		});


		$("#updateModal_updateBtn").click(function(){
			//같은 버튼 재사용 -> 댓글등록, 삭제인 경우 처리 안한다.
			if($(this).text()=="write" || $(this).text()=="delete"){
				alert();
				return;}
				// Ajax로 넘길 데이터를 가져온다.
				var reply ={
					rno :  $("#modal_rno").val(),
					content :  $("#modal_content").val(),
					pw : $("#modal_pw").val()
				}
		 		alert(JSON.stringify(reply));
				replyService.update(//함수호출
					reply,
					function(result){
						// 결과를 경고창으로 보여준다. -> ReplyController에서 리턴해준다.
						alert(result);
						// 사용을한 모달창의 입력란(인풋태그, 텍스트에어리어)을 비워둔다.
						$("#updateModal").find("input, textarea").val("");
						// 모달 창은 숨긴다.
						$("#updateModal").modal("hide");
						
						// 댓글 리스트를 다시 뿌린다.
						showList(1);
					}
				);

			});
		
		$("#deleteBtn").click(function() {
			$("#pwDiv").show(); //css에서 태그 숨겨놓았음. 삭제버튼클릭시 보이게 한다.
			//href="" -> 자신을 다시 호출함 -> false: 호출을 무시한다.
			return false;
		});

		//댓글등록 이벤트처리
		$("#modal_form").submit(function() {
			//Ajax로 넘길 데이터를 가져와서 json저장.
			//event.preventDefault();
			var reply = {
				content : $("#modal_content").val(),
				writer : $("#modal_writer").val(),
				pw : $("#modal_pw").val(),
				no : $("#modal_no").val()
			}
			//alert(JSON.stringify(reply));
			//add함수 실행 . ajax로 보내고 돌아온 결과
			replyService.add(reply, function(result) {
				//결과를 경고창으로 보여주고 replycontroller에서 리턴해준다.
				alert(result);
				//사용을 한 모달창의 입력란을 비워둔다.
				$("#updateModal").find("input, textarea").val("");
				$("#updateModal").modal("hide");
				//댓글리스트를 다시 뿌린다.(페이지는1)
				showList(1);
			});
			return false; // 폼태그는 url전송하는것이기 때문에 submit안되게 무시시킨다. 이건 아작스처리이기때문에 url바뀌지 않으므로.
		});
	})
</script>
</head>
<body>
	<div class="container">


		<h3>Board View</h3>
		<!-- table에 부트스트랩적용: clss명 table로 지정하면 된다. -->
		<table class="table">
			<tr>
				<th>No</th>
				<!-- dto.no는 getNo()를 호출한것임. 이걸 property라고 한다. -->
				<td>${dto.no }</td>
			</tr>
			<tr>
				<th>Title</th>
				<td>${dto.title }</td>
			</tr>
			<tr>
				<th>Writer</th>
				<td>${dto.writer }</td>
			</tr>

			<tr>
				<th>Write date</th>
				<td><fmt:formatDate value="${dto.writeDate}"
						pattern="yyyy.MM.dd" /></td>
			</tr>
			<tr>
				<th>Hit</th>
				<td>${dto.hit }</td>
			</tr>
			<tr>
				<th>Content</th>
				<td><pre>${dto.content }</pre></td>
			</tr>
			<tr>
				<td colspan="2">
					<!-- role은 bootstrap적용 위함(w3schools에서확인), class btn뒤에 btn-default도 w3schools에서 주는 스타일 확인 후 적용 -->
					<a href="update.do?no=${dto.no }" class="btn btn-default"
					role="button">Update</a> <a href="" id="deleteBtn"
					class="btn btn-default" role="button">Delete</a> <a href="list.do"
					class="btn btn-default" role="button">Back to List</a> <!-- pw입력받기 (id로 css에서 숨겨놨다가 버튼클릭하면 jquery에서 보이게-->
					<div id="pwDiv">
						<form action="delete.do" method="post">
							<!-- 비번따문에 post로 넘겨야 해서 form 태그나 ajax로 넘겨야한다. -->
							<input type="hidden" name="no" value="${dto.no }" />
							<!-- controller에 아이디를 넘겨야 삭제되므로 hidden으로 넘긴다.  -->
							<div class="form-group">
								<label for="pw">Password:</label> <input type="password"
									class="form-control" id="pw" name="pw" autocomplete="off"
									title="비밀번호는 4~20 글자 사이로 입력하셔야 합니다." pattern="^.{4,20}$">
							</div>
							<button>Delete</button>
						</form>
					</div>
				</td>
			</tr>
			<!--댓글----- --------------------------- -->
			<tr>
				<td colspan="2">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-comments fa-fw"></i>comments
							<button id="writeReplyBtn"
								class="btn btn-primary btn-xs pull-right">new comment</button>
						</div>
						<div class="panel-body">
							<ul class="chat">

							</ul>
						</div>
					</div>
				</td>
			</tr>
		</table>
		<!-- 	</div> -->
		<!-- 댓글 달기와 수정을 위한 Modal -->
		<div class="modal fade" id="updateModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header" style="ping: 35px 50px;">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4>
							<span class="glyphicon glyphicon-pencil"></span> <span
								id="updateModalTitle">Update comment</span>
						</h4>
					</div>
					<div class="modal-body" style="ping: 40px 50px;">
						<form role="form" method="post" id="modal_form">
							<input type="hidden" name="rno" id="modal_rno"> <input
								name="no" id="modal_no" type="hidden" value="${dto.no }" /> <input
								name="page" type="hidden" value="${param.page }" /> <input
								name="perPageNum" type="hidden" value="${param.perPageNum }" />
							<div class="form-group">
								<label for="modal_content"> <span
									class="glyphicon glyphicon-calendar"></span> 내용
								</label>
								<textarea class="form-control" id="modal_content" name="content"
									rows="3"></textarea>
							</div>
							<div class="form-group">
								<label for="modal_content"> <span
									class="glyphicon glyphicon-user"></span> 작성자
								</label> <input class="form-control" id="modal_writer" name="writer">
							</div>
							<div class="form-group">
								<label for="modal_content"> <span class="fa fa-key"></span>
									비밀번호
								</label> <input class="form-control" id="modal_pw" name="pw">
								<div>본인 댓글 확인 비밀번호입니다.</div>
							</div>
							<div class="btn-group right">
								<button type="submit" class="btn btn-primary"
									id="updateModal_updateBtn"></button>
								<button type="button" class="btn btn-warning"
									data-dismiss="modal">
									<span class="glyphicon glyphicon-remove"></span>cancel
								</button>
							</div>
						</form>
					</div>
					<a
						href="list.do?page=${param.page }&perPageNum=${param.perPageNum }&key=${param.key }&word=${param.word}">list</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>