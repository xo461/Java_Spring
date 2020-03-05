package org.zerock.member.service;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.zerock.member.dto.UsersDTO;
import org.zerock.member.mapper.MemberMapper;

@Service
public class SignupService {

	@Inject
	private MemberMapper mapper;

	//네이버로 가입: 세션에서 sns_id, email, nickname 받아옴
	public Integer insertNaverUser(UsersDTO udto) {
		System.out.println("SigupService.insertNaverlUser.dto : " + udto);

		// 이미 존재하는 email인지 확인
		String user_email = udto.getEmail();
		String ck = mapper.emailCheck(user_email);
		if(ck == null)
			return mapper.insertNaverUser(udto);
		else
			return 0;
	}

	//일반 가입 : ajax post방식으로 userName, pw, email, nickName 받아옴
	public Integer insertNormalUser(UsersDTO udto) {
		System.out.println("SigupService.insertNormallUser.dto : " + udto);

		// 이미 존재하는 email인지 확인
		String user_email = udto.getEmail();
		String ck = mapper.emailCheck(user_email);
		if(ck == null)
			return mapper.insertNormalUser(udto);  //return 1
		else
			return 0;
	}
	
	public UsersDTO selectUser(UsersDTO udto) {
		return mapper.selectUser(udto);
	}

}
