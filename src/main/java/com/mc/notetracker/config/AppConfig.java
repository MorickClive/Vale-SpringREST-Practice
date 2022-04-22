package com.mc.notetracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public String helloWorld() {
		return "Hello World";
	}

}
