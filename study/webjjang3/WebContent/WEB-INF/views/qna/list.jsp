<%@page import="com.webjjang.main.Execute"%>
<%@page import="com.webjjang.bean.Beans"%>
<%@page import="com.webjjang.main.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 라이브러리 불러와야 데이터 불러올 수 있음... -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<% 
	Service service = Beans.getService("qnaListService");
	request.setAttribute("list", Execute.service(service, 1));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문답변 리스트</title>
<!-- bootstrap lib는 default_decorator에 적용했으므로 생략 -->

<style type="text/css">
.dataRow:hover {
	background: #eee;
	cursor: pointer;
}
</style>

<!-- jquery는 function임.. -->
<!-- function은 메인메모리에 주소를 올림.. -->
<!-- 그주소를 참조로 해서 받으면 된다. -->
<script type="text/javascript">
$(document).ready(function(){
//alert("start");	
//이벤트 처리
	$(".dataRow").click(function(){
		// alert("dataRow click");
		no = $(this).find(".no").text();
		// no를 찾기...
		// text()메소드에서 ()를 비워두면 getter, ()안에 데이터를 넣으면 setter
		// alert(no);
		location = "view.do?no=" + no + "&cnt=1";
	});
});

</script>




</head>
<body>

	<div class="container">
		<h1>질문답변 리스트</h1>
		<table class="table">
			<!-- 테이블의 한줄 -->
			<!-- 항목의 제목 -->
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자(ID)</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>

			<!-- 데이터표시줄: 데이터가 있는 만큼 반복처리한다.에서 꺼내쓴다... -->
			<c:forEach items="${list }" var="dto">
				<tr  class="dataRow">
					<td class ="no">
						${dto.no }</td>
					<td>
						${(dto.levNo > 0)? "":"" }
<!-- 					들여쓰기 -->
						<c:forEach begin="1" end="${ dto.levNo * 5}">&nbsp;</c:forEach>
						
						
<!-- 						revno가 0보다 크면 꺽쇠표시넣기 -->
						
						<i class="material-icons">${(dto.levNo > 0)? "&#xe5da;":"" }</i>
						${dto.title }</td>
					<td>${dto.name }[${dto.id}]</td>
					<td>${dto.writeDate }</td>
					<td>${dto.hit }</td>
			
				</tr>
			</c:forEach>

			<!-- 질문답변 쓰기 버튼 -->
			<tr>
				<td colspan="5"><a href="writeForm.do"><button>질문하기</button></a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
