<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
<style type="text/css">
.fileSpace {
	list-style: none;
}
</style>
<script type="text/javascript">
var counter = 0;
alert(counter);
$(function(){
	//파일 리스트를 표시할 객체 저장
	var arrayFile = $(".fileSpace");
	var str = "";
	$("#fileAddBtn").click(function(e){
		str += "<li>"
		str += "<button type='button' class='fileDeleteBtn'><span class='glyphicon glyphicon-remove'></span></button>"
		str += "<input type='file' multiple='multiple' class='file' name='multiFile'/>";
		str += "</li>"
		$(".fileSpace").append(str);
		str="";
	});
	$(document).on("click",".fileDeleteBtn",(function(e){
		$(this).closest("li").remove();
		
	}));
	$("#writeForm").on("submit", function(e){
		var f_cnt = $(".file").length;
		var f = $(".file");
		for (i=0; i<f_cnt; i++){
			if(f[i].value==null || f[i].value==""){
				f[i].closest("li").remove();
			}
		}
		
	});
});
</script>
</head>
<body>
	<h1>게시판 글쓰기</h1>
	<form method="post" action="write.do" id="writeForm" enctype="multipart/form-data">
		<!-- bootstrap의 폼 : form-> form-group -> form-control -->
		<!-- 제목 입력 -->
		<div class="form-group">
			<label for="title">제목</label>
			<!-- 입력한 데이터의 앞뒤 공백문자는 제거(trim())
   			 id, class : 화면 컨트롤을 위해서(빠른 선택), name : 넘어가는 데이터 이름 -->
			<!-- <input type="text" class="form-control" id="title" name="title" required="required" pattern="^.{4,100}$" title="제목을 4~100 글자 사이로 입력하셔야 합니다."> -->
			<input type="text" class="form-control" id="title" name="title"
				title="제목을 4~100 글자 사이로 입력하셔야 합니다.">
		</div>
		<!-- 내용 입력 -->
		<div class="form-group">
			<label for="content">내용</label>
			<!-- <textarea class="form-control" rows="5" id="content" name="content" required="required" ></textarea> -->
			<textarea class="form-control" rows="5" id="content" name="content"></textarea>
		</div>
		<!-- 작성자 login session->controller -->
		<!-- 첨부파일 -->
		<div class="form-group">
			<label for="multiFile">첨부파일</label>
			<button type="button" id="fileAddBtn">
			<span class="glyphicon glyphicon-plus"/>
			</button>
			<div class="fileSpace">
			</div>
<!-- 			<input type="file" multiple="multiple" class="form-control" id="multiFile" name="multiFile" required="required"> -->
		</div>
		<!-- 버튼 처리 : button은 기본 type이 submit이다.(데이터 넘기는 함수 호출)-->
		<button type="submit" class="next">등록</button>
		<button type="reset">다시입력</button>
		<button class="cancelBtn" type="button">취소</button>
		
	</form>
</body>
</html>