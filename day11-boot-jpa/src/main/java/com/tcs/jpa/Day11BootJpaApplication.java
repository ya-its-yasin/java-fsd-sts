package com.tcs.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day11BootJpaApplication implements CommandLineRunner{

	@Autowired
	ProductRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(Day11BootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Product p1 = new Product();
		p1.setDescription("A digital TV");
		p1.setPrice(75000);
		
		repo.save(p1);
		
	}

}
