package com.toojaatte.news.mapper;

import java.util.List;

import com.toojaatte.news.dto.NewsDTO;
import com.toojaatte.util.page.PageObject;

public interface NewsMapper {

	public int insert(NewsDTO dto);

	public List<NewsDTO> list(PageObject pageObject);
	public int getTotalRow(PageObject pageObject);

	public NewsDTO view(int nno);
	public void increaseHit(int nno);
	
	//많이본뉴스
	public List<NewsDTO> mostViewed();



}
