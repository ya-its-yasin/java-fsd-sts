package com.tcs.bootrestclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Day13BootRestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day13BootRestClientApplication.class, args);
		
		
	}
	
	@Bean
	public RestTemplate build()
	{
		return new RestTemplate();
	}

}
