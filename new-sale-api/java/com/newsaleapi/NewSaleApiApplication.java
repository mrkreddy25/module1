package com.newsaleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = { "com.newsaleapi", "com.newsaleapi.client" })
@Configuration
public class NewSaleApiApplication {

	@Bean
	public RestTemplate getRestResponse() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(NewSaleApiApplication.class, args);
	}

}
