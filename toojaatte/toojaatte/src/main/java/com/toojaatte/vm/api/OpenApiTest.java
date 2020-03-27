package com.toojaatte.vm.api;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class OpenApiTest {
	
	public static String VmAPI() {
		BufferedReader br = null;
		String result = "";
		try {
			
			String urlstr = "https://api.bithumb.com/public/ticker/ALL_KRW";
			
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection)url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
			String line;
			
			while((line = br.readLine())!=null) {
				result = result + line;	
			}
//			System.out.println(result);
            
			JSONParser jsonParser = new JSONParser();
            
            //JSON데이터를 넣어 JSON Object 로 만들어 준다.
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
//            System.out.println(jsonObject);
            	  
            
            JSONObject data = (JSONObject) jsonObject.get("data");
            
            String[] coinName = {"BTC", "ETH", "DASH", "LTC", "ETC", 
            					"XRP", "BCH", "XMR", "ZEC", "QTUM", "BTG", 
            					"EOS", "ICX", "VET", "TRX", "ELF", "MITH", 
            					"MCO", "OMG", "KNC", "GNT", "HSR", "ZIL", 
            					"ETHOS", "PAY", "WAX", "POWR", "LRC", "GTO", 
            					"STEEM", "STRAT", "ZRX", "REP", "AE", "XEM", 
            					"SNT", "ADA", "PPT", "CTXC", "CMT", "THETA", 
            					"WTC", "ITC", "TRUE", "ABT", "RNT", "PLY", 
            					"WAVES","LINK", "ENJ", "PST"};
            
            String[] content = {"opening_price","closing_price",
            					"max_price","min_price"};
         
            
            for (int i = 0; i < coinName.length; i++) {
	            JSONObject coins = (JSONObject) data.get(coinName[i]);
	            	System.out.println(coins);
	            		double opening_p = (double) coins.get("opening_price");
	            		double closing_p = (double) coins.get("closing_price");
	            		double max_p = (double) coins.get("max_price");
	            		double min_p = (double) coins.get("min_price");
	            		System.out.println("시가 == " + opening_p);
	            		System.out.println("종가 == " + closing_p);
	            		System.out.println("시가 == " + max_p);
	            		System.out.println("시가 == " + min_p);
	            		
//	            	for(String c : content) {
//	            		System.out.println(coins.get("opening_price"));
//	            	}

            }
            
//            for (int l = 0; l < content.length; l++) {
//            	JSONObject contents = (JSONObject) coins.get(content[l]);
//            	System.out.println("******"+contents);
//            }
            
           
  
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	 
}
