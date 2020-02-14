package com.webjjang.member.service;

import com.webjjang.main.Service;
import com.webjjang.member.dao.MemberDAO;

public class MemberIdCheckService implements Service {

	private MemberDAO dao;
	
	public MemberIdCheckService(MemberDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public String service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		String id = (String) objs[0];
		return null;
	}

}
