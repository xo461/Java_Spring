package org.zerock.notice.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.notice.dto.NoticeDTO;
import org.zerock.notice.mapper.NoticeMapper;

@Service
public class NoticeService {

	@Inject
	private NoticeMapper noticeMapper;
	
	public  List<NoticeDTO> list() {
		return noticeMapper.list();
	}
	
	public Integer write(NoticeDTO dto) {  //수정처리되면 1이 반환되어 integer타입
		return noticeMapper.write(dto);
		
	}

}
