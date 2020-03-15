package org.zerock.board.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.BoardFileDTO;
import org.zerock.board.dto.Board_repDTO;
import org.zerock.board.mapper.BoardMapper;
import org.zerock.util.fileutils.FileUtils;
import org.zerock.util.page.PageObject;

@Service
@Qualifier("bs")
public class BoardServiceImpl implements BoardService {

	@Inject  //autowired와 같음. 자동으로 들어오게.
	private BoardMapper boardMapper; //service에서 dao생성해주듯. mapper가 dao역할을 함

	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	//서비스에도 메소드가 있어야 컨트롤러에서 가져다 쓸 수 있다. 
	@Override
	public List<BoardDTO> list(PageObject pageObject){ //리스트 가져오는 메소드이므로 리턴타입은 리스트 컬렉션
		// 넘어온 페이지의 첫번째와 마지막 게시글의 글번호 구하는 메서드
		pageObject.calcuPageInfo();
		// jsp의 페이지네이션을 위한 계산 -> jsp에 전달이 되어야 한다. request에 담는다.
		////db에서 전체데이터개수가져와서(검색해서필터링되면 된대로) => 전체페이지수및 페이지그룹의시작페이지,끝페이지 구하기.
		pageObject.setTotalRow(boardMapper.getTotalRow(pageObject));
		System.out.println("BoardServiceImpl.list().pageObject : "+pageObject);
		return boardMapper.list(pageObject); //dao의 list메소드를 실행해서 나온 결과를 리턴함
	}

	//**** 글쓰기 ****
	@Override
	public void write(BoardDTO dto, MultipartHttpServletRequest mpReq) throws Exception {
		//1.BoardDTO에 쓴 글 정보 보낸다. 
		boardMapper.write(dto);
		System.out.println("BoardService.write().BoardDTO: "+ dto);
		
		//2-1. 파일여러개 -> 정보를 리스트로 만들어서 fileUtils로 보내서 처리해서 가져옴
		List<Map<String, Object>> fList = fileUtils.parseInsertFileInfo(dto, mpReq);
		System.out.println("BoardService.write().file list: "+ fList);
		
		//2-2. 처리된 파일리스트를 갯수(size)만큼 for문돌려서 mapper로 보낸다.
		int size = fList.size();
		for(int i=0; i<size; i++){ 
			boardMapper.insertFile(fList.get(i));
		} 
	}
	
	//**** 글보기 ****
	//hashmap에 담기(글1개에대한 dto정보, 파일여러개리스트)
	@Override
	public Map<String, Object> view(int no, int cnt) {
		
		//조회수 1증가 먼저 수행
		if(cnt==1) {
			boardMapper.increaseHit(no);
		}
		
		Map<String, Object> boardViewMap = new HashMap<String, Object>();

		boardViewMap.put("dto", boardMapper.view(no)); //글정보dto dto이름으로 담기

		List<BoardFileDTO> fList = boardMapper.selectFiles(no);
		boardViewMap.put("fList", fList); //파일리스트 flist이름으로 담기
		
		System.out.println("boardServiceImpl.view().boardViewMap: "+boardViewMap);
		return boardViewMap;  //mapper(dao역할)의 view메소드 호출 -> .xml에 있는 쿼리 실행 ->dto가져와서 controller로 리턴시킨다. 
	}

	//**** 첨부파일 다운로드
	@Override
	public BoardFileDTO selectAFile(BoardFileDTO dto) {
		return boardMapper.selectAFile(dto);
	}
	

	//**** 글수정 ****
	@Override
	public Integer update(BoardDTO dto) {
		return boardMapper.update(dto);
	}

	//**** 글삭제 ****
	@Override
	public Integer delete(BoardDTO dto) { //void타입도 가능
		return boardMapper.delete(dto);
	}

}
