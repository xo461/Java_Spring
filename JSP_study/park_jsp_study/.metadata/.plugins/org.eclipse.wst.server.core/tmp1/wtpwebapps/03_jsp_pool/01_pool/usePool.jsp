<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>커넥션 풀 사용</h2>
	<table border="1" width="70%">
		<tr>
			<th width="100">글쓴이</th>
			<th width="150">이메일</th>
			<th width="200">주소</th>
		</tr>
		
		<%
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Context ct = new InitialContext();
		//Context ct2= (Context)ct.lookup("java:comp/env");
		DataSource ds= (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		
		con=ds.getConnection();
		
		String sql = "select * from test";
		stmt = con.createStatement();
		rs=stmt.executeQuery(sql);
		
		while(rs.next()){
			String name=rs.getString("name");
			String email=rs.getString("email");
			String addr=rs.getString("addr");
			%>
			<tr>
				<td><%=name %></td>
				<td><%=email %></td>
				<td><%=addr %></td>
			</tr>
			<%
		}//while end
		rs.close();
		stmt.close();
		con.close();
		%>
	
	</table>
</body>
</html>

<%-- 

   // 현재 환경의 naming Context 획득하기
   // InitialContext()는 웹 어플리케이션이 처음으로 배치될때 설정되고
   // 모든 설정된 엔트리와 자원은 JNDI(Java Naming Directory) namespace의 
   // "java:comp/env" 부분에 놓이게 됩니다.
   // 그래서 자원 접근을 아래와 같이 한다.
   Context ct = new InitialContext();
   
   //JNDI에 등록된 생성할 자원 이름 (즉. 컨텍스트에 대한 상대적인 이름): java:comp/env (자동생성)
    Context ct2 = (Context)ct.lookup("java:comp/env");

   //server.xml 또는 context.xml,web.xml에서 설정해놓은 이름 : jdbc/mysql
    DataSource ds = (DataSource)ct2.lookup("jdbc/mysql");
   
  --%>