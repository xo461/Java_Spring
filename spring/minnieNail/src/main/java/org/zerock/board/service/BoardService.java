package org.zerock.board.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.zerock.FileUtils.FileUtils;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.BoardFileDTO;
import org.zerock.board.mapper.BoardMapper;

@Service
public class BoardService {

	@Inject  //autowired와 같음. 자동으로 들어오게.
	private BoardMapper boardMapper; //service에서 dao생성해주듯. mapper가 dao역할을 함

	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	//서비스에도 메소드가 있어야 컨트롤러에서 가져다 쓸 수 있다. 
	public List<BoardDTO> list(){ //리스트 가져오는 메소드이므로 리턴타입은 리스트 컬렉션
		return boardMapper.list(); //dao의 list메소드를 실행해서 나온 결과를 리턴함
	}

	//오라클에서는 insert, update, delete가 적용되면 1, 안되면 0이 리턴되어 타입이 Integer이다. 
	public void write(BoardDTO dto, BoardFileDTO fdto, MultipartHttpServletRequest mpRequest) throws Exception {
		boardMapper.write(dto);
		List<Map<String, Object>> fList = fileUtils.parseInsertFileInfo(fdto, dto, mpRequest);
		System.out.println(fList.toString());
		int size = fList.size();
		//for문을 써서 list의 size만큼 넣어주는 이유는 나중에 여러개의 첨부파일을 등록하기 위해서
		for(int i=0; i<size; i++){ 
			boardMapper.insertFile(fList.get(i));
		}
		System.out.println();
		
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
	public Integer delete(int no) { //void타입도 가능
		return boardMapper.delete(no);
	}

}
