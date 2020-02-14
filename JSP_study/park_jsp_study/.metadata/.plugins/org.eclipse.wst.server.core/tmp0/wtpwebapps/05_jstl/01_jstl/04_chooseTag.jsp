<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--04_chooseTag.jsp--%>
<%--
choose 태스는 : java의 switch~case문과 유사하다

choose 태그 형식 

<c:choose>
  <c:when test="${조건1}">
         처리내용
  </c:when>
  
  <c:when test="${조건2}">
         처리내용
  </c:when>

  <c:when test="${조건3}">
         처리내용
  </c:when>
   .
   .
  <c:otherwise>
    위의 조건에 해당 사항이 없ㅂ을때 처리 
  </c:otherwise>
</c:choose>

설명: 조건이 true이면 when 태그 바디 부분을 처리한다
모든 조건이 false이면 <c:otherwise> 태그에서 실행한다 
 --%>

 <h2>choose 태그 실습 </h2>
 <ul>
  <c:choose>
    <c:when test="${param.name=='park'}">
      <li>당신의 이름은 ${param.name}입니다
    </c:when>
  
    <c:when test="${param.age>18}">
      <li>당신의 나이는 ${param.age}살이며 성인 입니다
    </c:when>

    <c:when test="${param.age<=18}">
      <li>당신의 나이는 ${param.age}살이며 미성년자 입니다
    </c:when>
    
    <c:otherwise>
      <li>당신의 이름은 ${param.name }아닙니다</li>
    </c:otherwise>
   
  </c:choose>
 
 </ul>
 
 
 <%--
 http://localhost:9000/05_JSTL/01_jstl/04_chooseTag.jsp?name=park
 http://localhost:9000/05_JSTL/01_jstl/04_chooseTag.jsp?name=jung&age=15
  --%>
 
 
 