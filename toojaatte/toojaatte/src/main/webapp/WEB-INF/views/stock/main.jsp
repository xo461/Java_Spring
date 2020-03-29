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
.up2{
	float: left;
	
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

#boxDashboard.topBox {
	color: #333333;
	letter-spacing: -0.05em;
	margin: 0;
	padding: 0;
	font-size: 100%;
	font: inherit;
	float: left;
	width: 100%;
	margin-bottom: 38px;
	border: 1px solid #424242;
	box-sizing: border-box;
}
ul.tab.box_tabs{
color: #333333;
letter-spacing: -0.05em;
margin: 0;
padding: 0;
border: 0;
font-size: 100%;
font: inherit;
list-style: none;
width: 100%;
overflow: hidden;
}

</style>
</head>
<body>
	<div class="container-fluid">



		<div class="topBox" id="boxDashboard">
			<ul class="tab box_tabs">
				<li class="up2"><a href="javascript:void(0)" class="on ">
						<h4>코스피 지수</h4> <span> <strong>${kospi[0].open}</strong>
							<p>
								<i>▲</i>
								<fmt:formatNumber value="${kospi[0].open - kospi[1].open}"
									pattern="0.00"></fmt:formatNumber>
							</p>
							<p>
								<fmt:formatNumber value="${kospi[0].change}" pattern="0.00%"></fmt:formatNumber>
							</p>
					</span>
				</a></li>

				<li class="up2"><a href="javascript:void(0)" class=" off">
						<h4>코스닥 지수</h4> <span> <strong>${kosdaq[0].open}</strong>
							<p>
								<i>▲</i>
								<fmt:formatNumber value="${kosdaq[0].open - kosdaq[1].open}"
									pattern="0.00"></fmt:formatNumber>
							</p>
							<p>
								<fmt:formatNumber value="${kosdaq[0].change}" pattern="0.00%"></fmt:formatNumber>
							</p>


					</span>
				</a></li>
				<li class="up2"><a href="javascript:void(0)" class=" ">
						<h4>코스피200 지수</h4> <span> <strong>${kospi200[0].open}</strong>
							<p>
								<i>▲</i>
							<fmt:formatNumber value="${kospi200[0].open - kospi200[1].open}"
									pattern="0.00"></fmt:formatNumber>
							</p>
							<p>
								<fmt:formatNumber value="${kospi200[0].change}" pattern="0.00%"></fmt:formatNumber>
							</p>
					</span>
				</a></li>
			</ul>
			<div class="box box_contents">
				<div style="display: block;">
					<div class="box">
						<div class="graphB">
							<div class="f_clear">
								<dl>
									<dt>연초</dt>
									<dd>${kospi[365].open}</dd>
									<dt>지난주</dt>
									<dd>${kospi[7].open}</dd>
								</dl>
								<p class="time"></p>
							</div>
							<div class="graph">
								<a href="/domestic/kospi"><img
									src="https://t1.daumcdn.net/finance/chart/kr/daumcomplexindex/d/D0011001.png?t=202003281141"
									alt="530x160"></a>
							</div>
						</div>
						<div class="txtB">
							<dl>
								<dt>등락종목</dt>
								<dd class="ty01 mr">
									<a
										href="/domestic/rise_stocks?market=KOSPI&amp;change=UPPER_LIMIT">상한가
										<p class="up">
											<i>↑</i>3
										</p>
									</a>
								</dd>
								<dd class="ty01">
									<a
										href="/domestic/fall_stocks?market=KOSPI&amp;change=LOWER_LIMIT">하한가
										<p class="down">
											<i>↓</i>0
										</p>
									</a>
								</dd>
								<dd class="ty02 mr">
									<a href="/domestic/rise_stocks?market=KOSPI">상승
										<p class="up">
											<i>▲</i>661
										</p>
									</a>
								</dd>
								<dd class="ty02">
									<a href="/domestic/fall_stocks?market=KOSPI">하락
										<p class="down">
											<i>▼</i>194
										</p>
									</a>
								</dd>
							</dl>
							<dl>
								<dt>투자자별 매매동향</dt>
								<dd class="mr">
									<a href="/domestic/investors/KOSPI">외국인
										<p class="down">
											-3,751<em>억</em>
										</p>
									</a>
								</dd>
								<dd>
									<a href="/domestic/investors/KOSPI">개인
										<p class="up">
											+1,731<em>억</em>
										</p>
									</a>
								</dd>
								<dd class="mr">
									<a href="/domestic/investors/KOSPI">기관
										<p class="up">
											+1,300<em>억</em>
										</p>
									</a>
								</dd>
								<dd>
									<a href="javascript:void(0)" class="nolink">프로그램
										<p class="down">
											-4,049<em>억</em>
										</p>
									</a>
								</dd>
							</dl>
						</div>
					</div>
				</div>
		
						</div>
					</div>
				</div>
</body>
</html>