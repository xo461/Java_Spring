

import java.io.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletLifeCycle")
public class ServletLifeCycle extends HttpServlet {
	//전역변수
	public int count=0;
	
	//init() - 한번만 호출됨
	public void init(ServletConfig conf) throws ServletException{
		System.out.println("init() method called.....");
	}//init() end
	
	//service() : 클라이언트가 요청할 때마다 호출된다. 스레드 기능이 있다.
	public void service(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		System.out.println("service() method called...");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();//응답하기 위해 out객체 생성
		
		out.println("<html><body>");
		count++;//방문회수 count
		
		out.println("<h2>service() method called : "+count+"</h2>");
		out.println("</body></html>");

	}//service() end

	//destroy() - 한번만 호출됨
	public void destroy(){
		System.out.println("destroy() method called...!!!!");
	}
}//class end
