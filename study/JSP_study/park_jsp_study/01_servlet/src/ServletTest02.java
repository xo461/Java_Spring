import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import javax.servlet.*;
//import javax.servlet.http.*;

public class ServletTest02 extends HttpServlet{

	//overriding : ��ӹ��� �޼ҵ� ���� ������
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		
		res.setContentType("text/html; charset=utf-8");//text�� html�� �������ڴ�.
		PrintWriter out = res.getWriter(); //�����ϱ� ���� out��ü ����
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd H:mm:ss EEEE");
	
		//����
		out.println("<html>");
		out.println("<body bgcolor = \'yellow\'>");
		out.println("<font color='blue' size='5'>");
		
		out.println("<center><br><br><br>");
		out.println("<img src=\'imgs/song.jpg\'>");
		out.println("<marquee>");//�ڸ�ó�� �������� �۾�
		out.println("<h3>������ ��ſ� �ݿ��� �Դϴ�.<h3>");
		out.println("</marquee>");
		
		out.println("<br><br><hr size=10 color =red><br>");
		out.println("<br>");
		out.println(sdf.format(date));
		
		
		out.println("</font>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
		//����=������ web.xml�� ���
		
	}//doGet end
}//class ends
