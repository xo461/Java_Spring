package com.webjjang.reply.service;

import java.util.List;
import com.webjjang.reply.dto.ReplyDTO;
import com.webjjang.util.page.PageObject;

//서비스는 컨트롤러용..컨트롤러가 호출해서 사용할것이니.. 
//mapper는 db용... 서비스에서는 내가 하고싶은것만 적는다면, mapper에는 그 하고싶은걸 햇을때 db딴에서 추가적으로 적용되는걸 다 담음..
public interface ReplyService {
	
	//***1.리스트 - list()
	public List<ReplyDTO> list(int no, PageObject pageObject);
	
	//***2.댓글쓰기
	public Integer write(ReplyDTO dto);
	
	//***4.댓글수정
	public Integer update(ReplyDTO dto);
	
	//***5.댓글삭제
	public Integer delete(ReplyDTO dto);

	
}
