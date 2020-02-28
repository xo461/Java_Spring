<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");//post요청 한글처리
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="menu.jsp" %>
<%
String item=request.getParameter("item");//menu.jsp,remove.jsp
String step=request.getParameter("step");//menu.jsp,remove.jsp
Vector vec=null;//변수 장바구니
%>

<%
if(item != null){//선택한 item이 있으면 
	
	//장바구니 내용을 가져온다
		vec=(Vector)session.getAttribute("cart");
		if(vec==null){//장바구니에 아무것도 없으면, 처음 물건을 선택했을때
			vec=new Vector();//객체생성(장바구니 생성)
			vec.add(item);//장바구니에 item 넣기 
			session.setAttribute("cart", vec);//session에 설정 
			
		}else{ //장바구니에 물건이 들어있을 때
			//이미 선택된 CD가 있을때
			if(step.equals("add")){ 
				//장바구니에 넣는다.
				vec.add(item);//장바구니에 추가( 넣기 )
			}else{
				//장바구니에서 제거한다.
				vec.remove(item);//장바구니에서 item을 제거
			}
		}//else end
		
		out.println("쇼핑 cart에 담긴 cd<br>");

		for(int i=0; i<vec.size(); i++){//장바구니 내용을 뿌려준다
			out.println((i+1)+":"+(vec.get(i).toString())+"<br>");
		}//for
		%>
		현재 cart에 모두 <%=vec.size() %>개 담겨 있습니다<br>
		<%
		
		if(vec.size()>0){//장바구니에 물건이 있을때 
		%>
		<jsp:include page="remove.jsp" flush="true"/>
		<%	
			
		}//if end
}//if end
%>



</body>
</html>