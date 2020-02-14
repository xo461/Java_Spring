package com.cafeatte.userCafe.service;

import com.cafeatte.main.Service;
import com.cafeatte.userCafe.dao.UserCafeDAO;

public class UserCafeDeleteService implements Service{
	private final UserCafeDAO dao;
	public UserCafeDeleteService(UserCafeDAO dao) {
		this.dao = dao;
	}
	@Override
	public Object service(Object[] objs) throws Exception {
		int no = (int) objs[0];
		String id = (String) objs[1];
		System.out.println("userCafeDeleteService.service()+id:"+id);
		return dao.delete(no, id);
	}

}
