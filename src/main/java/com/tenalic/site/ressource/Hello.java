package com.tenalic.site.ressource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello {

	@GetMapping("/")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/bye")
	public String bye() {
		return "bye";
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}

}
