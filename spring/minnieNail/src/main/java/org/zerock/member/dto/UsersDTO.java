package org.zerock.member.dto;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
public class UsersDTO {
	private int id, state, gradeNo;
	private String userName, pw, email, nickName, sns_id, sns_type,	sns_profile;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date condate, create_date, modify_date; 
	private String gradeName, stateName;
}
