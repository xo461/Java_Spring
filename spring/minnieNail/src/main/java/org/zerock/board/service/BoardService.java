package org.zerock.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.BoardFileDTO;
import org.zerock.util.page.PageObject;


public interface BoardService {
	//***1.리스트 - list()
	public List<BoardDTO> list(PageObject pageObject);
	
	//***2.글쓰기 처리 - write(dto)
	public void write(BoardDTO dto, MultipartHttpServletRequest mpReq) throws Exception;
	
	//***3.글보기 - view(no) / increaseHit(no)
	public Map<String, Object> view(int no);
	public BoardFileDTO selectAFile(BoardFileDTO dto); //글보기에서 첨부파일 클릭시 다운로드하기 위해 정보 갖고오기
	
	//***4.글수정 처리 - update(dto)
	public Integer update(BoardDTO dto);
	
	//***5.글삭제 - delete(dto) ==> no와 pw:post 방식
	public Integer delete(BoardDTO dto);

	
}
