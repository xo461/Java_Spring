package org.zerock.board.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Board_repDTO {

	private int rep_no, no, id; //댓글번호, 글번호, 작성자 id
	private String content, nickName, sns_profile;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date writeDate; //날짜형..java.util
	private int total_like, total_dislike;
	
}
