package com.horizon.firstproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class HomeController {
	@RequestMapping("")
	public String index() {
		return "This is access view  http://your_server/simple/root";
	}
	
	// 1. Annotation
	@RequestMapping("/hello")
	// 3. Method that maps to the request route above
	public String hello() {
		return "Hello World!";
	}
	
	@RequestMapping("/goodbye")
	public String world() {
		return "Class level annotations are cool too!";
	}
}
