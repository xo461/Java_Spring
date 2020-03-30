package com.toojaatte.news.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.toojaatte.news.dto.NewsDTO;
import com.toojaatte.stock.dto.MarketIndexDTO;
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
		//System.out.println("JsonRead.newsJsonRead.today():"+today);

		try (Reader reader = new FileReader("D:\\study\\ml\\korea_news_crawler\\crawled\\news"+today+".json")) {

			NewsDTO[] array = gson.fromJson(reader, NewsDTO[].class);
			list = Arrays.asList(array);
			//System.out.println(list);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;

	}

	
	public static List<MarketIndexDTO> kospiJsonRead() {
		
		Gson gson = new Gson();
		List<MarketIndexDTO> list = null;
		
		try (Reader reader = new FileReader("D:\\study\\ml\\korea_news_crawler\\crawled\\kospi.json")) {
//			try (Reader reader = new FileReader("C:\\Users\\Admin\\Documents\\GitHub\\Java_Spring\\toojaatte\\toojaatte\\src\\main\\webapp\\upload\\crawlingtest\\kospi.json")) {
			//원하는 데이터: jsonobject 안에 data안에 array로 있음.
			//jsonobject로 받아서 jsonarray 꺼내서 dto에 맞는 array로 바꾸고 list로 바꿔줌
			JsonObject object = gson.fromJson(reader, JsonObject.class);
			JsonArray jsonArray = (JsonArray) object.get("data");
			MarketIndexDTO[] dtoArray = gson.fromJson(jsonArray, MarketIndexDTO[].class);
			list = Arrays.asList(dtoArray);
			
			//그냥 가져올시 날짜 오래된순이기 때문에 최신순으로 재정렬해준다.
			Collections.sort(list, new Datedesc());
			for (MarketIndexDTO item : list) {
				//System.out.println(item.toString());
			}
			//System.out.println("JsonRead.kospiJsonRead(): "+list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}


	public static List<MarketIndexDTO> kospi200JsonRead() {
		
		Gson gson = new Gson();
		List<MarketIndexDTO> list = null;
		
		try (Reader reader = new FileReader("D:\\study\\ml\\korea_news_crawler\\crawled\\kospi200.json")) {
//			try (Reader reader = new FileReader("C:\\Users\\Admin\\Documents\\GitHub\\Java_Spring\\toojaatte\\toojaatte\\src\\main\\webapp\\upload\\crawlingtest\\kospi200.json")) {
			//원하는 데이터: jsonobject 안에 data안에 array로 있음.
			//jsonobject로 받아서 jsonarray 꺼내서 dto에 맞는 array로 바꾸고 list로 바꿔줌
			JsonObject object = gson.fromJson(reader, JsonObject.class);
			JsonArray jsonArray = (JsonArray) object.get("data");
			MarketIndexDTO[] dtoArray = gson.fromJson(jsonArray, MarketIndexDTO[].class);
			list = Arrays.asList(dtoArray);
			
			//그냥 가져올시 날짜 오래된순이기 때문에 최신순으로 재정렬해준다.
			Collections.sort(list, new Datedesc());
			for (MarketIndexDTO item : list) {
				//System.out.println(item.toString());
			}
			//System.out.println("JsonRead.kospi200JsonRead(): "+list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}


	public static List<MarketIndexDTO> kosdaqJsonRead() {
		
		Gson gson = new Gson();
		List<MarketIndexDTO> list = null;
		
		try (Reader reader = new FileReader("D:\\study\\ml\\korea_news_crawler\\crawled\\kosdaq.json")) {
//			try (Reader reader = new FileReader("C:\\Users\\Admin\\Documents\\GitHub\\Java_Spring\\toojaatte\\toojaatte\\src\\main\\webapp\\upload\\crawlingtest\\kosdaq.json")) {
			//원하는 데이터: jsonobject 안에 data안에 array로 있음.
			//jsonobject로 받아서 jsonarray 꺼내서 dto에 맞는 array로 바꾸고 list로 바꿔줌
			JsonObject object = gson.fromJson(reader, JsonObject.class);
			JsonArray jsonArray = (JsonArray) object.get("data");
			MarketIndexDTO[] dtoArray = gson.fromJson(jsonArray, MarketIndexDTO[].class);
			list = Arrays.asList(dtoArray);
			
			//그냥 가져올시 날짜 오래된순이기 때문에 최신순으로 재정렬해준다.
			Collections.sort(list, new Datedesc());
			for (MarketIndexDTO item : list) {
				//System.out.println(item.toString());
			}
			//System.out.println("JsonRead.kosdaqJsonRead(): "+list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}


	public static List<MarketIndexDTO> usdkrwJsonRead() {
		
		Gson gson = new Gson();
		List<MarketIndexDTO> list = null;
		
		try (Reader reader = new FileReader("D:\\study\\ml\\korea_news_crawler\\crawled\\usdkrw.json")) {
		//	try (Reader reader = new FileReader("C:\\Users\\Admin\\Documents\\GitHub\\Java_Spring\\toojaatte\\toojaatte\\src\\main\\webapp\\upload\\crawlingtest\\usdkrw.json")) {
			//원하는 데이터: jsonobject 안에 data안에 array로 있음.
			//jsonobject로 받아서 jsonarray 꺼내서 dto에 맞는 array로 바꾸고 list로 바꿔줌
			JsonObject object = gson.fromJson(reader, JsonObject.class);
			JsonArray jsonArray = (JsonArray) object.get("data");
			MarketIndexDTO[] dtoArray = gson.fromJson(jsonArray, MarketIndexDTO[].class);
			list = Arrays.asList(dtoArray);
			
			//그냥 가져올시 날짜 오래된순이기 때문에 최신순으로 재정렬해준다.
			Collections.sort(list, new Datedesc());
			for (MarketIndexDTO item : list) {
				//System.out.println(item.toString());
			}
			//System.out.println("JsonRead.kosdaqJsonRead(): "+list);
			
			//데이터 형 변환
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}


	public static List<MarketIndexDTO> cnykrwJsonRead() {
		
		Gson gson = new Gson();
		List<MarketIndexDTO> list = null;
		
		try (Reader reader = new FileReader("D:\\study\\ml\\korea_news_crawler\\crawled\\cnykrw.json")) {
//			try (Reader reader = new FileReader("C:\\Users\\Admin\\Documents\\GitHub\\Java_Spring\\toojaatte\\toojaatte\\src\\main\\webapp\\upload\\crawlingtest\\cnykrw.json")) {
			//원하는 데이터: jsonobject 안에 data안에 array로 있음.
			//jsonobject로 받아서 jsonarray 꺼내서 dto에 맞는 array로 바꾸고 list로 바꿔줌
			JsonObject object = gson.fromJson(reader, JsonObject.class);
			JsonArray jsonArray = (JsonArray) object.get("data");
			MarketIndexDTO[] dtoArray = gson.fromJson(jsonArray, MarketIndexDTO[].class);
			list = Arrays.asList(dtoArray);
			
			//그냥 가져올시 날짜 오래된순이기 때문에 최신순으로 재정렬해준다.
			Collections.sort(list, new Datedesc());
			for (MarketIndexDTO item : list) {
				//System.out.println(item.toString());
			}
			//System.out.println("JsonRead.kosdaqJsonRead(): "+list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}



	public static List<MarketIndexDTO> jpykrwJsonRead() {
		
		Gson gson = new Gson();
		List<MarketIndexDTO> list = null;
		
		try (Reader reader = new FileReader("D:\\study\\ml\\korea_news_crawler\\crawled\\jpykrw.json")) {
//			try (Reader reader = new FileReader("C:\\Users\\Admin\\Documents\\GitHub\\Java_Spring\\toojaatte\\toojaatte\\src\\main\\webapp\\upload\\crawlingtest\\jpykrw.json")) {
			//원하는 데이터: jsonobject 안에 data안에 array로 있음.
			//jsonobject로 받아서 jsonarray 꺼내서 dto에 맞는 array로 바꾸고 list로 바꿔줌
			JsonObject object = gson.fromJson(reader, JsonObject.class);
			JsonArray jsonArray = (JsonArray) object.get("data");
			MarketIndexDTO[] dtoArray = gson.fromJson(jsonArray, MarketIndexDTO[].class);
			list = Arrays.asList(dtoArray);
			
			//그냥 가져올시 날짜 오래된순이기 때문에 최신순으로 재정렬해준다.
			Collections.sort(list, new Datedesc());
			for (MarketIndexDTO item : list) {
				//System.out.println(item.toString());
			}
			//System.out.println("JsonRead.kosdaqJsonRead(): "+list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

}

	//날짜를 비교해서 재정렬(마켓인덱스용)
	class Datedesc implements Comparator<MarketIndexDTO>{

	@Override
	public int compare(MarketIndexDTO o1, MarketIndexDTO o2) {
		// TODO Auto-generated method stub
		//a.compareTo(b) 의 경우 a가 크다면 1을 반환하고 b가 크다면 -1, 같다면 0을 반환한다.
		return o2.getDate().compareTo(o1.getDate());
	}
	
	//날짜를 비교해서 재정렬(뉴스용)
	class Datedesc2 implements Comparator<StockDTO>{

	@Override
	public int compare(StockDTO o1, StockDTO o2) {
		// TODO Auto-generated method stub
		//a.compareTo(b) 의 경우 a가 크다면 1을 반환하고 b가 크다면 -1, 같다면 0을 반환한다.
		return o2.getDate().compareTo(o1.getDate());
	}
}
	}



