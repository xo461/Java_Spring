

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	//전역변수
	private static final String DRIVER ="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/mydb";  //db가 있는 주소. 오라클은 1521, mysql은 3306	
	private static final String USER="root";
	private static final String PWD="12345";
	
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();//응답하기 위해 out객체 생성
		
		//클라이언트에서 보내준 자료 받기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String db_pwd = "";
		try{
			Class.forName(DRIVER);
			System.out.println("드라이버 로딩 성공");
		}catch(ClassNotFoundException cnf){
			System.out.println("드라이버 로딩 실패:"+cnf);
		}//catch end
		
		try{
			con=DriverManager.getConnection(URL, USER, PWD);
			System.out.println("DB연결 성공");
			stmt = con.createStatement();//statement생성
			rs=stmt.executeQuery("select pwd from member1 where id='"+id+"'");

			if(rs.next()){
				db_pwd=rs.getString("pwd");
			}//if
			
			//db_pwd와 입력한 pwd 비교
			if(db_pwd.equals(pwd)){
				//일치하면 로그인 성공
				out.println("<html><body>");
				out.println("<Meta http-equiv=refresh content=\'2;url=/01_servlet/html1/home.jsp\'");
				out.println("<font color = blue size = 5>");
				out.println(id+"님 저희 사이트를 방문해 주셔서 감사합니다.");
				out.println("</font>");
				out.println("</body></html>");
				
				out.close();
				rs.close();
				stmt.close();
				con.close();
				
			}else{
				//id, pwd가 틀림
				out.println("<html><body>");
				out.println("<Meta http-equiv=refresh content=\'2;url=/01_servlet/html1/login.html\'");
				out.println("<font color = red size = 5>");
				out.println("id 또는 pwd가 틀립니다.");
				out.println("</font>");
				out.println("</body></html>");
				
				out.close();
				rs.close();
				stmt.close();
				con.close();

				
			}//else
		}catch(SQLException se){
			System.out.println("DB연결 실패"+se);
		}//catch end
		
	}//doPost() end
}//class end