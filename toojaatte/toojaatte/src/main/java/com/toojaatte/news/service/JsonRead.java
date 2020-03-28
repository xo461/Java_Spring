package com.toojaatte.news.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.logging.SimpleFormatter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.toojaatte.news.dto.NewsDTO;
import com.toojaatte.stock.dto.StockDTO;

//gson라이브러리 다운 or dependency추가 필수
public class JsonRead {
	
	public static List<NewsDTO> newsJsonRead() {
		// 객체생성
		Gson gson = new Gson();
		List<NewsDTO> list = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c1 = Calendar.getInstance();
		String today = sdf.format(c1.getTime());
		System.out.println("JsonRead.newsJsonRead.today():"+today);

		try (Reader reader = new FileReader("D:\\study\\ml\\korea_news_crawler\\crawled\\news"+today+".json")) {

			NewsDTO[] array = gson.fromJson(reader, NewsDTO[].class);
			list = Arrays.asList(array);
			//System.out.println(list);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;

	}

	
	public static List<StockDTO> kospiJsonRead() {
		
		Gson gson = new Gson();
		List<StockDTO> list = null;
		
		try (Reader reader = new FileReader("D:\\study\\ml\\korea_news_crawler\\crawled\\kospi.json")) {
			//원하는 데이터: jsonobject 안에 data안에 array로 있음.
			//jsonobject로 받아서 jsonarray 꺼내서 dto에 맞는 array로 바꾸고 list로 바꿔줌
			JsonObject object = gson.fromJson(reader, JsonObject.class);
			JsonArray jsonArray = (JsonArray) object.get("data");
			StockDTO[] dtoArray = gson.fromJson(jsonArray, StockDTO[].class);
			list = Arrays.asList(dtoArray);
			System.out.println("JsonRead.kospiJsonRead(): "+list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		return list;
	}
}
