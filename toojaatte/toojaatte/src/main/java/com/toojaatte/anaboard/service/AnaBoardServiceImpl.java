package com.toojaatte.anaboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.toojaatte.anaboard.dto.AnaBoardDTO;
import com.toojaatte.anaboard.dto.AnaBoard_FileDTO;
import com.toojaatte.anaboard.mapper.AnaBoardMapper;
import com.toojaatte.util.page.PageObject;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@Qualifier("as") 
@AllArgsConstructor //lombok 라이브러리 기능
public class AnaBoardServiceImpl implements AnaBoardService{
	
	// DB 처리를 위한 mapper 변수 선언
	private AnaBoardMapper mapper;

	@Override
	public List<AnaBoardDTO> list(PageObject pageObject) {
		// TODO Auto-generated method stub
		// 페이지 정보 계산 메서드 호출
		pageObject.calcuPageInfo();
		//jsp의 페이지네이션을 위한 계산 -> jsp에 전달이 되어야 한다. request에 담는다(Model).
		//검색할 때에 검색 전 페이지 계산이 된 값이 전달되어 리스트와 다르게 나타나므로
		//getTotalRow에 pageObject를 전달하여 검색될 항목에 대해서만 페이지 계산하게 한다.
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		return mapper.list(pageObject);
	}

	@Override
	public Integer write(AnaBoardDTO dto) {
		// TODO Auto-generated method stub
		return mapper.write(dto);
	}
	
	@Override
	public Integer writeFile(AnaBoard_FileDTO fdto) {
		// TODO Auto-generated method stub
		return mapper.writeFile(fdto);
	}

	@Override
//	@Transactional
	public AnaBoardDTO view(int no) {
		// TODO Auto-generated method stub
		// 조회수 1증가 시킨다.
		mapper.increaseHit(no);
		return mapper.view(no);
	}

	@Override
	public Integer update(AnaBoardDTO dto) {
		// TODO Auto-generated method stub
		return mapper.update(dto);
	}

	@Override
	public Integer delete(AnaBoardDTO dto) {
		// TODO Auto-generated method stub
		return mapper.delete(dto);
	}

}
