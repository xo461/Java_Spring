<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String [] movies = {"겨울왕국2", "블랙머니", "신의 한 수"};
String movieHTML = "";
movieHTML += "<select id = 'movie'>";
// 옵션 하나씩 보여줌
for(String m : movies){
	movieHTML += "<option>" + m + "</option>";
	
}
movieHTML += "</select>";
out.print(movieHTML);

%>