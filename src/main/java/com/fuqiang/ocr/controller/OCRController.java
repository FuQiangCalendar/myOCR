package com.fuqiang.ocr.controller;

import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fuqiang.ocr.config.BaiduOCRConfig;
import com.fuqiang.ocr.utils.Base64Util;
import com.fuqiang.ocr.utils.FileUtil;
import com.fuqiang.ocr.utils.HttpUtil;
import com.fuqiang.ocr.utils.TokenUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/ocr")
@Api(value = "OCR扫描入口", tags = "OCR扫描入口")
public class OCRController {
	
	@Autowired
	private BaiduOCRConfig baiduOCRConfig;
	
	@PostMapping("/baiduOCR")
	@ApiOperation(value = "执行OCR扫描", notes = "执行OCR扫描")
	public String baiduOCR (MultipartFile file) {
        // 通用标准 +位置
        String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/general";
//		String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/vat_invoice";
        String token = TokenUtil.getToken(baiduOCRConfig.apiKey, baiduOCRConfig.secretKey);
        String result = null;
        try {
            byte[] imgData = FileUtil.readFileByBytes(file);
            String imgStr = Base64Util.encode(imgData);
            String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
            /**
             * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
             */
            String accessToken = token;
            result = HttpUtil.post(otherHost, accessToken, params);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return result;
	}
}
