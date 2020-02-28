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

	//overriding : 상속받은 메소드 내용 재정의
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		
		res.setContentType("text/html; charset=utf-8");//text를 html로 내보내겠다.
		PrintWriter out = res.getWriter(); //응답하기 위해 out객체 생성
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd H:mm:ss EEEE");
	
		//응답
		out.println("<html>");
		out.println("<body bgcolor = \'yellow\'>");
		out.println("<font color='blue' size='5'>");
		
		out.println("<center><br><br><br>");
		out.println("<img src=\'imgs/song.jpg\'>");
		out.println("<marquee>");//자막처럼 지나가는 글씨
		out.println("<h3>오늘은 즐거운 금요일 입니다.<h3>");
		out.println("</marquee>");
		
		out.println("<br><br><hr size=10 color =red><br>");
		out.println("<br>");
		out.println(sdf.format(date));
		
		
		out.println("</font>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
		//저장=컴파일 web.xml에 등록
		
	}//doGet end
}//class ends
