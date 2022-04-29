package com.mc.notetracker.config;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mc.notetracker.util.ModelUtility;

@Configuration
public class AppConfig {
	
	@Bean
	public String helloWorld() {
		return "Hello World";
	}
	
	@Bean
	public String getSysTime() {
		return Stream.of(LocalDateTime.now().toString()
				.split("T"))
				.reduce((x, y) -> String.format("\n\tDate: %s\n\tTime: %s", x,y)).orElseThrow();
	}
	
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
	
	@Bean
	public ModelUtility mUtil() {
		return new ModelUtility();
	}

}
