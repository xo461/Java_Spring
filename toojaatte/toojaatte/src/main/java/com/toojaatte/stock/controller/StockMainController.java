package com.toojaatte.stock.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.toojaatte.news.service.JsonRead;
import com.toojaatte.stock.dto.StockDTO;

@Controller
@RequestMapping("stockmain")
public class StockMainController {

	@GetMapping("/index.do")
	public String index(Model model) {
		
		List<StockDTO> kospi = JsonRead.kospiJsonRead();
		System.out.println("StockMainController.index().kospi: "+kospi);
		model.addAttribute("kospi", kospi);
		
		List<StockDTO> kospi200 = JsonRead.kospi200JsonRead();
		System.out.println("StockMainController.index(): "+kospi200);
		model.addAttribute("kospi200", kospi200);

		List<StockDTO> kosdaq = JsonRead.kosdaqJsonRead();
		System.out.println("StockMainController.index()kosdaq: "+kosdaq);
		model.addAttribute("kosdaq", kosdaq);
		
		return "/stock/main";
	}
	
	
}
