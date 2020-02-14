//로그인이 필요한 서비스를 예외처리시켜서 
//사용자가 로그인하게 만듦.

package com.webjjang.exception;

public class NotLoginException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1506941079277576406L;

	public NotLoginException() {
		super("로그인이 필요한 서비스입니다. "
				+ " 로그인을 해주세요. ");
	}
}
