import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletToJsp2 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		
		String user="����";
		Vector vec = new Vector;
		vec.add("14k ���� ���Ͱ��� ����������");
		vec.add("14k ���̺� ��ӱͰ���");
		vec.add("14k ���� �Ͱ��� 8mm");
		
		req.setAttribute("user", user);
		req.setAttribute("vec", vec);
		
		//servlet���� jsp�� ������
		RequestDispatcher rd=getser
	}
}