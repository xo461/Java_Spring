package com.toojaatte.vm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.toojaatte.vm.api.OpenApiTest;

import static com.toojaatte.util.stock.GetStockData.getKrxData;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Map;

@Controller
@RequestMapping("/vm")
public class VmController {

	private OpenApiTest openapi;
	// @RequestParam String code, 
	@GetMapping("/view.do")
	public String view(Model model) {
		model.addAttribute("vmdata",openapi.VmAPI());
		return "vm/view";
	}
	
}
