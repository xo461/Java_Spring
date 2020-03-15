package org.zerock.board.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data //getter,setter,tostring(),생성자 자동으로 만들어줌 -> 변수만선언하면됨
public class BoardDTO {

	private int no; //게시판번호는 길어서 보통 long으로 해줌
	private String title, content, id, nickName;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date writeDate; //날짜형..java.util
	private int hit, total_reply, total_like;
	
}
