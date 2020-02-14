<%@page import="com.webjjang.main.Execute"%>
<%@page import="com.webjjang.bean.Beans"%>
<%@page import="com.webjjang.main.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
    
<% 
	Service service = Beans.getService("qnaViewService");
	
int no = Integer.parseInt(request.getParameter("no"));

request.setAttribute("dto", Execute.service(service, no, 0));
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문답변 수정 폼</title>
</head>
<body>
<div class="container">
		<h1>질문하기</h1>
		
		<!-- 많은 데이터를 넘길 때 : form --post방식...-->
		<form action="update.jsp" method="post">
			<!-- input, select, textarea: 입력항목만들기: 생략 -->

<!-- 	no 입력 - 수정불가  -->
    	<div class="form-group">
      		<label for="no">번 호:</label>
<!--       		id:한개 태그 - 화면단 컨트롤 하기 위해서 붙인다. / name:넘어가는 데이터기에 해당된다. -->
      		<input class="form-control" id="no" name ="no" 
      			 value="${dto.no }" readonly="readonly">
    	</div>


<!-- 	제목 입력 - 한줄 - 키보드입력  -->
    	<div class="form-group">
      		<label for="title">제 목:</label>
<!--       		id:한개 태그 - 화면단 컨트롤 하기 위해서 붙인다. / name:넘어가는 데이터기에 해당된다. -->
      		<input type="text" class="form-control" id="title" name ="title" 
				placeholder="제목을 쓰세요."
      			 value="${dto.title }">
    	</div>


    	
<!--     	내용입력: 여러줄 - 키보드로 입력 -->
    	<div class="form-group">
  			<label for="content">내 용:</label>
  			<textarea class="form-control" rows="5" 
  					  id="content" name="content">${dto.content }</textarea>
		</div>
    	
    	
<!--     	button type : submit - submit()호출 데이터를 넘겨 준다.  -->
<!--     				  reset - value속성이 없으면 비워진 상태, value속성이 있으면 value의  -->
<!--     				  			값으로 셋팅. -->
<!--    				  	  button -  형태만 버튼이고 아무런 동작을 하지 않는다. 동작은 따로 정의 한다.  -->
    	
    	<button type="submit" class="btn btn-default">등록하기</button>
    	<button type="reset" class="btn btn-default">다시입력</button>
    	<button type="button" class="btn btn-default">취소</button>
    	
  </form>
</div>
</body>
</html>