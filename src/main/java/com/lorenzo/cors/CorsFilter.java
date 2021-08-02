package com.lorenzo.cors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CorsFilter extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CorsFilter.class, args);

	}

}
