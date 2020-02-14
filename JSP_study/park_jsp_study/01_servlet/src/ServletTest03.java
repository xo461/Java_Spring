

import java.io.*;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletTest03") //이게 web.xml에서 만든 서블릿 등록해주는 것과 동일한 효과
public class ServletTest03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();//응답하기 위해 out객체 생성
		
		//클라이언트가 보내준 자료 받기
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		
		//서버에서 처리하여 클라이언트로 응답
		out.println("<html><body bgcolor = yellow>");
		out.println("당신의 이름은 "+ name + "<br>");
		out.println("당신의 이메일은" + email + "<br>");
		out.println("글내용" + content+"<br>");
		out.println("</body></html>");
		out.close();
		//저장=컴파일...html 실행
	}//doget end

}//class end
