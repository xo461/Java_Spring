<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>실시간시세</title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR|Sawarabi+Gothic&display=swap"
	rel="stylesheet">
<style type="text/css">
body {
	font-size: large;
	font-family: 'Sawarabi Gothic', 'Noto Sans KR', sans-serif;
}

.title-div {
	margin: auto;
}

.stock-name {
	font-size: xx-large;
	color: #333333;
}

.table-name {
	font-size: x-large;
}

table, th {
	text-align: center;
	margin: auto;
}

img {
	margin: auto;
}

.info-title {
	font-size: x-large;
}

ul {
	list-style: none;
}

.up {
	color: #eb8787;
}

.down {
	color: #687de3;
}

.now-price {
	font-size: xx-large;
}

.small-text {
	font-size: medium;
}

.topSell {
	background-color: #abe4fb;
}

.topBuy {
	background-color: #f4b1a9;
}

.sell {
	background-color: #87ceeb;
}

.buy {
	background-color: #eb8787;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="title-div">
			<span class="stock-code">A${krxData['code'] }</span> <span
				class="stock-name">${krxData['stockInfoData'][0] }</span>
			<p></p>
			<span>실시간 시세 현황</span>
			<p />
			<span>${krxData['getTime'] }</span>기준 <span class="small-text">(${krxData['janggubun'] })</span>
		</div>
		<div class="col-sm-9">
			<div class="row">
				<div>
					<div class="now-price">
						<span>현재가 <br>${krxData['stockInfoData'][1] }</span> <span
							class="now-price-arrow small-text"></span> <span
							class="small-text">${krxData['stockInfoData'][3] }
							${krxData['DungRakrate_str'] }</span>
					</div>
					<div id="stock_line_chart">
						<!-- <img src="/upload/image/stock/kakao3months.png" class="img-responsive" width="90%"> -->
					</div>
					<div id="stock_bar_chart">
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="body-div">
				<ul>
					<li class="info-title">주가 정보
						<p />
					</li>
					<li>시가 ${krxData['stockInfoData'][7] }</li>
					<li>고가 ${krxData['stockInfoData'][8] }</li>
					<li>거래량 ${krxData['stockInfoData'][5] }</li>
					<li>거래대금 ${krxData['stockInfoData'][6] }</li>
				</ul>
			</div>
			<div class="invest-info-div">
				<hr width="70%" />
				<div>
					<ul>
						<li class="info-title">투자 정보
							<p />
						</li>
						<li>상한가 ${krxData['stockInfoData'][12] }</li>
						<li>하한가 ${krxData['stockInfoData'][13] }</li>
						<li>52주 최고 ${krxData['stockInfoData'][10] }</li>
						<li>52주 최저 ${krxData['stockInfoData'][11] }</li>
						<li>액면가 ${krxData['stockInfoData'][16] }</li>
						<li>PER ${krxData['stockInfoData'][14] }</li>
						<li>상장주식수 ${krxData['stockInfoData'][15] }</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<p class="table-name">거래원 현황</p>
				<table class="table" style="width: 90%;">
					<colgroup>
						<col class="topSell" />
						<col class="topSell" />
						<col class="topBuy" />
						<col class="topBuy" />
					</colgroup>
					<tr style="background-color: white;">
						<th colspan="2">매도상위</th>
						<th colspan="2">매수상위</th>
					</tr>
					<tr>
						<th>증권사</th>
						<th>거래량</th>
						<th>증권사</th>
						<th>거래량</th>
					</tr>
					<c:if test="${krxData['askPrice_length'] > 0}">
						<c:forEach var="askPrice" items="${krxData['askPrice'] }">
							<tr>
								<td>${askPrice[0] }</td>
								<td>${askPrice[1] }</td>
								<td>${askPrice[2] }</td>
								<td>${askPrice[3] }</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
			</div>
			<div class="col-md-6">
				<p class="table-name">호가</p>
				<table class="table" style="width: 90%;">
					<colgroup>
						<col class="topSell" />
						<col />
						<col class="topBuy" />
					</colgroup>
					<tr style="background-color: white;">
						<th>매도잔량</th>
						<th>호가</th>
						<th>매수잔량</th>
					</tr>
					<c:if
						test="${krxData['hoga'][0] != '' || !krxData['hoga'][0].equals('')}">
						<tr>
							<td>${krxData['hoga'][0]}</td>
							<td class="sell">${krxData['hoga'][1]}</td>
							<td></td>
						</tr>
						<tr>
							<td>${krxData['hoga'][2]}</td>
							<td class="sell">${krxData['hoga'][3]}</td>
							<td></td>
						</tr>
						<tr>
							<td>${krxData['hoga'][4]}</td>
							<td class="sell">${krxData['hoga'][5]}</td>
							<td></td>
						</tr>
						<tr>
							<td>${krxData['hoga'][6]}</td>
							<td class="sell">${krxData['hoga'][7]}</td>
							<td></td>
						</tr>
						<tr>
							<td>${krxData['hoga'][8]}</td>
							<td class="sell">${krxData['hoga'][9]}</td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td class="buy">${krxData['hoga'][10]}</td>
							<td>${krxData['hoga'][11]}</td>
						</tr>
						<tr>
							<td></td>
							<td class="buy">${krxData['hoga'][12]}</td>
							<td>${krxData['hoga'][13]}</td>
						</tr>
						<tr>
							<td></td>
							<td class="buy">${krxData['hoga'][14]}</td>
							<td>${krxData['hoga'][15]}</td>
						</tr>
						<tr>
							<td></td>
							<td class="buy">${krxData['hoga'][16]}</td>
							<td>${krxData['hoga'][17]}</td>
						</tr>
						<tr>
							<td></td>
							<td class="buy">${krxData['hoga'][18]}</td>
							<td>${krxData['hoga'][19]}</td>
						</tr>
						<tr style="background-color: white;">
							<td class="down">${krxData['hoga'][20]}</td>
							<td>잔량합계</td>
							<td style="color: #eb8787;">${krxData['hoga'][21]}</td>
						</tr>
					</c:if>
				</table>
			</div>
		</div>
		<div class="row">
			<p class="table-name">시간대별 체결가</p>
			<table class="table">
				<tr>
					<th>시간</th>
					<th>체결가</th>
					<th>전일대비</th>
					<th>매도호가</th>
					<th>매수호가</th>
					<th>매수잔량</th>
				</tr>
				<c:if test="${krxData['timeConclude_length'] > 0}">
					<c:forEach var="timeConclude" items="${krxData['timeConclude'] }">
						<tr>
							<td>${timeConclude[0] }</td>
							<td>${timeConclude[1] }</td>
							<td>${timeConclude[2] }<input type="hidden" name="lastDay"
								value="${timeConclude[6] }" />
							</td>
							<td>${timeConclude[3] }</td>
							<td>${timeConclude[4] }</td>
							<td>${timeConclude[5] }</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
		<div class="row">
			<p class="table-name">일자별 체결가</p>
			<table class="table">
				<tr>
					<th>일자</th>
					<th>종가</th>
					<th>전일대비</th>
					<th>시가</th>
					<th>고가</th>
					<th>저가</th>
					<th>거래량</th>
					<th>거래대금</th>
				</tr>
				<c:if test="${krxData['dailyStock_length'] > 0}">
					<c:forEach var="dailyStock" items="${krxData['dailyStock'] }">
						<tr>
							<td class="daily_stock_date">${dailyStock[0] }</td>
							<td class="daily_stock_closing_price">${dailyStock[1] }</td>
							<td>${dailyStock[2] }<input type="hidden"
								name="lastDayDaily" value="${dailyStock[8] }" />
							</td>
							<td>${dailyStock[3] }</td>
							<td>${dailyStock[4] }</td>
							<td>${dailyStock[5] }</td>
							<td class="daily_stock_volume">${dailyStock[6] }</td>
							<td>${dailyStock[7] }</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
	</div>
	<script type="text/javascript"	src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript">
		String.prototype.replaceAll = function(org, dest) {
			return this.split(org).join(dest);
		}
		const now_price = document.querySelector(".now-price");
		const now_price_arrow = document.querySelector(".now-price-arrow");

		document.addEventListener("DOMContentLoaded", function() {
			var last = document.getElementsByName('lastDay');
			var lastDaily = document.getElementsByName('lastDayDaily');

			if ("${krxData['stockInfoData'][2]}" === '1'
					|| "${krxData['stockInfoData'][2]}" === '2') {
				now_price.classList.remove("down");
				now_price.classList.add("up");
				now_price_arrow.innerText = "▲";
			} else if ("${krxData['stockInfoData'][2]}" === '3') {
				now_price_arrow.innerText = "-";
			} else if ("${krxData['stockInfoData'][2]}" === '4'
					|| "${krxData['stockInfoData'][2]}" === '5') {
				now_price_arrow.innerText = "▼";
				now_price.classList.remove("up");
				now_price.classList.add("down");
			}

			for (i = 0; i < last.length; i++) {
				if (last[i].value === '1' || last[i].value === '2') {
					last[i].parentNode.classList.add("up");
				} else if (last[i].value === '4' || last[i].value === '5') {
					last[i].parentNode.classList.add("down");
				}
			}
			for (i = 0; i < lastDaily.length; i++) {
				if (lastDaily[i].value === '1' || lastDaily[i].value === '2') {
					lastDaily[i].parentNode.classList.add("up");
				} else if (lastDaily[i].value === '4'
						|| lastDaily[i].value === '5') {
					lastDaily[i].parentNode.classList.add("down");
				}
			}
			// chart draw
			var daily_stock_date = document.getElementsByClassName('daily_stock_date');
			var daily_stock_volume = document.getElementsByClassName('daily_stock_volume');
			var daily_stock_closing_price = document.getElementsByClassName('daily_stock_closing_price');

			google.charts.load('current', {'packages' : ['corechart']});
			google.charts.setOnLoadCallback(drawLineChart);
			google.charts.setOnLoadCallback(drawBarChart);

			function drawBarChart() {
				var data = new google.visualization.DataTable();
				data.addColumn('string', '일자')		
				data.addColumn('number', '거래량')
				console.log(daily_stock_date.length);		
				for (i = daily_stock_date.length - 1; i >= 0; i--) {
					data.addRow([daily_stock_date[i].innerText, daily_stock_volume[i].innerText.replaceAll(",", "") * 1])
				}
				var options = {
					title : '일자별 거래량 그래프',
					legend : {
						position : 'bottom'
					},
						textStyle : {
						fontName : 'Noto Sans KR'
					},
			        width : '100%',
				    height : 200,
				    colors : ['#9d8c7c'],
				};
				var chart = new google.visualization.ColumnChart(document.getElementById('stock_bar_chart'));
				chart.draw(data, options);
				window.addEventListener('resize', function() { chart.draw(data, options); }, false);
			};
			
			function drawLineChart() {
				var data = new google.visualization.DataTable();
				data.addColumn('string', '일자');
				data.addColumn('number', '종가');
				for (i = daily_stock_date.length - 1; i >= 0; i--) {
					data.addRow([ daily_stock_date[i].innerText, daily_stock_closing_price[i].innerText.replaceAll(",", "") * 1])
				}
				
				var options = {
					title : '일자별 종가 그래프',
					legend : {
						position : 'bottom'
					},
					textStyle : {
						fontName : 'Noto Sans KR'
					},
				    colors : ['#9d8c7c'],
			        width : '100%',
				    height : 350
				};

				var chart = new google.visualization.LineChart(document	.getElementById('stock_line_chart'));
				chart.draw(data, options);
				window.addEventListener('resize', function() { chart.draw(data, options); }, false);
			}
		});
	</script>
</body>
</html>