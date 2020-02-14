package ch19.controller;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;//HashMap
import ch19.action.CommandAction;

//��Ʈ�ѷ�=�����̴� 
public class ControllerAction extends HttpServlet{
	
	private Map map=new HashMap();//����
	
	//init() : �ʱ�ȭ �۾�
	public void init(ServletConfig config) throws ServletException{
		String path=config.getServletContext().getRealPath("/");
		System.out.println("realpath:"+path);
		
		String pros=path+config.getInitParameter("proFile");
		Properties pr=new Properties();//��ü����
		
		FileInputStream f=null;
		try{
			f=new FileInputStream(pros);//CommancPro.properties �б�
			pr.load(f);
		}catch(Exception ex){
			System.out.println("���� �б� ���� :"+ex);
		}finally{
			try{
				if(f!=null){f.close();}
			}catch(Exception ex2){}
		}//finally---
		
		Iterator keyItor=pr.keySet().iterator();
		
		while(keyItor.hasNext()){//�ڷᰡ �ִ� ���� �ݺ�
 			
			String key=(String)keyItor.next();// /ch19/list.do
 			String className=pr.getProperty(key);// ch19.action.ListAction
			
 			try{
				Class commandClass=Class.forName(className);//�ش繮�ڿ��� Ŭ������ �����
				Object commandObject=commandClass.newInstance();//Ŭ������ ��ü����
				map.put(key, commandObject);///
				
			}catch(Exception ex3){
				System.out.println("proeprty ���ϳ����� Ŭ���� ��ü�� ����� �� ���� �߻� "+ex3);
			}//catch
			
		}//while end---
	}//init() end----------
		
	public void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws IOException,ServletException{
		 
		reqPro(request,response);//�޼��� ȣ��
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) 
			throws IOException,ServletException{
		 
		reqPro(request,response);//�޼��� ȣ��
		
	}
	
	//����� ���� �޼���
	private void reqPro(HttpServletRequest request,HttpServletResponse response) 
			throws IOException,ServletException{
		
		String view="";//jsp���� ���� 
		CommandAction commandAction=null;//ActionŬ���� ���� ����
		
		try{
			String uri=request.getRequestURI();//  /������Ʈ��/ch19/list.do
		 	
			if(uri.indexOf(request.getContextPath())==0){
				uri=uri.substring(request.getContextPath().length());
				//   /ch19.list.do
			}//if
			
			commandAction=(CommandAction)map.get(uri);//  /ch19/list.do
			view=commandAction.requestPro(request, response);//�޼��� ȣ�� ,view ��´�
			             //��ü.�޼���()
		}catch(Throwable ex){
			throw new ServletException(ex);
		}//catch
		
		RequestDispatcher rd=request.getRequestDispatcher(view);
		rd.forward(request, response);//jsp�� ������
	}//reqPro() end
}//class end---
