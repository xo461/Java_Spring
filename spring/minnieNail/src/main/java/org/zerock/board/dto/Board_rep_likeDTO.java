package org.zerock.board.dto;

import lombok.Data;

@Data 
public class Board_rep_likeDTO {
	//멤버 id, 게시판 글번호 no, 댓글번호,  좋아하면1싫어하면-1
	private int id, no, rep_no, likeDislike; 
	
}
