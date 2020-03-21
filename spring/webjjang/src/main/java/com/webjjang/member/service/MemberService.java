package com.webjjang.member.service;

import java.util.List;

import com.webjjang.member.dto.LoginDTO;
import com.webjjang.member.dto.MemberDTO;
import com.webjjang.util.page.PageObject;

//서비스는 컨트롤러용..컨트롤러가 호출해서 사용할것이니.. 
//mapper는 db용... 서비스에서는 내가 하고싶은것만 적는다면, mapper에는 그 하고싶은걸 햇을때 db딴에서 추가적으로 적용되는걸 다 담음..
public interface MemberService {
	
	//***1.리스트 - list()
	public List<MemberDTO> list(PageObject pageObject);
	
	//***2.회원등록 - write(dto)
	public Integer write(MemberDTO dto);
	
	//***3.회원보기 - view(no) / increaseHit(no)
	public MemberDTO view(int no);
	
	//***4.회원수정 처리 - update(dto)
	public Integer update(MemberDTO dto);
	
	//***5.회원탈퇴 - delete(dto) ==> no와 pw:post 방식
	public Integer delete(MemberDTO dto);

	public LoginDTO login(LoginDTO dto);
	
}
