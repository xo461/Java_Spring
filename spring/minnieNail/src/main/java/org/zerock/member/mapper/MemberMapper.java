package org.zerock.member.mapper;

import java.util.List;

import org.zerock.member.dto.UsersDTO;

public interface MemberMapper {

	public List<UsersDTO> userList();

	// 파라미터 따로따로 보낼때는 @Param이라고 해야됨
	//	public Integer insertNormalUser(@Param("nickname") String nickname, @Param("email") String email, @Param("sns_id") String sns_id);

	public Integer insertNormalUser(UsersDTO udto);

	public Integer insertNaverUser(UsersDTO udto);

	public String emailCheck(String email);

	public Integer mManage(UsersDTO udto);

	public Integer authCheck(Integer sns_id);

	public UsersDTO login(UsersDTO udto);

	public UsersDTO selectNormalUser(UsersDTO udto);

	public UsersDTO selectNaverUser(UsersDTO udto);

}
