package org.zerock.board.mapper;

import java.util.List;
import java.util.Map;

import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.BoardFileDTO;
import org.zerock.util.page.PageObject;

public interface BoardMapper {

	// **** 리스트 
	//list 컬렉션은 객체를 일렬로 늘어놓은 구조로 이루어져 있다. 객체를 인덱스로 관리하기 때문에 List 컬렉션에 객체를 추가하면 자동 인덱스가 부여된다. 인덱스는 객체를 검색, 삭제할 때 사용한다. List 컬렉션은 객체 자체를 저장하는 것이 아닌 객체의 번지를 참조한다.
	//리스트, 글보기는 select쿼리로 가져온거 returntype dto로 지정해놨으므로 ...
	public List<BoardDTO> list(PageObject pageObject); //startrow, endrow 보내줘야 거기에 해당하는 데이터를 가져온다.
	public int getTotalRow(PageObject pageObject); //전체 게시글수 가져오기
	
	//**** 게시판 글쓰기 
	//글쓰기,수정,삭제 메소드의 리턴타입: 오라클에서는 insert, update, delete가 적용되면 1, 안되면 0이 리턴되어 타입이 Integer이다. 
	public Integer write(BoardDTO dto);
	public void insertFile(Map<String, Object> map) throws Exception; //파일여러개첨부

	//**** 글보기
	public BoardDTO view(int no);
	public List<BoardFileDTO> selectFiles(int no); //글보기에서 첨부파일리스트 보여주기
	public BoardFileDTO selectAFile(BoardFileDTO dto); //글보기에서 첨부파일 클릭시 : 다운로드하기 위해 정보 갖고오기
	
	//**** 글수정 - update ****
	public Integer update(BoardDTO dto);

	//**** 글삭제 - delete ****
	public Integer delete(BoardDTO dto);




}
