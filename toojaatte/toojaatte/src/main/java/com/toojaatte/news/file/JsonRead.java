package com.toojaatte.news.file;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.toojaatte.news.dto.NewsDTO;

//gson라이브러리 다운 or dependency추가 필수
public class JsonRead {

	public static List<NewsDTO> jsonRead() {
		// 객체생성
		Gson gson = new Gson();
		List<NewsDTO> list = null;
		try (Reader reader = new FileReader("D:\\study\\ml\\korea_news_crawler\\news.json")) {

			NewsDTO[] array = gson.fromJson(reader, NewsDTO[].class);
			list = Arrays.asList(array);

			//System.out.println(list);

			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;

	}
}
