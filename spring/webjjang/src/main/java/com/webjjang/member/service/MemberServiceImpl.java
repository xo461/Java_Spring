package com.webjjang.member.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webjjang.member.dto.LoginDTO;
import com.webjjang.member.dto.MemberDTO;
import com.webjjang.member.mapper.MemberMapper;
import com.webjjang.util.page.PageObject;
import lombok.AllArgsConstructor;

@Service 
@Qualifier("ms")
@AllArgsConstructor
public class MemberServiceImpl implements MemberService{

	//db처리를 위한 mapper 변수 선언
	private MemberMapper mapper;
	
	@Override
	public List<MemberDTO> list(PageObject pageObject) {
		// 넘어온 페이지의 첫번째와 마지막 게시글의 글번호 구하는 메서드
		pageObject.calcuPageInfo();
		// jsp의 페이지네이션을 위한 계산 -> jsp에 전달이 되어야 한다. request에 담는다.
		pageObject.setTotalRow(mapper.getTotalRow(pageObject)); //db에서 전체데이터개수가져와서(검색해서필터링되면 된대로) => 전체페이지수및 페이지그룹의시작페이지,끝페이지 구하기.
		System.out.println("MemberServiceImpl.list().pageObject : "+pageObject);
		return mapper.list(pageObject);
	}

	@Override
	public Integer write(MemberDTO dto) {
		// TODO Auto-generated method stub
		return mapper.write(dto);
	}

	@Override
	public MemberDTO view(int no) {
		mapper.increaseHit(no); //나중에 수정해야됨.
		return mapper.view(no);
	}

	@Override
	public Integer update(MemberDTO dto) {
		// TODO Auto-generated method stub
		return mapper.update(dto);
	}

	@Override
	public Integer delete(MemberDTO dto) {
		// TODO Auto-generated method stub
		return mapper.delete(dto);
	}
	
	@Override
	public LoginDTO login(LoginDTO dto) {
		return mapper.login(dto);
	}
	
	

}
