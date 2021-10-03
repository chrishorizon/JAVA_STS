package com.horizon.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/")
	public String index(@RequestParam(value="name", required=false) String searchQuery, @RequestParam(value="last_name", required=false) String lastName) {
		if( searchQuery == null) {
			return "Hello Human";
		} else if(lastName == null) {
			return "Hello " + searchQuery;
		} else {
			return "Hello " + searchQuery + " " + lastName;
		}
	}

}
