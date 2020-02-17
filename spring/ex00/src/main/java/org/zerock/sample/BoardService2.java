package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.Setter;

@Data
@Service
public class BoardService2 {
	
	@Setter(onMethod_ = {@Autowired})
	private BoardDAO boardDAO;
}
