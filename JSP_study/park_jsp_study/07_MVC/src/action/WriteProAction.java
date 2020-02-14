package action;
import javax.servlet.*;
import javax.servlet.http.*;
import boardmysql.*;

public class WriteProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		 
		 request.setCharacterEncoding("utf-8");
		 BoardDTO dto=new BoardDTO();
		 
		 dto.setNum(Integer.parseInt(request.getParameter("num")));
		 dto.setWriter(request.getParameter("writer"));
		 dto.setEmail(request.getParameter("email"));
		 dto.setSubject(request.getParameter("subject"));
		 dto.setPasswd(request.getParameter("passwd"));
		    
		 dto.setRef(Integer.parseInt(request.getParameter("ref")));
		 dto.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		 dto.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		 dto.setContent(request.getParameter("content"));
		 dto.setIp(request.getRemoteAddr());//ip   
		 
		 BoardDAO dao=BoardDAO.getDao();//dao��ü��� 
		 dao.insertArticle(dto);//dao �޼��� ȣ��
		 return "/ch19/writePro.jsp";//�丮��
	}//requestPro()

}//class
