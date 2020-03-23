<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.total_contents{
	overflow: hidden;
}
/*메인오른쪽 */
#main{
float: left;
width: 75%;
margin: 10px;
padding: 10px;
}

/*sideBar*/
#sideBar{
float: right;
width: 25%;
margin: 10px;
padding: 10px;
position: static;
}

</style>
<script type="text/javascript">
	$(function() {
		$(".news").click(function() {
			var nno = $(this).find(".nno").text();
			location = "view.do?nno=" + nno
			+ "&cnt=1"
			+ "&page=${pageObject.page }"
			+ "&perPageNum=${pageObject.perPageNum}";
		});
	})
</script>

</head>
<body>
<div class="contaner">
<div class="total_contents">
<div class="main" id="main">
	<c:forEach items="${dto }" var="dto">
	<div class=news>
	<div hidden="${dto.nno }" class="nno"></div>
	<div>${dto.press }</div>
	<div>${dto.title }</div>
	<div>${dto.write_date }</div>
	</div>
	<br/>
	</c:forEach>
</div>

<div class="sideBar" id="sideBar">
ttt??
<!--검색  및 최다검색어-------------------------------------- -->
<div class="newsB"><h4>뉴스 검색</h4>
	<div class="searchB">
	    <form action="/news">
	        <input type="text" name="keyword" class="txt" style="color:#aaaaaa;" value="검색어를 입력하세요." tabindex="0">
	        <a href="" class="btnSearch" title="검색">검색</a>
	    </form>
	</div>
	
	<div class="hashtag">
	    <h5>인기키워드</h5>
	    <ul>
		<!--최다검색어 넣을 곳  -->        
	        <li class="ty01"><a href="/news?keyword=%EC%A7%84%EB%8B%A8%ED%82%A4%ED%8A%B8">#진단키트</a></li>
	    </ul>
	</div>
	</div>
<!-- -------------------------------------------- -->
</div>
</div>
<!-- end of container -->
</div>



</body>
</html>