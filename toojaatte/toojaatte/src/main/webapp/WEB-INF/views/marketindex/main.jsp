<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>toojaatte:: market index</title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR|Sawarabi+Gothic&display=swap"
	rel="stylesheet">
<!-- google chart -->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

</head>
<body>
	<div class="container-fluid">


		<div class="topBox" id="boxDashboard">
			<ul class="tab box_tabs">
				<li class="up2">
				<a href="javascript:void(0)" class="on ">
						<h4></h4> 
					<span> 
						<strong>usdkrw ${usdkrw[0].close}</strong>
							<p><i id="upordown"></i>
								<fmt:formatNumber value="${usdkrw[0].close - usdkrw[1].close}"
									pattern="+0.00;-0.00"></fmt:formatNumber>
							</p>
							<p>
								<fmt:formatNumber value="${usdkrw[0].change}" pattern="+0.00%;-0.00%"></fmt:formatNumber>
							</p>
					</span>
							<div id="curve_chart" style="width: 300px; height: 170px"></div>
					
				</a>
				</li>
				<li class="up2">
				<a href="javascript:void(0)" class="on ">
						<h4></h4> 
					<span> 
						<strong>cnykrw ${cnykrw[0].close}</strong>
							<p><i id="upordown"></i>
								<fmt:formatNumber value="${cnykrw[0].close - cnykrw[1].close}"
									pattern="+0.00;-0.00"></fmt:formatNumber>
							</p>
							<p>
								<fmt:formatNumber value="${cnykrw[0].change}" pattern="+0.00%;-0.00%"></fmt:formatNumber>
							</p>
					</span>
				</a>
				</li>
				<li class="up2">
				<a href="javascript:void(0)" class="on ">
						<h4></h4> 
					<span> 
						<strong>jpykrw ${jpykrw[0].close}</strong>
							<p><i id="upordown"></i>
								<fmt:formatNumber value="${jpykrw[0].close - jpykrw[1].close}"
									pattern="+0.00;-0.00"></fmt:formatNumber>
							</p>
							<p>
								<fmt:formatNumber value="${jpykrw[0].change}" pattern="+0.00%;-0.00%"></fmt:formatNumber>
							</p>
					</span>
				</a>
				</li>

			</ul>
		<script>
			/*마이너스이면 화살표 아래방향으로 바꾼다.*/
			window.onload = function(){
			var close = ${usdkrw[0].close - usdkrw[1].close};
			var ifminus = close.toString().substring(0, 1);
			if (ifminus == '-') {
				document.getElementById('upordown').innerText = '▼';
			} else {
				document.getElementById('upordown').innerHTML = '▲';
			}
			}


			//google chart============================
		window.onload = function(){
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
          var data = google.visualization.arrayToDataTable([
          	['year', 'usd/krw'],

	          	//데이터 과거순이기때문에 역순으로 정렬. foreach에 step=-1없다.
	          	<c:forEach var="i" begin="0" end="51" step="1">
	          		<c:set var="date" value="${usdkrw[51-i].stringDate}"/>
	          		<c:set var="close" value="${usdkrw[51-i].close}"/>
	          	     ['${date}', ${close}], //쉼표 안쓰면 오류난다.
	          	</c:forEach> 
            ]);
          	
     
      
        var options = {
          //title: 'Company Performance',
          //legend: { position: 'bottom' },
          legend: { position: 'none' },
          //curveType: 'function'
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
      }
		}
    </script>
		
		</div>
	</div>
</body>
</html>