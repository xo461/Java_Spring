package com.ninemovies.movie.controller;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ninemovies.movie.dto.MovieDTO;
import com.ninemovies.movie.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Inject
	private MovieService service;
	
	private final String MODULE = "movie"; //상수로 정의 ->대문자
	
	@GetMapping("/list")
	public String list(Model model){
		model.addAttribute("list", service.list());
		return MODULE + "/list";
	}

	@GetMapping("/insert")
	public String insertForm() {
		return MODULE + "/insert";
	}
	
	@PostMapping("/insert")
	public String insert(MovieDTO dto) {
		service.insert(dto);
		return "redirect:list";
	}
	
	@GetMapping("/view")
	public String view(@RequestParam("no") int no, Model model) {
		model.addAttribute("dto", service.view(no));
		return MODULE + "/view";
	}
	
}
