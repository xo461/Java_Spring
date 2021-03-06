<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<h1>EL객체</h1>	

메서드방식
표현식 <%=request.getMethod() %>
표현언어 ${pageContext.request.method }
<br>
 요청시 헤더부분의 정보 알아보기 <p>
  표현식<%=request.getHeader("host")%><p>
  표현언어 ${header.host}<p>
  표현언어 ${header["host"]}<p>
  표현언어 ${headerValues}<p>

<h1>EL객체 - session</h1>	
  
  <%
  session.setAttribute("id", "minnie");
  session.setAttribute("pw", 1111);
  
  %>
  표현식 <%=session.getAttribute("id")%>님 환영 합니다<br>

표현언어 ${sessionScope.id}님 환영 합니다<p>


<form action="test03.jsp" method="post" >

	<table>
      <tr>
        <td>이름</td>
        <td><input type="text" name="name" id="name" size="20" value="미니"></td>
      </tr>
      
            <tr>
        <td>취미</td>
        <td><input type="checkbox" name="hobby" value="영화">영화
        <input type="checkbox" name="hobby" value="네일아트">네일아트
        <input type="checkbox" name="hobby" value="쇼핑">쇼핑
        <input type="checkbox" name="hobby" value="등산">등산
        <input type="checkbox" name="hobby" value="맛집탐방">맛집탐방
        
        </td>
      </tr>
      <tr>
      <td>
      <input type="submit" value="전송">
      <input type="reset" value="취소">
      </td>
      </tr>
	</table>
	
<h1>EL객체 연산자</h1>	
	
<h5>\${7+5}=${7+5}</h5>
<h5>\${7-5}=${7-5}</h5>
<h5>\${7*5}=${7*5}</h5>
<h5>\${7/5}=${7/5}</h5>
<h5>\${7%5}=${7%5}</h5>

<h5>\${7==5}=${7==5}</h5>
<h5>\${7!=5}=${7!=5}</h5>
<h5>\${7<5}=${7<5}</h5>
<h5>\${7>5}=${7>5}</h5>
<h5>\${7>=5}=${7>=5}</h5>

<h5>\${(5+3==8)?8:10 }=${(5+3==8)?8:10 }</h5>
<h5>${7==5 && 8==8}</h5>
<h5>${7==5 and 8==8}</h5>
<h5>${7==5 || 8==8}</h5>


<h1>EL객체 - pagecontext</h1>
<!-- - pageContext 객체는 현재 JSP 페이지의 컨텍스트(Context)를 나타내며, 주로 다른 내장 객체를 구하거나 페이지의 흐름 제어 그리고 에러 데이터를 얻어낼 때 사용된다. -->
<!-- - pageContext 내장 객체는 javax.servlet.jsp.PageContext 객체 타입으로 ,JSP에서는 pageContext 객체로 사용된다. -->

${param.id }<br>
${param.pwd }<br>
요청 URI:${pageContext.request.requestURI }<br>
요청 URL:${pageContext.request.requestURL }<br>

</form>


<h1>EL객체 - request</h1>	
<%
request.setAttribute("nickname", "귀요미");
%>
request의 nickname속성값 : ${requestScope.nickname }

<!-- session. : 서버에 들어와서 활동했을때 -->
<!-- request.: 클라이언트의 요청이 있었을때 -->
