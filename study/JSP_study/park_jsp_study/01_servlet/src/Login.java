

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
	//��������
	private static final String DRIVER ="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/mydb";  //db�� �ִ� �ּ�. ����Ŭ�� 1521, mysql�� 3306	
	private static final String USER="root";
	private static final String PWD="12345";
	
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();//�����ϱ� ���� out��ü ����
		
		//Ŭ���̾�Ʈ���� ������ �ڷ� �ޱ�
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String db_pwd = "";
		try{
			Class.forName(DRIVER);
			System.out.println("����̹� �ε� ����");
		}catch(ClassNotFoundException cnf){
			System.out.println("����̹� �ε� ����:"+cnf);
		}//catch end
		
		try{
			con=DriverManager.getConnection(URL, USER, PWD);
			System.out.println("DB���� ����");
			stmt = con.createStatement();//statement����
			rs=stmt.executeQuery("select pwd from member1 where id='"+id+"'");

			if(rs.next()){
				db_pwd=rs.getString("pwd");
			}//if
			
			//db_pwd�� �Է��� pwd ��
			if(db_pwd.equals(pwd)){
				//��ġ�ϸ� �α��� ����
				out.println("<html><body>");
				out.println("<Meta http-equiv=refresh content=\'2;url=/01_servlet/html1/home.jsp\'");
				out.println("<font color = blue size = 5>");
				out.println(id+"�� ���� ����Ʈ�� �湮�� �ּż� �����մϴ�.");
				out.println("</font>");
				out.println("</body></html>");
				
				out.close();
				rs.close();
				stmt.close();
				con.close();
				
			}else{
				//id, pwd�� Ʋ��
				out.println("<html><body>");
				out.println("<Meta http-equiv=refresh content=\'2;url=/01_servlet/html1/login.html\'");
				out.println("<font color = red size = 5>");
				out.println("id �Ǵ� pwd�� Ʋ���ϴ�.");
				out.println("</font>");
				out.println("</body></html>");
				
				out.close();
				rs.close();
				stmt.close();
				con.close();

				
			}//else
		}catch(SQLException se){
			System.out.println("DB���� ����"+se);
		}//catch end
		
	}//doPost() end
}//class end