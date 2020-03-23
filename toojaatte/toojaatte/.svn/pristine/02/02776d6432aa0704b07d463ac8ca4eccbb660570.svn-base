package com.toojaatte.news.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import com.toojaatte.news.dto.NewsDTO;
import com.toojaatte.news.mapper.NewsMapper;
import com.toojaatte.util.page.PageObject;

@Service
public class NewsService {

	@Inject
	private NewsMapper mapper;

	public int insert(List<NewsDTO> list) {
		for(int i=0; i<list.size(); i++) {
			mapper.insert(list.get(i));	
			System.out.println("NewsService.insert().list.get(i)"+list.get(i));
		}return 1;
	}

	public List<NewsDTO> list(PageObject pageObject) {
		//넘어온 페이지의 rnum startpage, endpage구하기(기본 1부터셋팅됨)
		pageObject.calcuPageInfo();
		//데이터개수셋팅
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		
		List<NewsDTO> dto = mapper.list(pageObject);
		return dto;
	}

	//사이드바-많이본 뉴스
	public List<NewsDTO> mostViewed(){
		return mapper.mostViewed();
	}

	public NewsDTO view(int nno) {
		mapper.increaseHit(nno);
		return mapper.view(nno);
	}
	


}
