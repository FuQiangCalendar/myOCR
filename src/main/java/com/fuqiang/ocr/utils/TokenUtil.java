 
package com.fuqiang.ocr.utils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.fuqiang.ocr.config.BaiduOCRConfig;
 
/**
 * @author XXX
 *
 */
public class TokenUtil {
	
	public static final String APP_ID = "********";  //你创建应用中的APP_ID               
	public static final String API_KEY = "**********"; //你创建应用中的API_KEY
	public static final String SECRET_KEY = "**********";//你创建应用中的SECRET_KEY
	
	public static String getToken(String apiKey, String secretKey) {
		String token_url = "https://aip.baidubce.com/oauth/2.0/token?";   
         //百度API中可以找到这个路径
		String path = token_url + "grant_type=client_credentials&" + "client_id=" + apiKey + "&client_secret="
				+ secretKey;
		StringBuffer sbf = new StringBuffer();
		try {
			URL url = new URL(path);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.connect();
			InputStream is = connection.getInputStream();	
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			if ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
			}
			reader.close();
			String json = sbf.toString();
			JSONObject jsStr = JSONObject.parseObject(json);
			String token = jsStr.get("access_token").toString();
			return token;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}