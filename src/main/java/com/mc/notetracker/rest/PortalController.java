package com.mc.notetracker.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortalController {
	
	@RequestMapping(value = "/greet", method = RequestMethod.GET )
	public String greet() {
		return "Hello World!";
	}

}
