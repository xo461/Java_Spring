package action;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteFormAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		 
		int num=Integer.parseInt(request.getParameter("num"));
		String pageNum=request.getParameter("pageNum");
		
		//�ش�信�� ����� �Ӽ�
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", pageNum);
		
		return "/ch19/deleteForm.jsp";//�丮��
	}//requestPro() end

}//classs ---
