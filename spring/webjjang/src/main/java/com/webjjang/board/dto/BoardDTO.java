package com.webjjang.board.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDTO {

	private int no;
	private String title, content, writer;
	private Date writeDate;
	private int hit, reply_cnt;
	private String pw;
	
}
