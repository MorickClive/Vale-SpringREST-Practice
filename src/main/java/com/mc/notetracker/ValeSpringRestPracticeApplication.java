package com.mc.notetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ValeSpringRestPracticeApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ValeSpringRestPracticeApplication.class, args);
		
		System.out.format("Result: %s\n", context.getBean("getSysTime", String.class));
	}

}
