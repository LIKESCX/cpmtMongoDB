package com.example.demo.main;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableMongoRepositories("com.example.demo.dao")
@ComponentScan(basePackages = {"com.example"})
public class CpmtMongoDbApplication {
	private final static Logger logger = LoggerFactory.getLogger(CpmtMongoDbApplication.class);
	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "true");//开启热部署
		SpringApplication app = new SpringApplication(CpmtMongoDbApplication.class);
		app.setBannerMode(Banner.Mode.OFF);//去掉打印spring图标
		app.run(args);
		logger.info("start cpmt-mongodb....");
	}

}
