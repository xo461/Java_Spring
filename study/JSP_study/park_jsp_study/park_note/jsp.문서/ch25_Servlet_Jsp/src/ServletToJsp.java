import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

//Servlet���� JSP�� ������ �ϱ� 
public class ServletToJsp extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	  throws ServletException,IOException{
		
		//Ŭ���̾�Ʈ�� �����ϱ� ���� �ѱ� ó��
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();//out��ü ����
		
		//Vector
		String user="������";
		Vector vec=new Vector();
		vec.add("���� ��Ų");
		vec.add("û���� NO.3049");
		vec.add("��ħ�޻� 1.51");
		
		req.setAttribute("user",user);
		req.setAttribute("vec", vec);
		
		//Map, HashMap
		String user2="������";
		HashMap map=new HashMap();
		map.put("pum1", "���� ��Ų");
		map.put("pum2", "û���� NO.3049");
		map.put("pum3", "��ħ�޻�");
		
		req.setAttribute("user2", user2);
		req.setAttribute("map", map);
		
		//Servlet���� JSP�� ������ 
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/jsp/target.jsp");
		rd.forward(req, res);//jsp ������
	}//doGet() end
}//class end
