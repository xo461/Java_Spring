<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/util.js">


</script>

</head>
<body>
<div>screen.width / screen.height</div>
<div id = "screenwh"></div>
<div>screen.availWidth / screen.availHeight</div>
<div id = "screenawh"></div>
<div>window.innerWidth / screen.availHeight</div>
<div id = "screenawh"></div>
<div>window.outerWidth / screen.availHeight</div>
<div id = "screenawh"></div>

<script type="text/javascript">
get("#screenwh").innerHTML = screen.width + "/" + screen.height
get("#screenawh").innerHTML = screen.availWidth + "/" + screen.availHeight
get("#windowwh").innerHTML = window.innerWidth + "/" + screen.
// get("#screenawh").innerHTML = screen.availWidth + "/" + screen.availHeight

</script>
</body>
</html>