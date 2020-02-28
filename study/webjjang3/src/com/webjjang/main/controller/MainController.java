package com.webjjang.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.webjjang.main.Controller;
import com.webjjang.main.Execute;
import com.webjjang.main.Service;
import com.webjjang.util.page.PageObject;

public class MainController implements Controller {

	
	//공지사항 리스트 서비스
	private Service noticeListService;	
	
	//이미지 리스트 서비스
	private Service imageListService;	
	
	//생성자 - source - generate constructor using fields... 로 하면 손쉽게 만들어짐
	public MainController(Service noticeListService, Service imageListService) {
		super();
		this.noticeListService = noticeListService;
		this.imageListService = imageListService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {

		// 공지사항데이터 가져오기 - 1페이지, 7 개 가져오기
		PageObject pageObject = new PageObject(1, 7);
		request.setAttribute("noticeList", Execute.service(noticeListService, pageObject));

		// 이미지데이터 가져오기 - 1페이지, 8개 가져오기
		pageObject = new PageObject(1, 8); //변수이름 pageObject 위에랑 중복되어서 변수재활용함...
		request.setAttribute("imageList", Execute.service(imageListService, pageObject));
		
		return "main/main";
	}
}
