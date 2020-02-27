package com.webjjang.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webjjang.board.dto.BoardDTO;
import com.webjjang.board.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j //로그 출력: log.info()
@Service 
@Qualifier("bs")
@AllArgsConstructor
//Boardservice상속받으므로 boardcontroller에서 boardservice 변수선언시 bean이 boardservice와 boardserviceimpl 두개 가 된다 ->  같은 타입의 빈이 두 개 이상이 존재하는 경우에 스프링이 어떤 빈을 주입해야 할지 알 수 없어서 스프링 컨테이너를 초기화하는 과정에서 예외를 발생시킨다.
//이 경우 양쪽에 @Qualifier("같은이름") 써줘서 어떤 bean을 가져오는지 명시해준다.
public class BoardServiceImpl implements BoardService{

	//db처리를 위한 mapper 변수 선언
	private BoardMapper mapper;
	
	@Override
	public List<BoardDTO> list() {
		// TODO Auto-generated method stub
		return mapper.list();
	}

	@Override
	public Integer write(BoardDTO dto) {
		// TODO Auto-generated method stub
		return mapper.write(dto);
	}

	@Override
	public BoardDTO view(int no) {
		mapper.increaseHit(no); //나중에 수정해야됨.
		return mapper.view(no);
	}

	@Override
	public Integer update(BoardDTO dto) {
		// TODO Auto-generated method stub
		return mapper.update(dto);
	}

	@Override
	public Integer delete(BoardDTO dto) {
		// TODO Auto-generated method stub
		return mapper.delete(dto);
	}

}
