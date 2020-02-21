package action;

import javax.servlet.http.*;
import java.util.*;
import boardmysql.*;//DAO,DTO

//�׼��� jspó�� ������  �׼Ϳ��� �Ѵ� 
//�׼� dao�޼��� ȣ�� , ����� request.setAttribute("Ű","��");

public class ListAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		 
		//ó��
		String pageNum=request.getParameter("pageNum");
		if(pageNum==null){
			pageNum="1";
		}
		int pageSize=10;//�� �������� �� ����
		int currentPage=Integer.parseInt(pageNum);//���� ������ 
		
		int startRow=(currentPage-1)*pageSize+1;//�� �������� ���� �۹�ȣ
		int endRow=currentPage*pageSize;//���������� ������ �۹�ȣ

		int count=0;//�� �۰��� ���� ����
		int number=0;//�۹�ȣ ó�� �Ϸ��� 
		int pageBlock=10;
	
		List articleList=null;
		BoardDAO dao=BoardDAO.getDao();//dao��ü��� 
		count=dao.getArticleCount();//dao�޼��� ȣ��,�� �۰������
		
		if(count>0){//���� �����ϸ�
			articleList=dao.getList(startRow, pageSize);
		}else{//���� ������
			articleList=Collections.EMPTY_LIST;
		}//else
		
		number=count-(currentPage-1)*pageSize;//�۸�Ͽ� ǥ���� �۹�ȣ
		int pageCount=count/pageSize+(count%pageSize==0?0:1);
	
		//list.jsp���� ${currentPage}
		request.setAttribute("currentPage", new Integer(currentPage));
	    request.setAttribute("startRow", new Integer(startRow));
	    request.setAttribute("endRow", new Integer(endRow));
	    request.setAttribute("pageBlock", new Integer(pageBlock));
	    request.setAttribute("pageCount", new Integer(pageCount));

	    request.setAttribute("count", new Integer(count));
	    request.setAttribute("pageSize", new Integer(pageSize));
	    request.setAttribute("number", new Integer(number));
	    request.setAttribute("articleList", articleList);
	    
	    return "/ch19/list.jsp";//�ش� �並 ����
     
	}//requestPro() end
}//class