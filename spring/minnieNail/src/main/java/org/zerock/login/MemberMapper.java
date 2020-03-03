package org.zerock.login;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.member.dto.UsersDTO;

public interface MemberMapper {

	public List<UsersDTO> userList();

	// 파라미터 따로따로 보낼때는 @Param이라고 해야됨
	//	public Integer insertNormalUser(@Param("nickname") String nickname, @Param("email") String email, @Param("sns_id") String sns_id);

	
	public Integer insertNormalUser(UsersDTO udto);

	public String emailCheck(String email);

	public Integer manage(UsersDTO udto);
}
