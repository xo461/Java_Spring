package action;
import javax.servlet.*;
import javax.servlet.http.*;

import boardmysql.*;

public class DeleteProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		 
		request.setCharacterEncoding("utf-8");
		
		int num=Integer.parseInt(request.getParameter("num"));
		String pageNum=request.getParameter("pageNum");
		String passwd=request.getParameter("passwd");
		
		BoardDAO dao=BoardDAO.getDao();//dao��ü ��� 
		int check=dao.deleteArticle(num, passwd);//dao�޼��� ȣ��
		
		//�ش� �信�� ����� �Ӽ�
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("check", check);
		
		return "/ch19/deletePro.jsp";//�� ����
	}

}//class---
