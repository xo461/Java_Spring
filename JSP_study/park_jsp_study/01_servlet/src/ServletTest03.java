

import java.io.*;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletTest03") //�̰� web.xml���� ���� ���� ������ִ� �Ͱ� ������ ȿ��
public class ServletTest03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();//�����ϱ� ���� out��ü ����
		
		//Ŭ���̾�Ʈ�� ������ �ڷ� �ޱ�
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		
		//�������� ó���Ͽ� Ŭ���̾�Ʈ�� ����
		out.println("<html><body bgcolor = yellow>");
		out.println("����� �̸��� "+ name + "<br>");
		out.println("����� �̸�����" + email + "<br>");
		out.println("�۳���" + content+"<br>");
		out.println("</body></html>");
		out.close();
		//����=������...html ����
	}//doget end

}//class end
