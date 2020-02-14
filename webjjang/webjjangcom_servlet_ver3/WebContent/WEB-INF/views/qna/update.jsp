<%@page import="com.webjjang.main.Execute"%>
<%@page import="com.webjjang.qna.dto.QnaDTO"%>
<%@page import="com.webjjang.bean.Beans"%>
<%@page import="com.webjjang.main.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

      <%
      //실행할 서비스를 받아온다.
      Service service = Beans.getService("qnaUpdateService");
      
    //이곳을 실행했다는 처리내용 출력
    System.out.println("글수정 처리 ---");
    
    //한글 처리
    request.setCharacterEncoding("utf-8");
    //데이터를 받는다.
    int no = Integer.parseInt(request.getParameter("no"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");
    //dto객체를 만든다.
	QnaDTO dto = new QnaDTO();
    dto.setNo(no);
    dto.setTitle(title);
    dto.setContent(content);
    //service객체를 호출해서 db에 데이터를 넣는다.
   Execute.service(service, dto);
    //글쓰기가 끝나면 자동으로 view로 이동한다.
    
   // get방식: ("url?키=값 & 키=값) 보내줌...
response.sendRedirect("view.jsp ? no = "+dto.getNo()+" & cnt = 0");
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>