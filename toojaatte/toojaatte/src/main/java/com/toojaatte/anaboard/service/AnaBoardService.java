package com.toojaatte.anaboard.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.toojaatte.anaboard.dto.AnaBoardDTO;
import com.toojaatte.anaboard.dto.AnaBoard_FileDTO;
import com.toojaatte.rorn.dto.RorNDTO;
import com.toojaatte.util.page.PageObject;


public interface AnaBoardService {

	// 1.리스트 - list()
	public List<AnaBoardDTO> list(PageObject pageObject);
	// 2.글쓰기 처리 - write(dto)
	public Integer write(AnaBoardDTO dto);
	public Integer writeFile(AnaBoard_FileDTO fdto);
	// 3.글보기 - view(no) / increaseHit(no)
	public AnaBoardDTO view(int no);
	//추천비추천
	public AnaBoardDTO countRorN(int no);
	public Integer checkRorN(RorNDTO dto);
	public Integer startRorN(RorNDTO dto);
	public Integer changeRorN(RorNDTO dto);
	public Integer endRorN(RorNDTO dto);
	public Integer increaseR_cnt(int no);
	public Integer increaseN_cnt(int no);
	public Integer decreaseR_cnt(int no);
	public Integer decreaseN_cnt(int no);
	// 4.글수정 처리 - update(dto)
	public Integer update(AnaBoardDTO dto);
	public Integer updateFile(AnaBoard_FileDTO fdto);
	// 5.글삭제 - delete(dto) ==> no와 pw:post 방식
	public Integer delete(AnaBoardDTO dto, String uploadPath);
	
	//파일
	public List<AnaBoard_FileDTO> selectFile(int no);
//	public String selectFileOne(int rno);
	public Integer deleteFileOne(int rno, String uploadPath);
//	public Integer deleteFileAll(int no);
	

}
