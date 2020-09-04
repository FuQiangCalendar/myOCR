package com.fuqiang.ocr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config implements WebMvcConfigurer{
	
	//swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
	  @Bean
	  public Docket createRestApi() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        .apiInfo(apiInfo())
	        .select()
	        .apis(RequestHandlerSelectors.basePackage("com.fuqiang.ocr.controller"))
	        .paths(PathSelectors.any())
	        .build();
	  }

	  // 构建api文档的详细信息
	  private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	        // 页面标题
	        .title("OCR扫描使用Swagger2构建RESTful APIs")
	        // 创建人
	        .contact(new Contact("lasdaybg", "", ""))
	        // 版本号
	        .version("1.0")
	        // 描述
	        .description("OCR扫描API")
	        .build();
	  }
	  
	  @Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
	      registry.addResourceHandler("swagger-ui.html")
	              .addResourceLocations("classpath:/META-INF/resources/");

	      registry.addResourceHandler("/webjars/**")
	              .addResourceLocations("classpath:/META-INF/resources/webjars/");
	  }
}
