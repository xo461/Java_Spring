<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 축하</title>

 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>


</head>

<body>
<div class="container">

    <div class="panel panel-info">
      <div class="panel-heading">회원가입 축하 페이지</div>
		


<h1>회원가입을 축하드립니다.</h1>
<P>
${param.id }님은 성공적으로 회원가입되셨습니다.<br/>
앞으로 좋은 시간이 되시기 바랍니다.
</P>
<button>메인으로</button>
<button onclick="location'/notice/list.jsp'=">공지사항</button>


      <div class="panel-body">
      
      
      </div>
    </div>
    



</body>
</html>