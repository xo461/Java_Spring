package org.zerock.board.controller;

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
public class ImageUpload {

	// 이미지 업로드 // product_edit페이지에서 맵핑되는 메소드

	@RequestMapping(value = "/imageupload.do") // 이미지를 저장하고, 불러오고, 업로드하기위해 매개변수를
	public void imageUpload(HttpServletRequest request, HttpServletResponse response,
			@RequestParam MultipartFile upload) throws Exception {
		// MultipartFile 타입은 ckedit에서 upload란 이름으로 저장하게 된다

		// 한글깨짐을 방지하기위해 문자셋 설정
		response.setCharacterEncoding("utf-8");

		// 마찬가지로 파라미터로 전달되는 response 객체의 한글 설정
		response.setContentType("application/json");

		// 업로드한 파일 이름
		String fileName = upload.getOriginalFilename();
		System.out.println(fileName);
		// 파일을 바이트 배열로 변환
		byte[] bytes = upload.getBytes();
		System.out.println("==========================================");
		System.out.println(bytes);
		System.out.println("==========================================");
		
		HttpSession session = request.getSession();
		String rootPath = session.getServletContext().getRealPath("/");
		System.out.println(rootPath);
		
		// 이미지를 업로드할 디렉토리(배포 디렉토리로 설정)
		//요기가 실제 서버가 돌아가는 곳. 이미지업로드하면 요기에 업로드된다. 
		String uploadPath = rootPath + "upload\\board\\";
		// '서버로 전송' 버튼을 누르면 폴더에 저장
		OutputStream out = new FileOutputStream(new File(uploadPath + fileName));

		// 서버로 업로드 // write메소드의 매개값으로 파일의 총 바이트를 매개값으로 준다. // 지정된 바이트를 출력 스트립에 쓴다
		// (출력하기 위해서)
		out.write(bytes);

		// 클라이언트에 결과 표시
		String callback = request.getParameter("CKEditorFuncNum");
		System.out.println("callback:" + callback);

		// 서버=>클라이언트로 텍스트 전송(자바스크립트 실행)
		PrintWriter printWriter = response.getWriter();
		System.out.println("==========================================");
		System.out.println(request.getContextPath());
		System.out.println("==========================================");
//		String fileUrl = request.getContextPath() + "/images/" + fileName;
		String fileUrl = "/upload/board/" + fileName;
		// printWriter.println("<script>window.parent.CKEDITOR.tools.callFunction("
		// +callback + ",'" + fileUrl // + "','이미지가 업로드되었습니다.')" + "</script>");
//	  printWriter.println("{\"filename\" : \"" +fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");

		JsonObject json = new JsonObject();
		json.addProperty("uploaded", 1);
		json.addProperty("fileName", fileName);
		json.addProperty("url", fileUrl);
		printWriter.println(json);

		printWriter.flush();
		out.close();
	}
}
