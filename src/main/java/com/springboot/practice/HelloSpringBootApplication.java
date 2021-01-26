package com.springboot.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.practice.init.InitializeData;


@SpringBootApplication
public class HelloSpringBootApplication{
	
	public static void main(String[] args) throws Exception {
		//InitializeData initializeData = new InitializeData();
		 // SpringApplication.run(HelloSpringBootApplication.class, args);
		SpringApplication.run(new Class[]{HelloSpringBootApplication.class, InitializeData.class}, args);
		//initializeData.run(args);
	}

	
	

}
