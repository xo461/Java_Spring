package com.webjjang.image.dto;

import java.util.Date;
import org.springframework.web.multipart.MultipartFile;
import lombok.Data;

@Data
public class ImageDTO {

	private int no;
	private String title, content, id, name;
	private Date writeDate;
	private String fileName; //서버에 올라간 경로+파일명
	private MultipartFile multiFile; //여러개이면 배열[]로 한다.
	
	//이미지 등록/수정시 필요한 처리 : db저장용 파일 이름을 알아내야 한다.
	public void setFileNameProcess() {
		fileName = "/upload/image/" + multiFile.getName();
	}
	
}
