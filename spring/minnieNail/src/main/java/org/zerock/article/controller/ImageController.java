package org.zerock.article.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {

	  @PostMapping("/image")
	    @ResponseBody
	    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
	        try {
	            UploadFile uploadedFile = imageService.store(file);
	            return ResponseEntity.ok().body("/image/" + uploadedFile.getId());
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.badRequest().build();
	        }
	    }

	  public UploadFile store(MultipartFile file) throws Exception {
	        try {
	            if (file.isEmpty()) {
	                throw new Exception("Failed to store empty file " + file.getOriginalFilename());
	            }
	            
	            String saveFileName = UploadFileUtils.fileSave(rootLocation.toString(), file);
	            
	            if (saveFileName.toCharArray()[0] == '/') {
	                saveFileName = saveFileName.substring(1);
	            }
	            
	            Resource resource = loadAsResource(saveFileName);
	            
	            UploadFile saveFile = new UploadFile();
	            saveFile.setSaveFileName(saveFileName);
	            saveFile.setFileName(file.getOriginalFilename());
	            saveFile.setContentType(file.getContentType());
	            saveFile.setFilePath(rootLocation.toString() + File.separator + saveFileName);
	            saveFile.setSize(resource.contentLength());
	            saveFile.setRegDate(new Date());
	            saveFile = fileRepository.save(saveFile);
	            
	            return saveFile;
	        } catch (IOException e) {
	            throw new Exception("Failed to store file " + file.getOriginalFilename(), e);
	        }
	    }

	    @GetMapping("/image/{fileId}")
	    @ResponseBody
	    public ResponseEntity<?> serveFile(@PathVariable int fileId) {
	        try {
	            UploadFile uploadedFile = imageService.load(fileId);
	            HttpHeaders headers = new HttpHeaders();
	            
	            Resource resource = imageService.loadAsResource(uploadedFile.getSaveFileName());
	            String fileName = uploadedFile.getFileName();
	            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
	 
	            if (MediaUtils.containsImageMediaType(uploadedFile.getContentType())) {
	                headers.setContentType(MediaType.valueOf(uploadedFile.getContentType()));
	            } else {
	                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	            }
	            
	            return ResponseEntity.ok().headers(headers).body(resource);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.badRequest().build();
	        }
	    }


}
