<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      var coinDatas = {};

      <c:forEach items="${keylist }" var="key">
      	coinDatas.${key } = ${jsMap.get(key) };
      </c:forEach>

	    

	function getData(key){
// 		alert(coinDatas.BTC);
	      <c:forEach items="${keylist }" var="key">
	      	if ("${key}"==key)
		      	return coinDatas.${key};
		  </c:forEach>
			return false;
		  
	}
    
      function drawChart(key) {
//         alert(key);
        if(!key) key ="BTC";
        var data = google.visualization.arrayToDataTable(getData(key));

        var options = {
          title: 'Virtual Money :' + key,
          curveType: 'function',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
      }

      $(function(){
			$(".coinBtn").click(function(){
				var key = $(this).text();
				drawChart(key);
				});

          })
          
          
      </script>
      

<style type="text/css">
.left-box{
float:left;
width:50%;
font-size:25px;
}
.right-box{
float:right;
width:50%;
font-size:25px;

}
.container{
 padding :50px;
}
</style>


</head>

<body>


<div class="container" >
	<h2 align="center">가 상 화 폐 시  세</h2>
	 
	<div id="myCarousel" class="carousel" data-ride="carousel" data-interval="false">
	
	  <!-- Wrapper for slides -->
	  <div class="carousel-inner">
	
		<c:forEach items="${cm}" var="c" varStatus="vs">
		<div class ="item ${vs.index ==0?"active":"" }">
	      <div style= "width:60%; margin: auto;">
	        <div align="center"><h2> 코  인  명: ${c}</h2></div> <br/>
			<div class='left-box' align="center">
			시  가 : ${vmdata.get(c).opening_p} <br/>
			종   가 : ${vmdata.get(c).closing_p} <br/>
			</div>
			<div class='right-box' align="center">
			최고가 : ${vmdata.get(c).max_p} <br/>
			최저가 : ${vmdata.get(c).min_p} <br/>
			</div>
		  </div>
		  </div>
		</c:forEach>
		
		  <!-- Left and right controls -->
		  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
		      <span class="glyphicon glyphicon-chevron-left"></span>
		      <span class="sr-only">Previous</span>
		  </a>
		    <a class="right carousel-control" href="#myCarousel" data-slide="next">
		      <span class="glyphicon glyphicon-chevron-right"></span>
		      <span class="sr-only">Next</span>
		    </a>
		</div>
	
	
	
	</div>
</div>

<div align="center"><h2>일별 시세 변동 그래프</h2></div>

<div align="center">
<c:forEach items="${keylist }" var="key" >
		<button class="coinBtn">${key }</button>
	</c:forEach>
</div>
<div align="center">
<div id="curve_chart" style="width: 900px; height: 500px;" ></div>
</div>	
	
    
</body>
</html>