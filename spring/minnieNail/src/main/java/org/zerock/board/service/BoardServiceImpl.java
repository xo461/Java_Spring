package org.zerock.board.service;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.zerock.FileUtils.FileUtils;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.mapper.BoardMapper;

@Service
@Qualifier("bs")
public class BoardServiceImpl implements BoardService {

	@Inject  //autowired와 같음. 자동으로 들어오게.
	private BoardMapper boardMapper; //service에서 dao생성해주듯. mapper가 dao역할을 함

	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	//서비스에도 메소드가 있어야 컨트롤러에서 가져다 쓸 수 있다. 
	public List<BoardDTO> list(){ //리스트 가져오는 메소드이므로 리턴타입은 리스트 컬렉션
		return boardMapper.list(); //dao의 list메소드를 실행해서 나온 결과를 리턴함
	}

	public void write(BoardDTO dto, MultipartHttpServletRequest mpReq) throws Exception {
		//1.BoardDTO에 쓴 글 정보 보낸다. 
		boardMapper.write(dto);
		System.out.println("BoardService.write().BoardDTO: "+ dto);
		//2-1. 파일여러개 -> 정보를 리스트로 만들어서 fileUtils로 보내서 처리해서 가져옴
		List<Map<String, Object>> fList = fileUtils.parseInsertFileInfo(dto, mpReq);
		System.out.println("BoardService.write().flist: "+ fList);
		//2-2. 처리된 파일리스트를 갯수(size)만큼 for문돌려서 mapper로 보낸다.
		int size = fList.size();
		for(int i=0; i<size; i++){ 
			boardMapper.insertFile(fList.get(i));
		} 
	}
	
	//**** 글보기 ****
	public BoardDTO view(int no) {
		return boardMapper.view(no);  //mapper(dao역할)의 view메소드 호출 -> .xml에 있는 쿼리 실행 ->dto가져와서 controller로 리턴시킨다. 
	}

	//**** 글수정 ****
	public Integer update(BoardDTO dto) {
		return boardMapper.update(dto);
	}

	//**** 글삭제 ****
	public Integer delete(BoardDTO dto) { //void타입도 가능
		return boardMapper.delete(dto);
	}

}
