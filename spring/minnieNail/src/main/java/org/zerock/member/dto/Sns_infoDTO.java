package org.zerock.member.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Sns_infoDTO {
	private int id;
	private String sns_id, sns_type, sns_name, sns_profile;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date sns_connect_date;
	
}
