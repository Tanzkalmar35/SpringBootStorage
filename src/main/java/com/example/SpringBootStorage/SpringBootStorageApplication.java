package com.example.SpringBootStorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStorageApplication.class, args);
	}

}
