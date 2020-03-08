package org.zerock.board.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.zerock.util.fileutils.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
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

		// 이미지를 업로드할 디렉토리(배포 디렉토리로 설정)
		String uploadPath = "C:\\Users\\Admin\\Documents\\GitHub\\Java_Spring\\spring\\minnieNail\\src\\main\\webapp\\upload\\board\\";
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
		String fileUrl = "http://localhost/images/" + fileName;
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

//	@RequestMapping(value = "/imageupload.do", method = RequestMethod.POST)
//	@ResponseBody
//	public String fileUpload(HttpServletRequest req, HttpServletResponse resp, MultipartHttpServletRequest multiFile)
//			throws Exception {
//		System.out.println("되나?");
//		JsonObject json = new JsonObject();
//		PrintWriter printWriter = null;
//		OutputStream out = null;
//		MultipartFile file = multiFile.getFile("upload");
//		System.out.println("file: "+file.getName());
//		if (file != null) {
//			if (file.getSize() > 0 && !StringUtils.isEmpty(file.getName())) {
//				if (file.getContentType().toLowerCase().startsWith("image/")) {
//					try {
//						String fileName = file.getName();
//						System.out.println("fileName: "+fileName);
//						byte[] bytes = file.getBytes();
//						//String uploadPath = req.getServletContext().getRealPath("/img");
//						 String uploadPath = "C:\\Users\\Admin\\Documents\\GitHub\\Java_Spring\\spring\\minnieNail\\src\\main\\webapp\\upload\\board\\";
//
//						File uploadFile = new File(uploadPath);
//						if (!uploadFile.exists()) {
//							uploadFile.mkdirs();
//						}
//						fileName = UUID.randomUUID().toString();
//						
////						uploadPath = uploadPath + "/" + fileName;
//						uploadPath = uploadPath + fileName;
//						System.out.println("uploadPath"+uploadPath);
//						out = new FileOutputStream(new File(uploadPath));
//						System.out.println("out: "+out);
//						out.write(bytes);
//
//						printWriter = resp.getWriter();
//						
//						resp.setContentType("text/html");
//						//String fileUrl = req.getContextPath() + "/img/" + fileName;
//						String fileUrl = "https://image/imageupload.do?img=" + fileName;
//						//	String fileUrl = uploadPath;
//						System.out.println("fileUrl: "+fileUrl);
//						// json 데이터로 등록
//						// {"uploaded" : 1, "fileName" : "test.jpg", "url" : "/img/test.jpg"}
//						// 이런 형태로 리턴이 나가야함.
//						json.addProperty("uploaded", 1);
//						json.addProperty("fileName", fileName);
//						json.addProperty("url", fileUrl);
//
//						printWriter.println(json);
//						System.out.println(json);
//					} catch (IOException e) {
//						e.printStackTrace();
//					} finally {
//						if (out != null) {
//							out.close();
//						}
//						if (printWriter != null) {
//							printWriter.close();
//						}
//					}
//				}
//			}
//		}
//		return null;
//	}

	/*
	 * @RequestMapping(value="/imageupload.do", method=RequestMethod.POST) public
	 * String imageUpload(HttpServletRequest request, Model
	 * model,@RequestParam(value="CKEditorFuncNum", required=false) String
	 * CKEditorFuncNum) throws Exception { // Spring multipartResolver 미사용 시
	 * (commons-fileupload 활용) // List<EgovFormBasedFileVo> list =
	 * EgovFormBasedFileUtil.uploadFiles(request, uploadDir, maxFileSize);
	 * 
	 * // Spring multipartResolver 사용시 FileUtils fileutils = new FileUtils();
	 * List<EgovFormBasedFileVo> list = FileUtils.pa;
	 * 
	 * if (list.size() > 0) { EgovFormBasedFileVo vo = list.get(0); // 첫번째 이미지
	 * 
	 * String url = request.getContextPath() + "/utl/web/imageSrc.do?" + "path=" +
	 * vo.getServerSubPath() + "&physical=" + vo.getPhysicalName() + "&contentType="
	 * + vo.getContentType();
	 * 
	 * //model.addAttribute("CKEditorFuncNum",
	 * request.getParameter("CKEditorFuncNum"));
	 * model.addAttribute("CKEditorFuncNum", CKEditorFuncNum);
	 * model.addAttribute("url", url); }
	 * 
	 * return "egovframework/com/utl/wed/EgovInsertImage"; }
	 */

//    // 이미지 업로드
//    // product_edit페이지에서 맵핑되는 메소드
//    @RequestMapping(value = "/imageupload.do")
//    // 이미지를 저장하고, 불러오고, 업로드하기위해 매개변수를 선언
//    public String imageUpload(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam MultipartFile upload)
//    //MultipartFile 타입은 ckedit에서 upload란 이름으로 저장하게 된다
//            throws Exception {
// 
//        // 한글깨짐을 방지하기위해 문자셋 설정
//        response.setCharacterEncoding("utf-8");
// 
//        // 마찬가지로 파라미터로 전달되는 response 객체의 한글 설정
//        response.setContentType("application/json");
// 
//        // 업로드한 파일 이름
//        String fileName = upload.getOriginalFilename();
//        System.out.println(fileName);
//        // 파일을 바이트 배열로 변환
//        byte[] bytes = upload.getBytes();
// 
//        // 이미지를 업로드할 디렉토리(배포 디렉토리로 설정)
//        String uploadPath = "C:\\Users\\Admin\\Documents\\GitHub\\Java_Spring\\spring\\minnieNail\\src\\main\\webapp\\upload\\board\\";
//        String url = uploadPath+fileName;
//        model.addAttribute("url", url);
//        
//        Map<String, Object> data = new HashMap<String, Object>();
//        data.put("uploaded", 1);
//        data.put("fileName", fileName);
//        data.put("url", url);
//        
////        ObjectMapper mapper = new ObjectMapper();
////        try {
////        	mapper.writeValue(response.getWriter(), data);
////        } catch (Exception e) {
////        	e.printStackTrace();
////        }
//        return null;
//    }

//	@RequestMapping(value = "/imageupload.do", method = RequestMethod.POST)
//	public String imageUpload(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam MultipartFile upload) {
//		web.init();
//		
//		response.setContentType("application/json");
//		try {
//		upload.multipartRequest();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//		List<FileInfo> fileList = upload.getFileList();
//		String url = "%s/downloadImage.do?file=%s/%s";
//		String fileName = "";
//		
//		if (fileList.size() > 0) {
//			FileInfo temp = fileList.get(0);
//			url = String.format(url, web.getRootPath(), )
//		}
//	}

}
