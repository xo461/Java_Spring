package com.toojaatte.news.dto;

import lombok.Data;

@Data
public class NewsDTO {
	private long no;
	private String url, press, title, write_date, content;
}
