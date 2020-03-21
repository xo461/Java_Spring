package com.webjjang.member.dto;

import lombok.Data;

@Data
public class LoginDTO {

	private String id, name, photo, gradeName, pw;
	private int newMsgCnt, gradeNo;
	
}
