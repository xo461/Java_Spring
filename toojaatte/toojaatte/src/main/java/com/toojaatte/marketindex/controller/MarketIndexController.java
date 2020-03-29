package com.toojaatte.marketindex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toojaatte.news.service.JsonRead;
import com.toojaatte.stock.dto.StockDTO;

@Controller
@RequestMapping("marketindex")
public class MarketIndexController {

	@GetMapping("/main.do")
	public String index(Model model) {
		
		List<StockDTO> usdkrw = JsonRead.usdkrwJsonRead();
		System.out.println("StockMainController.index().usdkrw: "+usdkrw);
		model.addAttribute("usdkrw", usdkrw);
		
		List<StockDTO> cnykrw = JsonRead.cnykrwJsonRead();
		System.out.println("StockMainController.index().cnykrw: "+cnykrw);
		model.addAttribute("cnykrw", cnykrw);

		List<StockDTO> jpykrw = JsonRead.jpykrwJsonRead();
		System.out.println("StockMainController.index().jpykrw: "+jpykrw);
		model.addAttribute("jpykrw", jpykrw);
		
		return "/marketindex/main";
	}
}
