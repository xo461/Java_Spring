package com.webjjang.reply.mapper;

import java.util.List;
import java.util.Map;
import com.webjjang.reply.dto.ReplyDTO;

public interface ReplyMapper {
	
	//댓글리스트
	public List<ReplyDTO> list(Map<String, Object> map);
	public Integer getTotalRow(int no);

	public Integer write(ReplyDTO dto);

	//수정 : 글번호와 비밀번호넘김
	public Integer update(ReplyDTO dto);

	public Integer delete(ReplyDTO dto);

}
