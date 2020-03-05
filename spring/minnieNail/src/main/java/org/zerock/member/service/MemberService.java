package org.zerock.member.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.member.dto.UsersDTO;
import org.zerock.member.mapper.MemberMapper;

@Service
public class MemberService {

	@Inject
	private MemberMapper mapper;
	
	public List<UsersDTO> list() {
		return mapper.userList();
	}

	public Integer mManage(UsersDTO udto) {
		return mapper.mManage(udto);
	}
	
	public Integer authCheck(Integer sns_id) {
		System.out.println("MemberService.authCheck: mapper.authCheck(udto): "+ sns_id);
		return mapper.authCheck(sns_id);
	}

}
