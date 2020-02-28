import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ServletTest01 extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		
		//클라이언트로 응답
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>helloWorld</h2>");
		out.println("<h2>안녕하세요</h2>");
		out.println("<body>");
		out.println("</html>");
		out.close();
	}//doGet end
}