package org.zerock.notice.mapper;

import java.util.List;

import org.zerock.notice.dto.NoticeDTO;

public interface NoticeMapper {
	
	public List<NoticeDTO> list();
	public Integer write(NoticeDTO dto);
	
}
