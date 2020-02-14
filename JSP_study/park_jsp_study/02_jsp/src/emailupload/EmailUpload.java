package emailupload;

import java.io.PrintStream;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MailMessage;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class EmailUpload {

	public String upload(HttpServletRequest request){
		String reply="";//����
		
		try {
			//���Ͼ��ε�
			MultipartRequest mrequest = new MultipartRequest(request, "c:\\_jsp\\upload\\",1024*1024*5, "utf-8", new DefaultFileRenamePolicy());
		
			//���� �ڷ� �ޱ�
			String from = mrequest.getParameter("from");
			String to = mrequest.getParameter("to");
			String subject = mrequest.getParameter("subject");
			String content = mrequest.getParameter("content");
		
			subject=new String(subject.getBytes("utf-8"),"8859_1");
			content=new String(content.getBytes("utf-8"),"8859_1");
			
			//host=smpt.nate.com
			MailMessage msg = new MailMessage("smtp.nate.com");
			msg.from(from);
			msg.to(to);
			msg.setSubject(subject);
			
			//MailMessage���� ��¿� ��Ʈ�� ����
			PrintStream out = msg.getPrintStream();
			out.println(content);
		
			msg.sendAndClose(); //��¿� ��Ʈ���� ������ ������ ����
			reply="���Ϻ�����, ���Ͼ��ε� ����";
			
			
		} catch (Exception ex) {
			reply="���Ϻ�����, ���Ͼ��ε� ����"+ex;
		}//catch end
		
		return reply;
		
	}
}//class end

