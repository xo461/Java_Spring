package com.webjjang.board.dto;

public class BoardReplyDTO {
	
	private int rno;
	private int no;
	private String content, writer, writeDate;
	
	//댓글달기용 생성자. 
	public BoardReplyDTO(int no, String content, String writer) {
		super();//object생성자
		this.no = no;
		this.content = content;
		this.writer = writer;
	}
	//댓글 수정용 - writer는 못바꿔서 jsp에서 받아오기만 하면되고 dto에선 필요업다.
	public BoardReplyDTO(int rno, String content) {
		super();//object생성자
		this.rno = rno;
		this.content = content;
	}
	
	//기본생성자 - 이게 없으면 위에 댓글달기용생성자밖에 못쓰기때문에 기본생성자도 필요
	public BoardReplyDTO() {}
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "BoardReplyDTO [rno=" + rno + ", no=" + no + ", content=" + content + ", writer=" + writer
				+ ", writeDate=" + writeDate + "]";
	}
	
}
