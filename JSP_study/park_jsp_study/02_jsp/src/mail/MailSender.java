package mail;

import java.io.PrintStream;
import com.oreilly.servlet.MailMessage;

public class MailSender {

	private String from;
	private String to;
	private String subject;
	private String content;
	
	//������ - Ŭ������ �̸� ����. ��ü �ʱ�ȭ ����. ��ü ������ ȣ��
	public MailSender(){
		from="";
		to="";
		subject="";
		content="";
	}//cons end

	public void setFrom(String from) {
		this.from = from;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	//��Ÿ �޼ҵ�
	public String send(){
		String reply="";//����	
		try{
			MailMessage msg = new MailMessage("smtp.nate.com");
			msg.from(from);
			msg.to(to);
			msg.setSubject(subject);
			
			//MailMessage ���� ��¿� ��Ʈ�� ����
	        PrintStream out=msg.getPrintStream(); 
	        out.println(content);
	        
	      //��¿� ��Ʈ���� ������ ������ ����
	        msg.sendAndClose();
	        reply="���� ���� ����";
	        
		}catch(Exception ex){
			reply="���� ���� ����"+ex;
		}
		
		return reply;
	}//send() end
}//class end
