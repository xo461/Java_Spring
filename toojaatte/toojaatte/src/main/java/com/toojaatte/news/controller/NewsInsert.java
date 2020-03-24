package com.toojaatte.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.toojaatte.news.dto.NewsDTO;
import com.toojaatte.news.service.JsonRead;
import com.toojaatte.news.service.NewsService;

//gson라이브러리 다운 필수
public class NewsInsert {

	@Autowired
	private NewsService service;
	
	public int insert(Model model) {
		List<NewsDTO> dto = JsonRead.jsonRead();
		System.out.println(dto);
		return service.insert(dto);
	}
}