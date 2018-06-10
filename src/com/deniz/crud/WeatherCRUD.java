package com.deniz.crud;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Map;

import org.json.JSONObject;

import com.deniz.controller.WeatherController;

public class WeatherCRUD {
	
	
	public static ArrayList<WeatherController> sehirHavaDurumuCek(String sehir)
	{
		String urlApi ="http://api.apixu.com/v1/current.json?key=41f17e6e539444eb984154332180906&q="+sehir;
		try
		{
		URL myURl = new URL(urlApi);
		URLConnection myConn = myURl.openConnection();
		
		InputStream in =myConn.getInputStream();
		
		StringBuffer sb = new StringBuffer();
		int gelen = in.read();
		while(gelen!=-1)
		{
			sb.append((char)gelen);
			gelen = in.read();
		}
		
		
		JSONObject json = new JSONObject(sb.toString());
		
		JSONObject location = new JSONObject(json.get("location").toString());
		JSONObject current = new JSONObject(json.get("current").toString());
		JSONObject condition = new JSONObject(current.get("condition").toString());
		
		
		Map<String, Object> mapLocation = location.toMap();
		Map<String, Object> currentLocation = current.toMap();
		Map<String, Object> conditionLocation = condition.toMap();
		
		WeatherController hava = new WeatherController();
		
		hava.setSehirAdi(mapLocation.get("name").toString());
		hava.setSehirUlkesi(mapLocation.get("country").toString());
		hava.setSehirEnlem(mapLocation.get("lat").toString());
		hava.setSehirBoylam(mapLocation.get("lon").toString());
		hava.setSehirKonum(mapLocation.get("tz_id").toString());
		hava.setSehirLocalSaat(mapLocation.get("localtime").toString());
		hava.setSehirSonGuncelleme(currentLocation.get("last_updated").toString());
		hava.setSehirSicaklik(currentLocation.get("temp_c").toString());
		hava.setSehirHavaDurumu(conditionLocation.get("text").toString());
		hava.setSehirHavaIcon(conditionLocation.get("icon").toString());
		hava.setSehirRuzgarHizi(currentLocation.get("wind_kph").toString());
		hava.setSehirNemOrani(currentLocation.get("humidity").toString());
		
		ArrayList<WeatherController> list = new ArrayList<WeatherController>();
		list.add(hava);
 
		return list; 
		
		}catch (Exception e) {
		return null;
		}finally {
			
		}
	}
	

}
