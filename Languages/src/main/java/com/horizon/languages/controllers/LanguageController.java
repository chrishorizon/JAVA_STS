package com.horizon.languages.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.horizon.languages.services.LanguageService;

@Controller
public class LanguageController {
	
	@Autowired
	private LanguageService serv;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/languages";
	}
	
	@GetMapping("/languages")
	public String home() {
		return "index.jsp";
	}
	
	// ==== Display =================
	

	// ==== Action ============

}
