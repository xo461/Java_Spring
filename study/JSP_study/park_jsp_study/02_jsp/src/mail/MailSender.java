package mail;

import java.io.PrintStream;
import com.oreilly.servlet.MailMessage;

public class MailSender {

	private String from;
	private String to;
	private String subject;
	private String content;
	
	//생성자 - 클래스와 이름 같음. 객체 초기화 목적. 객체 생성시 호출
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
	
	//기타 메소드
	public String send(){
		String reply="";//변수	
		try{
			MailMessage msg = new MailMessage("smtp.nate.com");
			msg.from(from);
			msg.to(to);
			msg.setSubject(subject);
			
			//MailMessage 에서 출력용 스트림 생성
	        PrintStream out=msg.getPrintStream(); 
	        out.println(content);
	        
	      //출력용 스트림의 내용을 보내고 종료
	        msg.sendAndClose();
	        reply="메일 전송 성공";
	        
		}catch(Exception ex){
			reply="메일 전송 실패"+ex;
		}
		
		return reply;
	}//send() end
}//class end
