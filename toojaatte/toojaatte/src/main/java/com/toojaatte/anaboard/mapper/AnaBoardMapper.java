package com.toojaatte.anaboard.mapper;

import java.util.List;

import com.toojaatte.anaboard.dto.AnaBoardDTO;
import com.toojaatte.anaboard.dto.AnaBoard_FileDTO;
import com.toojaatte.util.page.PageObject;

// 같은 서비스여도 DB에서 처리해야하는 서비스들이 있으니 서로 구분지어 생성(AnaBoardMapper.java / AnaBoardService.java) 
// SQL은 resources 안에 패키지에 맞는 폴더를 만들어서 AnaBoardMapper.xml만들고
// 각각의 메서드에 맞는 태그를 작성해준다. 이때 아이디가 메서드이름과 같아야한다.
public interface AnaBoardMapper {

	// 1.리스트 - list()
	public List<AnaBoardDTO> list(PageObject pageObject);
	public Integer getTotalRow(PageObject pageObject);
	// 2.글쓰기 처리 - write(dto)
	public Integer write(AnaBoardDTO dto);
	public Integer writeFile(AnaBoard_FileDTO fdto);
	// 3.글보기 - view(no) / increaseHit(no)
	public AnaBoardDTO view(int no);
	public Integer increaseHit(int no);
	// 4.글수정 처리 - update(dto)
	public Integer update(AnaBoardDTO dto);
	// 5.글삭제 - delete(dto) ==> no와 pw:post 방식
	public Integer delete(AnaBoardDTO dto);
	
}