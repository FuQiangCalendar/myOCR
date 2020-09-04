package com.fuqiang.ocr.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName:	BaiduOCRConfig
 * @Description: 百度OCR，授权码
 * @author:	FuQiang
 * @date:	2020年9月3日 下午4:04:26
 */
@Component
@Configuration
@Getter
public class BaiduOCRConfig {
	@Value("${ocr.baiduOCR.appId}")
	public String appId;
	
	@Value("${ocr.baiduOCR.apiKey}")
	public String apiKey;
	
	@Value("${ocr.baiduOCR.secretKey}")
	public String secretKey;
}
