package org.zerock.util.fileutils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/image")
public class ImageUploadController {

	// ckeditor에서 이미지 업로드할때  

	@RequestMapping(value = "/imageupload.do") // 이미지를 저장하고, 불러오고, 업로드하기위해 매개변수를
	public void imageUpload(HttpServletRequest request, HttpServletResponse response,
			@RequestParam MultipartFile upload) throws Exception {
		// MultipartFile 타입은 ckedit에서 upload란 이름으로 저장하므로 upload로 사용해야 맵핑된다.

		// 응답: 파일업로드여부, filename, 업로드된url 응답은 json형식으로 나간다.
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json"); 

		// 업로드한 파일 이름
		String fileName = upload.getOriginalFilename();
		System.out.println("original fileName: " + fileName);
		
		// 파일일명 바이트 배열로 변환
		byte[] bytes = upload.getBytes();
		System.out.println("변환된 이름: " + bytes);
		
		HttpSession session = request.getSession();
		String rootPath = session.getServletContext().getRealPath("/");
		
		// 이미지 저장된 경로★ 
		// D:\Workspace\spring\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\minnieNail\ upload\
		String uploadPath = rootPath + "upload\\board\\";
		System.out.println("uploadpath: "+ uploadPath);
		
		// '서버로 전송' 버튼을 누르면 폴더에 저장
		OutputStream out = new FileOutputStream(new File(uploadPath + fileName));

		// 서버로 업로드. 지정된 바이트를 출력 스트립에 쓴다
		out.write(bytes);

		// 서버=>클라이언트로 텍스트 전송(자바스크립트 실행)
		PrintWriter printWriter = response.getWriter();
		
		// 서버에 올라간 경로★. 주소창에 앞에 localhost붙이면 이미지 볼 수있다.
		// http://localhost/   +   upload/board/hunchbrown.png
		String fileUrl = "/upload/board/" + fileName;
		System.out.println("fileUrl: "+fileUrl);

		//json으로 응답
		JsonObject json = new JsonObject();
		json.addProperty("uploaded", 1); //업로드시 1 안되면 0
		json.addProperty("fileName", fileName);
		json.addProperty("url", fileUrl);

		printWriter.println(json);
		printWriter.flush();
		out.close();
	}
}