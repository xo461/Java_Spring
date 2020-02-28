<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--target.jsp--%>

<h2>Vector사용</h2>
<h3>
<%= (String)request.getAttribute("user")%>님의 쇼핑 키트에 담긴 물건은 : 
</h3>

<h3>${user}님의 쇼핑 카트에 담긴 물건은 :</h3>

<ol>
 <%
 //이전 방식
  Vector vec=(Vector)request.getAttribute("vec");
  for(int i=0;i<vec.size(); i++){
	  %>
	  <li><%=vec.get(i) %>
	  <%
  }//for 
 %>
</ol>
<%--EL사용 --%>
<%--HashMap --%>
<h3>${user2 }님 쇼핑커트에 담긴 물건:</h3>
pum1:${map.pum1}<br>
pum2:${map.pum2 }<br>
pum3:${map.pum3 }<br>

<br>
<%--forEach 태그 --%>
<c:forEach var="m" items="${map}">
  ${m.key } ==>${m.value }<br>
</c:forEach>


