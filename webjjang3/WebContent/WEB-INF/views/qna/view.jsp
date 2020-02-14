<%@page import="com.webjjang.main.Execute"%>
<%@page import="com.webjjang.bean.Beans"%>
<%@page import="com.webjjang.main.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%

Service service = Beans.getService("qnaViewService");

//여기가 자바 부분입니다.
//글번호와 조회수1증가를 받는다. 글번호가 넘어오지 않으면 오류가 난다. -> 반드시 리스트에서부터 들어와야 한다.
int no = Integer.parseInt(request.getParameter("no"));
int cnt = Integer.parseInt(request.getParameter("cnt"));
//Execute.service(qnaviewservice, 글번호, 조회수 1 증가);
request.setAttribute("dto", Execute.service(service, no, cnt));

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문답변 보기</title>

<script type="text/javascript">

$(function() {
	//버튼 이벤트 처리
	$("#deleteBtn").click(function () {
		if(!confirm("정말 삭제하시겠습니까?"))
			return false; //a tag의 href를 취소시킨다. -> location.href를 변경하는 태그 a
	});

});
</script>


<!-- Bootstrap library -->

</head>
<body>
<h1>질문답변 보기</h1>
<table class = "table">
<tr>
<th>글번호</th><td>${dto.no }</td>
</tr>
<tr>
<th>제목</th><td>${dto.title }</td>
</tr>
<tr>
<th>내용</th><td><pre>${dto.content }</pre></td>
</tr>
<tr>
<th>이름[아이디]</th><td>${dto.name }[${dto.id }]</td>
</tr>
<tr>
<th>조회수</th><td>${dto.hit }</td>
</tr>
<tr>
<td colspan="2">
<a href="answerForm.do"><button type="button" class="btn btn-primary">답변하기</button></a>
<a href="updateForm.do?no=${dto.no }"><button type="button" class="btn btn-primary">수정</button></a>
<a href="delete.do?no=${dto.no }"><button type="button" class="btn btn-primary">삭제</button></a>
<a href="list.do"><button type="button" class="btn btn-primary">목록</button></a>
</tr>
</table>
</body>
</html>