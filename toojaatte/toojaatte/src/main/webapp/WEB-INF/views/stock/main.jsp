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
<
style>* {
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

.hitNews_contents {
	overflow: hidden;
	text-overflow: ellipsis;
}
.mostViewedTitles{
	font-size: 13px;
	margin: 4px 4px;
	padding-bottom: 5px;
}
.searchTerm {
	width: 90%;
	border: 1.5px solid #004a99;
	border-right: none;
	padding: 5px;
	height: 36px;
	border-radius: 5px 0 0 5px;
	outline: none;
	color: #9DBFAF;
}

.searchTerm:focus {
	color: #00B4CC;
}

.searchButton {
	width: 40px;
	height: 36px;
	border: 1px solid #004a99;
	background: #004a99;
	text-align: center;
	color: #fff;
	border-radius: 0 5px 5px 0;
	cursor: pointer;
	font-size: 20px;
	float: left;
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
				<div class="search">
					<form action="/stock/market/search.do" method="GET"
						name="searchForm">
						<div>
							<p><strong>주식 검색</strong></p>
							<input type="text" class="searchTerm"
								placeholder="단축코드 또는 종목명을 입력하세요." name="searchData">
							<button class="searchButton">
								<i class="fa fa-search"></i>
							</button>
							<br><br>
						</div>
					</form>
				</div>
				<div class="row">
					<div>
					<h4><strong>코스피 지수</strong></h4>
					<span> <strong style="size: 20px;">${kospi[0].open}</strong> 
					<fmt:formatNumber value="${kospi[0].open - kospi[1].open}" pattern="0.00"></fmt:formatNumber>
					<fmt:formatNumber value="${kospi[0].change}" pattern="0.00%"></fmt:formatNumber>
					</span>
					<div id="curve_chart" style="width: 85%; height: 340px"></div>
					<br><br><br>
					</div>
					
					<div>
					<h4><strong>코스닥 지수</strong></h4>
					<span> <strong style="size: 20px;">
										${kospi[0].open}</strong> <fmt:formatNumber
										value="${kospi[0].open - kospi[1].open}" pattern="0.00"></fmt:formatNumber>
									<fmt:formatNumber value="${kospi[0].change}" pattern="0.00%"></fmt:formatNumber>
								</span>
					<div id="curve_chart2" style="width: 85%; height: 340px"></div>
					<br><br><br>
					</div>
					
					<div>
					<h4><strong>코스피200 지수</strong></h4>
					<span> <strong>${kospi200[0].open}</strong> <fmt:formatNumber
										value="${kospi200[0].open - kospi200[1].open}" pattern="0.00"></fmt:formatNumber>
									<fmt:formatNumber value="${kospi200[0].change}" pattern="0.00%"></fmt:formatNumber>
								</span>
					<div id="curve_chart3" style="width: 85%; height: 340px"></div>
					</div>
					
					
					
					<%-- <div class="col">
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
								<span> <strong style="size: 20px;">
										${kospi[0].open}</strong> <fmt:formatNumber
										value="${kospi[0].open - kospi[1].open}" pattern="0.00"></fmt:formatNumber>
									<fmt:formatNumber value="${kospi[0].change}" pattern="0.00%"></fmt:formatNumber>
								</span>

							</div>
							<div class="tab-pane fade" id="asd">
								<span> <strong>${kosdaq[0].open}</strong> <fmt:formatNumber
										value="${kosdaq[0].open - kosdaq[1].open}" pattern="0.00"></fmt:formatNumber>
									<fmt:formatNumber value="${kosdaq[0].change}" pattern="0.00%"></fmt:formatNumber>
								</span>

							</div>
							<div class="tab-pane fade" id="zxc">
								<span> <strong>${kospi200[0].open}</strong> <fmt:formatNumber
										value="${kospi200[0].open - kospi200[1].open}" pattern="0.00"></fmt:formatNumber>
									<fmt:formatNumber value="${kospi200[0].change}" pattern="0.00%"></fmt:formatNumber>
								</span>


							</div>
						</div>
					</div> --%>
				</div>
			</article>
			<!--사이드바 -------------------------------->
			<nav>
				<!-- 환율 -->
				<div class="exchange" style="border: medium; border-color: blue;">
				<br><br>
					<h4><strong>환율</strong></h4>
					<div class="exchange_contents" style="size: 10px;">
						미국 ${usdkrw[0].close} usd/krw<br>
					
						<i id="upordown"></i><fmt:formatNumber value="${usdkrw[0].close - usdkrw[1].close}"
							pattern="+0.00;-0.00"></fmt:formatNumber>
						<fmt:formatNumber value="${usdkrw[0].change}"
							pattern="+0.00%;-0.00%"></fmt:formatNumber>
					<br>
						중국  ${cnykrw[0].close} cnykrw<br> <i id="upordown"></i>
					<fmt:formatNumber value="${cnykrw[0].close - cnykrw[1].close}"
						pattern="+0.00;-0.00"></fmt:formatNumber>
					<fmt:formatNumber value="${cnykrw[0].change}"
						pattern="+0.00%;-0.00%"></fmt:formatNumber>
						
		
					<br>
					일본 ${jpykrw[0].close} jpykrw <br><i id="upordown"></i>
						<fmt:formatNumber value="${jpykrw[0].close - jpykrw[1].close}"
							pattern="+0.00;-0.00"></fmt:formatNumber>
						<fmt:formatNumber value="${jpykrw[0].change}"
							pattern="+0.00%;-0.00%"></fmt:formatNumber>

					</div>
				</div>



				<!-- 조회수높은뉴스 -->
				<div class="hitNews">
				<br><br>
					<h4><strong>많이본 뉴스</strong></h4>
					<div class="hitNews_contents">
						<c:forEach items="${mostViewed }" var="mostViewed">
							<!-- 글자수 길이 자르기 -->
							<c:choose>
							<c:when test="${fn:length(mostViewed.title)>23}">
								<div class="mostViewedTitles">
								<a href="view.do?nno=${mostViewed.nno}&cnt=1">
									<c:out value="${fn:substring(mostViewed.title,0,23)}"/>...
								</a>
								</div>
							</c:when>
							<c:otherwise>
								<div class="mostViewedTitles">
								<a href="view.do?nno=${mostViewed.nno}&cnt=1">
										${mostViewed.title}</a>
								</div>
							</c:otherwise>
							</c:choose>
						</c:forEach>
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
		//json데이터 가져오기
		function readTextFile(file, callback) {
    var rawFile = new XMLHttpRequest();
    rawFile.overrideMimeType("application/json");
    rawFile.open("GET", file, true);
    rawFile.onreadystatechange = function() {
        if (rawFile.readyState === 4 && rawFile.status == "200") {
            callback(rawFile.responseText);
        }
    }
    rawFile.send(null);
}
		var jsonDataKospi;
		var jsonDataKosdaq;
		var jsonDataKospi200;
	    readTextFile("/upload/crawlingtest/kospi.json", function(text){
	        jsonDataKospi = JSON.parse(text).data;
 	   })
	    readTextFile("/upload/crawlingtest/kosdaq.json", function(text){
	        jsonDataKosdaq = JSON.parse(text).data;
 	   })
	    readTextFile("/upload/crawlingtest/kospi200.json", function(text){
	        jsonDataKospi200 = JSON.parse(text).data;
 	   })

 
       	function drawKospiChart() {
          var data = new google.visualization.DataTable;
          data.addColumn("string", "date");
          data.addColumn("number", "close");
          for(i = jsonDataKospi.length-51; i < jsonDataKospi.length; i++ ){
				data.addRow([jsonDataKospi[i].Date, jsonDataKospi[i].Close]);
		    }
        var options = {
          legend: { position: 'none' },
        };
        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
        chart.draw(data, options);
      };


       	function drawKosdaqChart() {
       		var data = new google.visualization.DataTable;
            data.addColumn("string", "date1");
            data.addColumn("number", "close");
            for(i = jsonDataKosdaq.length-51; i < jsonDataKosdaq.length; i++ ){
  				data.addRow([jsonDataKosdaq[i].Date, jsonDataKosdaq[i].Close]);
  		    }
        var options = {
          legend: { position: 'none' },
        };
        var chart = new google.visualization.LineChart(document.getElementById('curve_chart2'));
        chart.draw(data, options);
      };

      
       	function drawKospi200Chart() {
          var data = new google.visualization.arrayToDataTable([
          	['year', 'kospi200'],
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
  		//google chart============================
		google.charts.load('current', {'packages':['corechart']});
	    google.charts.setOnLoadCallback(drawKospiChart);
	    google.charts.setOnLoadCallback(drawKosdaqChart);
	    google.charts.setOnLoadCallback(drawKospi200Chart);
      </script>


</body>
</html>