package emailupload;

import java.io.PrintStream;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MailMessage;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class EmailUpload {

	public String upload(HttpServletRequest request){
		String reply="";//변수
		
		try {
			//파일업로드
			MultipartRequest mrequest = new MultipartRequest(request, "c:\\_jsp\\upload\\",1024*1024*5, "utf-8", new DefaultFileRenamePolicy());
		
			//메일 자료 받기
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
			
			//MailMessage에서 출력용 스트림 생성
			PrintStream out = msg.getPrintStream();
			out.println(content);
		
			msg.sendAndClose(); //출력용 스트림의 내용을 보내고 종료
			reply="메일보내기, 파일업로드 성공";
			
			
		} catch (Exception ex) {
			reply="메일보내기, 파일업로드 실패"+ex;
		}//catch end
		
		return reply;
		
	}
}//class end

