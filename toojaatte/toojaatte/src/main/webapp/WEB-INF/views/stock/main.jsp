<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>toojaatte::stock main</title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR|Sawarabi+Gothic&display=swap"
	rel="stylesheet">
<style type="text/css">
<style>
* {
	box-sizing: border-box;
}

body {
	font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
	padding: 30px;
	text-align: center;
	font-size: 35px;
}

/* Container for flexboxes */
section {
	display: -webkit-flex;
	display: flex;
}

/* Style the navigation menu 사이드바 */
nav {
	-webkit-flex: 1;
	-ms-flex: 1;
	flex: 1;
	padding: 20px;
}

/* Style the content 메인뉴스*/
article {
	-webkit-flex: 3;
	-ms-flex: 3;
	flex: 3;
	padding: 10px;
	border-right: 1px black;
	border-color: black;
	border: 2px;
}

.news:hover {
	background-color: #eee;
	cursor: pointer;
}

/*오른쪽에 구분선 넣어야함*/
#main.main {
	border-right: 1px black;
	border-color: black;
	border: 2px;
}

/*말줄임표 생략되게 수정해야함------------------------*/
.hitNews_contents {
	overflow: hidden;
	text-overflow: ellipsis;
}

/* Responsive layout - makes the menu and the content (inside the section) sit on top of each other instead of next to each other */
@media ( max-width : 600px) {
	section {
		-webkit-flex-direction: column;
		flex-direction: column;
	}
}
</style>
</head>
<body>
	<div class="container">
	<section>
	<article>
		<form action="/stock/market/search.do" method="GET" name="searchForm">
			<div class="input-group">
				<p>주식 검색 (단축코드 또는 종목명 입력)</p>
				<input type="text" class="form-control" placeholder="Search"
					name="searchData">
				<div class="input-group-btn">
					<button class="btn btn-default" type="submit">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</div>
			</div>
		</form>
		<div class="row">
			<div class="col">
				<ul class="nav nav-tabs">
					<li class="nav-item"><a class="nav-link active"
						data-toggle="tab" href="#qwe">코스피 지수</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="tab"
						href="#asd">코스닥 지수</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="tab"
						href="#zxc">코스피200 지수</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane show active" id="qwe">
						<span> <strong style="size: 20px;">  ${kospi[0].open}</strong>
								<fmt:formatNumber value="${kospi[0].open - kospi[1].open}"
									pattern="0.00"></fmt:formatNumber>
								<fmt:formatNumber value="${kospi[0].change}" pattern="0.00%"></fmt:formatNumber>
						</span>
						<div id="curve_chart" style="width: 800px; height: 340px"></div>
						
					</div>
					<div class="tab-pane fade" id="asd">
				<span> <strong>${kosdaq[0].open}</strong>
								<fmt:formatNumber value="${kosdaq[0].open - kosdaq[1].open}"
									pattern="0.00"></fmt:formatNumber>
								<fmt:formatNumber value="${kosdaq[0].change}" pattern="0.00%"></fmt:formatNumber>
					</span>
					<div id="curve_chart2" style="width: 800px; height: 340px"></div>
					
					</div>
					<div class="tab-pane fade" id="zxc">
						<span> <strong>${kospi200[0].open}</strong>
								<fmt:formatNumber value="${kospi200[0].open - kospi200[1].open}"
									pattern="0.00"></fmt:formatNumber>
								<fmt:formatNumber value="${kospi200[0].change}" pattern="0.00%"></fmt:formatNumber>
					</span>
					<div id="curve_chart3" style="width: 800px; height: 340px"></div>
					
					</div>
				</div>
			</div>
		</div>
		</article>
		<!--사이드바 -------------------------------->
			<nav>
	

				<!-- 조회수높은뉴스 -->
				<div class="hitNews">
					<h4>많이본 뉴스</h4>
					<div class="hitNews_contents">
					<hr/>
						<ul class="list">
							<c:forEach items="${mostViewed }" var="mostViewed">
								<!-- /*말줄임표 생략되게 수정해야함------------------------*/
							 -->
								<li style="list-style: none;"><a href="view.do?nno=${mostViewed.nno}&cnt=1">
										${mostViewed.title }</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>

			</nav>
			</section>
	</div>
	
	
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
		<!-- google chart -->
	<script type="text/javascript"
		src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript">
		//google chart============================
		google.charts.load('current', {'packages':['corechart']});
	    google.charts.setOnLoadCallback(drawKospiChart);
	    google.charts.setOnLoadCallback(drawKosdaqChart);
	    google.charts.setOnLoadCallback(drawKospi200Chart);
	    
       	function drawKospiChart() {
          var data = new google.visualization.arrayToDataTable([
          	['year', 'kospi'],
	          	//데이터 과거순이기때문에 역순으로 정렬. foreach에 step=-1없다.
	          	<c:forEach var="i" begin="0" end="51" step="1">
	          		<c:set var="date" value="${kospi[51-i].stringDate}"/>
	          		<c:set var="close" value="${kospi[51-i].close}"/>
	          	     ['${date}', ${close}], //쉼표 안쓰면 오류난다.
	          	</c:forEach> 
            ]);
        var options = {
          legend: { position: 'none' },
        };
        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
        chart.draw(data, options);
      };


       	function drawKosdaqChart() {
          var data = new google.visualization.arrayToDataTable([
          	['year', 'kospi'],
	          	//데이터 과거순이기때문에 역순으로 정렬. foreach에 step=-1없다.
	          	<c:forEach var="i" begin="0" end="51" step="1">
	          		<c:set var="date" value="${kosdaq[51-i].stringDate}"/>
	          		<c:set var="close" value="${kosdaq[51-i].close}"/>
	          	     ['${date}', ${close}], //쉼표 안쓰면 오류난다.
	          	</c:forEach> 
            ]);
        var options = {
          legend: { position: 'none' },
        };
        var chart = new google.visualization.LineChart(document.getElementById('curve_chart2'));
        chart.draw(data, options);
      };

      
       	function drawKospi200Chart() {
          var data = new google.visualization.arrayToDataTable([
          	['year', 'kospi'],
	          	//데이터 과거순이기때문에 역순으로 정렬. foreach에 step=-1없다.
	          	<c:forEach var="i" begin="0" end="51" step="1">
	          		<c:set var="date" value="${kospi200[51-i].stringDate}"/>
	          		<c:set var="close" value="${kospi200[51-i].close}"/>
	          	     ['${date}', ${close}], //쉼표 안쓰면 오류난다.
	          	</c:forEach> 
            ]);
        var options = {
          legend: { position: 'none' },
        };
        var chart = new google.visualization.LineChart(document.getElementById('curve_chart3'));
        chart.draw(data, options);
      };
      </script>


</body>
</html>