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
var replyService = (function(){

	//getList를 저장하는 프로그램 작성 -> 필요한 데이터 param(no, page), callback(처리되는함수를 넣는다.), error(오류가났을때 객체)
	function getList(param, callback, error){
		var no = param.no;
		var page = param.page;

		//jSON데이터 받아오기 . ajax말고 이런식으로도 가능
		//달러.getJSON(데이터요청URI, 데이터받기성공시처리)
		$.getJSON("/reply/pages/" + no + "/" + page + ".json",
		function(data){ //data: 서버에서 넘어오는 데이터
			//데이터가져오기성공하면 실행되는 함수를 밖에서 선언해서 넣어주는경우 처리
			if(callback){
				callback(data);
		
				}
			}
		//데이터 가져오는 것 실패했을때 처리
				 ).fail(function(xhr, status, err){
					if(err){ //에러가 존재하면
						err(); //에러를 호출한다.
						}
					 });
		}

	//날짜 timestamp 숫자를 받아서 날짜 형식을 리턴해주는 함수. -> json데이터로 받을떄 timestamp로 전달된다.
	function displayDate(timeValue){
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

	
	return {
		//댓글리스트가 처리된 결과를 만들어내는 함수를 넣는다.
		getList : getList,
		displayDate : displayDate
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
		function showList(page){ //(1페이지 받는다))
			//alert(replyService.getList);
			replyService.getList( //위에서선언한 함수 호출
				{no:no, page:page}, //처음 board/view.do로드할때 댓글 페이지는 1
				function(list){
					//alert(list);
					//alert(list[0].rno);
					var str = "";
					//댓글이 없는 경우의 처리
					if(list == null || list.length == 0){
						replyUL.html("<li class='left clearfix'>댓글 존재하지 않습니다.</li>")
						return;
					}
					//댓글이 있는 경우의 처리
					for(var i = 0; i < list.length; i++){
						var dto = list[i];
						str += "<li class='left clearfix' data-rno='"+dto.rno+"'>";
						str += "<div><div class='header'><strong class='primary-font'>"+dto.writer+"</strong>";
						str += "<small class='pull-right text-muted'>"+replyService.displayDate(dto.writeDate)+"</small></div>";
						str += "<p>"+dto.content+"</p></div><hr></li>";
					}
					replyUL.html(str);
				}
			);
		}
		$("#deleteBtn").click(function(){
			$("#pwDiv").show(); //css에서 태그 숨겨놓았음. 삭제버튼클릭시 보이게 한다.
			//href="" -> 자신을 다시 호출함 -> false: 호출을 무시한다.
			return false;
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
			<tr>
				<td colspan="2">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-comments fa-fw"></i>comments
						</div>
						<div class="panel-body">
							<ul class="chat">

							</ul>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>