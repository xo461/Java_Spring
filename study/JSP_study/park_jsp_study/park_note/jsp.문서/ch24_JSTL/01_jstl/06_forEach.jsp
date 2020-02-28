<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--06_forEach.jsp--%>

<%--
items 속성과 함께  begin,end속성을 사용하면 참조할 변수 갯수를 제한할 수 있따

정수배열에서 인덱스2부터 인텍스4까지 참고하고 싶다면 begin="2", end="4" 이헐게 지정하면 된다

인덱스는 0부터 처리 된다 
--%>

<c:set var="intArr" value="new int[]{1,2,3,4,5,6,7,8,9}"/>

<c:forEach var="i" items="${intArr}" begin="2" end="4">
  ${i}&nbsp;
</c:forEach>