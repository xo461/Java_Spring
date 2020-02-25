package org.zerock.member.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberDTO {

	private String id, pw, name, gender;
	@DateTimeFormat(pattern="yyyy-MM-dd") // 화면단에서 사용자로부터 날짜를 입력받아서 저장할경우 이 어노테이션을 붙여야 400번에러가 안남.
	private Date birth, regdate, condate;
	private String tel, email, status;
	private int grade;
	
}
