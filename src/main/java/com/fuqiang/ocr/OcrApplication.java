package com.fuqiang.ocr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

//一般你启动springboot项目，都会写一个有@SpringBootApplication注解的类
//你在这个注解中添加exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class}
//即可无数据库运行
//如下

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
//@SpringBootApplication
@ComponentScan("com.fuqiang.ocr")
@ServletComponentScan
public class OcrApplication {

	public static void main(String[] args) {
		SpringApplication.run(OcrApplication.class, args);
	}

}
