package com.webjjang.image.dto;

import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;
import lombok.Data;

@Data
public class ImageDTO {

	private int no;
	private String title, content, id, name;
	private Date writeDate;
	private String fileName; //서버에 올린 경로+파일명
	private MultipartFile multiFile; //뷰에서 넘어오는 원본파일명. 여러개이면 배열[]로 한다.
}
