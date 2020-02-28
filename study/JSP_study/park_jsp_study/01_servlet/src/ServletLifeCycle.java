

import java.io.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletLifeCycle")
public class ServletLifeCycle extends HttpServlet {
	//��������
	public int count=0;
	
	//init() - �ѹ��� ȣ���
	public void init(ServletConfig conf) throws ServletException{
		System.out.println("init() method called.....");
	}//init() end
	
	//service() : Ŭ���̾�Ʈ�� ��û�� ������ ȣ��ȴ�. ������ ����� �ִ�.
	public void service(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		System.out.println("service() method called...");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();//�����ϱ� ���� out��ü ����
		
		out.println("<html><body>");
		count++;//�湮ȸ�� count
		
		out.println("<h2>service() method called : "+count+"</h2>");
		out.println("</body></html>");

	}//service() end

	//destroy() - �ѹ��� ȣ���
	public void destroy(){
		System.out.println("destroy() method called...!!!!");
	}
}//class end
