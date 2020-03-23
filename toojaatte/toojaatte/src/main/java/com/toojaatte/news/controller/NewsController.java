package com.toojaatte.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.toojaatte.news.dto.NewsDTO;
import com.toojaatte.news.service.JsonRead;
import com.toojaatte.news.service.NewsService;
import com.toojaatte.util.page.PageObject;

//gson라이브러리 다운 필수

@Controller
@RequestMapping("/news")
public class NewsController {

	@Autowired
	private NewsService service;

	@GetMapping("/insert.do")
	public String insert(Model model) {
		System.out.println("NewsController.insert()");
		List<NewsDTO> list = JsonRead.jsonRead();
		//System.out.println(list);
		service.insert(list);
		return "news/test";
	}
	
	@GetMapping("/list.do")
	public String list(Model model, PageObject pageObject) {
		List<NewsDTO> mainNewsList = service.list(pageObject);
		List<NewsDTO> mostViewedNewsList = service.mostViewed();
		model.addAttribute("dto", mainNewsList);
		model.addAttribute("mostViewed", mostViewedNewsList);
		model.addAttribute("pageObject", pageObject);
		return "news/list";
	}
	
	
	@GetMapping("/view.do")
	public String view(int nno, Model model) {
		model.addAttribute("dto", service.view(nno));
		return "news/view";
	}
}
