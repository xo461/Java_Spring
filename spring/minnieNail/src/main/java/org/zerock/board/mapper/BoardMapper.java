package org.zerock.board.mapper;

import java.util.List;
import java.util.Map;

import org.zerock.board.dto.BoardDTO;

public interface BoardMapper {

	// **** 리스트 - select ****
	//메소드 선언만 하고 구현은 resources에 있는 BoardMapper.xml에서 한다.(위치, 파일명 동일하게해야 인식) 
	//List 컬렉션
	//list 컬렉션은 객체를 일렬로 늘어놓은 구조로 이루어져 있다. 객체를 인덱스로 관리하기 때문에 List 컬렉션에 객체를 추가하면 자동 인덱스가 부여된다. 인덱스는 객체를 검색, 삭제할 때 사용한다. List 컬렉션은 객체 자체를 저장하는 것이 아닌 객체의 번지를 참조한다.
	//리스트, 글보기는 select쿼리로 가져온거 returntype dto로 지정해놨으므로 ...
	public List<BoardDTO> list();
	
	//**** 게시판 글쓰기 - insert ****
	//글쓰기,수정,삭제 메소드의 리턴타입: 오라클에서는 insert, update, delete가 적용되면 1, 안되면 0이 리턴되어 타입이 Integer이다. 
	public Integer write(BoardDTO dto);

	//**** 글보기 - select ****
	public BoardDTO view(int no);

	//**** 글수정 - update ****
	public Integer update(BoardDTO dto);

	//**** 글삭제 - delete ****
	public Integer delete(int no);

	//**** fileUpload ****
	public void insertFile(Map<String, Object> map) throws Exception;
}
