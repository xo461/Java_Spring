package com.toojaatte.anaboard.service;

import java.util.List;

import com.toojaatte.anaboard.dto.AnaBoardDTO;
import com.toojaatte.util.page.PageObject;


public interface AnaBoardService {

	// 1.리스트 - list()
	public List<AnaBoardDTO> list(PageObject pageObject);
	// 2.글쓰기 처리 - write(dto)
	public Integer write(AnaBoardDTO dto);
	// 3.글보기 - view(no) / increaseHit(no)
	public AnaBoardDTO view(int no);
	// 4.글수정 처리 - update(dto)
	public Integer update(AnaBoardDTO dto);
	// 5.글삭제 - delete(dto) ==> no와 pw:post 방식
	public Integer delete(AnaBoardDTO dto);
	

}
