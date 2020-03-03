package org.zerock.login;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.member.dto.UsersDTO;

@Service
public class SignupService {

	@Inject
	private MemberMapper mapper;

	public Integer insertNormalUser(UsersDTO udto) {
		System.out.println("SigupService.insertNormalUser.dto : " + udto);
		System.out.println("SigupService.insertNormalUser : " + udto.getSns_id());
		System.out.println("SigupService.insertNormalUser : " + udto.getEmail());
		System.out.println("SigupService.insertNormalUser : " + udto.getNickname());

		// 이미 존재하는 email인지 확인
		String user_email = udto.getEmail();
		String ck = mapper.emailCheck(user_email);
		if(ck == null)
			return mapper.insertNormalUser(udto);
		else
			return 0;
			
//		return mapper.insertNormalUser(udto);
		
//		System.out.println("SignupService.insertNormalUser().userList(): " + mapper.userList());
//		UsersDTO userlist = mapper.userList();
		
	}
}
