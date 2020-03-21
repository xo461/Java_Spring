package com.webjjang.member.mapper;

import java.util.List;

import com.webjjang.member.dto.MemberDTO;
import com.webjjang.member.dto.LoginDTO;
import com.webjjang.util.page.PageObject;

//src/main/resources 안에 com/webjjang/member/mapper 폴더 각각 만들고 (이 패키지 이름하고 동일하게) 이름은 이 파일과 동일하게 membermapper.xml로 만들어야 하고, 태그의 아이디는 메서드이름과 동일하게 써야 한다. 
public interface MemberMapper {

	//***1.리스트 - list()
	public List<MemberDTO> list(PageObject pageObject);
	public int getTotalRow(PageObject pageObject);
	
	//***2.회원가입  - write(dto)
	public Integer write(MemberDTO dto);
	
	//***3.회원정보보기 - view(no) / increaseHit(no)
	public MemberDTO view(int no);
	public Integer increaseHit(int no); //수정되면 1리턴
	
	//***4.회원정보수정  - update(dto)
	public Integer update(MemberDTO dto);
	
	//***5.회원탈퇴 - delete(dto) ==> no와 pw:post 방식
	public Integer delete(MemberDTO dto);

	//***6. 로그인
	public LoginDTO login(LoginDTO dto);

}
