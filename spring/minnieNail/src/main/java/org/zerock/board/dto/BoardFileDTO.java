package org.zerock.board.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardFileDTO {

	private int file_no, NO, FILE_SIZE; 
	private String ORG_FILE_NAME, STORED_FILE_NAME, DEL_GB;
	private Date regdate;
}


