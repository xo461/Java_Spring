<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
//장바구니 내용을 vec에 할당
Vector vec=(Vector)session.getAttribute("cart");
%>

<h2>삭제할 cd를 고르세요.</h2>
<form method="post" action="cart.jsp">
	<select name="item">
		<%
		for(int i=0; i<vec.size();i++){
			%>
				<option value="<%=vec.get(i).toString()%>">
				<%=vec.get(i).toString()%>
				</option>
			<%
		}//for end
		
		%>
	</select>
	
	<input type="hidden" name="step" value="remove">
	<input type="submit" value="삭제">
</form>
</body>
</html>