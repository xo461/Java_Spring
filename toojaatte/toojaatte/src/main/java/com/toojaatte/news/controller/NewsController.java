package com.toojaatte.news.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.toojaatte.news.dto.NewsDTO;
import com.toojaatte.news.file.JsonRead;

//gson라이브러리 다운 필수

@Controller
@RequestMapping("/news")
public class NewsController {

	@GetMapping("/list.do")
	public String list(Model model) {
		List<NewsDTO> dto = JsonRead.jsonRead();
		System.out.println(dto);
		model.addAttribute("dto", dto);
		return "news/list";
	}
	
	public String view(NewsDTO dto, Model model) {
		JsonRead.view(no);
	}
}
