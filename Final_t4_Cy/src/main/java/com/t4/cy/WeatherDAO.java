package com.t4.cy;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

@Service
public class WeatherDAO {
	
	/*  dependency 추가

	<dependency>
  	<groupId>com.googlecode.json-simple</groupId>
  	<artifactId>json-simple</artifactId>
  	<version>1.1</version>
    </dependency>
  
	 */
	
	public void getWeatherByLocation(HttpServletRequest req) {
		
		HttpURLConnection huc = null;
		String lat = req.getParameter("lat");
		String lon = req.getParameter("lon");

		try {
			String url = "https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=e7b1a57cd2158c8d195bfb24b7597bad";
			URL u;
			u = new URL(url);
			huc = (HttpURLConnection) u.openConnection();
			
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			JSONParser jp = new JSONParser();
			JSONObject weatherData = (JSONObject) jp.parse(isr);
//			System.out.println(weatherData);
			
			JSONArray w = (JSONArray) weatherData.get("weather");
			JSONObject w2 = (JSONObject) w.get(0);
			
			req.getSession().setAttribute("weatherLat", lat);
			req.getSession().setAttribute("weatherLon", lon);
			req.getSession().setAttribute("weatherIcon", w2.get("icon"));
			req.getSession().setMaxInactiveInterval(60*60);//60분 세션 유지
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r","날씨 불러오기 실패!");
		}

	}
	


	public void getWeatherDefault(HttpServletRequest req) {
		HttpURLConnection huc = null;
		String lat = "-33.836024526801246";
		String lon = "151.20617143625608"; //시드니위치
		
		try {
			String url = "https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=e7b1a57cd2158c8d195bfb24b7597bad";
			URL u;
			u = new URL(url);
			huc = (HttpURLConnection) u.openConnection();
			
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			
			JSONParser jp = new JSONParser();
			JSONObject weatherData = (JSONObject) jp.parse(isr);
//			System.out.println(weatherData);
			
			JSONArray w = (JSONArray) weatherData.get("weather");
			JSONObject w2 = (JSONObject) w.get(0);
			
			req.getSession().setAttribute("weatherLat", lat);
			req.getSession().setAttribute("weatherLon", lon);
			req.getSession().setAttribute("weatherIcon", w2.get("icon"));
			req.getSession().setMaxInactiveInterval(60*60);//10분 세션 유지
			
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r","날씨 불러오기 실패!");
		}
		
		}
		
	}
	

