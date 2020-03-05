package org.zerock.member.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.login.MemberMapper;
import org.zerock.member.dto.UsersDTO;

@Service
public class MemberService {

	@Inject
	private MemberMapper mapper;
	
	public List<UsersDTO> list() {
		return mapper.userList();
	}

	public Integer manage(UsersDTO udto) {
		return mapper.manage(udto);
	}
	
	public Integer authCheck(Integer sns_id) {
		System.out.println("MemberService.authCheck: mapper.authCheck(udto): "+ sns_id);
		return mapper.authCheck(sns_id);
	}
}
