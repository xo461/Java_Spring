import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

//Servlet에서 JSP로 포워딩 하기 
public class ServletToJsp extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	  throws ServletException,IOException{
		
		//클라이언트에 응답하기 위한 한글 처리
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();//out객체 생성
		
		//Vector
		String user="송혜교";
		Vector vec=new Vector();
		vec.add("이윰 스킨");
		vec.add("청바지 NO.3049");
		vec.add("아침햇살 1.51");
		
		req.setAttribute("user",user);
		req.setAttribute("vec", vec);
		
		//Map, HashMap
		String user2="아이유";
		HashMap map=new HashMap();
		map.put("pum1", "이윰 스킨");
		map.put("pum2", "청바지 NO.3049");
		map.put("pum3", "아침햇살");
		
		req.setAttribute("user2", user2);
		req.setAttribute("map", map);
		
		//Servlet에서 JSP로 포워딩 
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/jsp/target.jsp");
		rd.forward(req, res);//jsp 포워딩
	}//doGet() end
}//class end
