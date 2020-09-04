package com.fuqiang.ocr.tesseract;
import java.net.URLEncoder;

import com.fuqiang.ocr.utils.Base64Util;
import com.fuqiang.ocr.utils.FileUtil;
import com.fuqiang.ocr.utils.HttpUtil;
import com.fuqiang.ocr.utils.TokenUtil;
/**
 * @author XXX
 * 1.获取token 
 * 2.获取字符串文件图片
 * 3.图片转Base64
 * 4.发送http请求
 */
public class BaiDuOCRTest {
	public static final String APP_ID = "*****";  //你创建应用中的APP_ID               
	public static final String API_KEY = "*******"; //你创建应用中的API_KEY
	public static final String SECRET_KEY = "********";//你创建应用中的SECRET_KEY
	
	 public static void main(String[] args) {
		 	// 通用标准
//		 	String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic";
	        // 通用标准 +位置
//	        String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/general";
	        //通用高精度
//	        String otherHost= "https://aip.baidubce.com/rest/2.0/ocr/v1/accurate_basic";
		 	////通用高精度+位置
//		 	String otherHost= "https://aip.baidubce.com/rest/2.0/ocr/v1/accurate";
		 	//网络图片含位置版
		 	String otherHost= "https://aip.baidubce.com/rest/2.0/ocr/v1/webimage_loc";
		 	//增值税发票识别
//		 	String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/vat_invoice";
	        // 本地图片路径
	        String filePath = "E:\\tools\\Tesseract-OCR\\tessdata\\temp\\img\\喝红酒.jpg";
//	        String filePath = "E:\\tools\\Tesseract-OCR\\tessdata\\temp\\img\\发票\\发票.jpg"; //降噪
//	        String filePath = "E:\\tools\\Tesseract-OCR\\tessdata\\temp\\img\\ocr1.png";
//	        String filePath = "E:\\tools\\Tesseract-OCR\\tessdata\\temp\\img\\noise\\ocr1.jpg";
	        
	        String token = TokenUtil.getToken(API_KEY, SECRET_KEY);
	        try {
	            byte[] imgData = FileUtil.readFileByBytes(filePath);
	            String imgStr = Base64Util.encode(imgData);
	            String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
	            /**
	             * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
	             */
	            String accessToken = token;
	            String result = HttpUtil.post(otherHost, accessToken, params);
	            System.out.println(result);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
 
}