<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="panel panel-info">
		<div class="panel-heading">sign-in</div>
		<div class="panel-body">
			<form action="login.do" method="post">
				<div class="form-group">
					<label for="id">id:</label> <input type="text" class="form-control"
						id="id" name="id">
				</div>
				<div class="form-group">
					<label for="pw">Password:</label> <input type="password"
						class="form-control" id="pw" name="pw">
				</div>
				<button type="submit" class="btn btn-default">Login</button>
			</form>
		</div>
	</div>
</body>
</html>