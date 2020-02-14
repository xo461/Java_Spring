<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>존재하지 않는 URL</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
#logoDiv{
	font-size: 50px;
/* 	padding: 50px; */
	text-align: center;
/* 	background: black; */
	color: white;
	margin: 0px;
}

.panel-heading{
text-align: center;
font-size:30px;
font-weight: bolder;
}
</style>

</head>
<body>
<div class="container">
<!-- 	<h2>오류 페이지 입니다.</h2> -->
	<div class="panel panel-danger">
      <div class="panel-heading">Requested URL does not exist.</div>
      <div class="panel-body">
      	<div id="logoDiv">
<!--       	<span class="glyphicon glyphicon-remove"></span> -->
      	<img src="../img/에러.jpeg">
      	</div>
      </div>
      <div class="panel-footer">
      	<a href="/board/list.do"><button>Go back to Board List</button></a>
      </div>
    </div>
	
</div>
</body>
</html>