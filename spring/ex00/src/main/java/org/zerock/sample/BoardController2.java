package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.Data;
import lombok.Setter;

@Controller
@Data
public class BoardController2 {
	
	@Setter(onMethod_ = {@Autowired})
	private BoardService boardService;
}
