<%@page import="com.webjjang.main.Execute"%>
<%@page import="com.webjjang.bean.Beans"%>
<%@page import="com.webjjang.main.Service"%>
<%@page import="com.webjjang.member.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    // JoinService 생성된 객체를 저장하는 변수
    System.out.println(request.getServletPath());
    Service service = Beans.getService("memberJoinService");
     
    //한글처리
    request.setCharacterEncoding("utf-8");
    
   //넘어오는데이터를 받는다.
   String id = request.getParameter("id");
   String pw = request.getParameter("pw");
   String name = request.getParameter("name");
   String gender = request.getParameter("gender");
   String birth = request.getParameter("birth");
   String[] tels = request.getParameterValues("tel");
String tel = String.join("-", tels);
   String email = request.getParameter("email");
    //memberdto객체를 생성 - 자료저장
    MemberDTO dto = new MemberDTO();
    dto.setId(id);
    dto.setPw(pw);
    dto.setName(name);
    dto.setGender(gender);
    dto.setBirth(birth);
    dto.setTel(tel);
    dto.setEmail(email);
    dto.setId(id);
    
    //MemberJoinService 
    
  	//실행방법 execute(service)
  	Execute.service(service, dto);
    
    //회원가입이 되면 자동으로 환영 메시지 페이지 이동
    response.sendRedirect("/member/welcome.jsp?id="+id);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(function(){
	//이벤트 처리 - 아이디 입력란에 한글자가 입력이 된다면 (keyup) 서버에 아이디가 중복이 되는지 체크해서 결과를 돌려받아서 표시한다.
	$("#id").keyup(function(){
		//앞 뒤에 있는 공백문자를 제거한다. 
		var id = $("#id").val().trim();
		$("#id").val(id); //값가져오기,
		//아이디가 비어있는 경우
		if(id.length == 0)
			$("#idCheck").html("아이디를 입력하세요.");
		//4글자 미만, 20글자 초과인 경우 경고
		else if(id.length < 4 || id.length > 20)
			$("#idCheck").html("아이디는 4자 이상 20자 이내로 입력하세요.");
		//적당한 아이디를 입력한 경우 ajax를 이용해서 서버에 아이디 확인
		else
			$("#idCheck").load("idCheck.do?id="+id);
		
	
	});
});
</script>
</head>
<body>
<h2>서버의 아이디 체크</h2>
<input id="id" name="id"/><br/>
<div id="idCheck">아이디를 입력하세요.</div>

</head>
<body>

</body>
</html>