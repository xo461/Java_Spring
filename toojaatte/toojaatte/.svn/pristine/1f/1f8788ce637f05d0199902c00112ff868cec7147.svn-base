package com.toojaatte.stock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.toojaatte.util.stock.GetStockData.getKrxData;

import java.util.Map;

@Controller
@RequestMapping("/stock")
public class StockController {

	// @RequestParam String code, 
	@GetMapping("/market/data.do")
	public String view(Model model) {
		String code = "035720";
//		Map<String, Object> map = getKrxData(code);
//		String[] stockInfoData = (String[]) map.get("stockInfoData");
//		System.out.println(stockInfoData[0]);
		model.addAttribute("krxData", getKrxData(code));
		return "stock/view";
	}
	
}
