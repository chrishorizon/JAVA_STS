package com.horizon.languages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.horizon.languages.models.Language;
import com.horizon.languages.services.LanguageService;

@Controller
public class LanguageController {
	
	@Autowired
	private LanguageService serv;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/languages";
	}
	
	// ==== Display =================
	
	@GetMapping("/languages")
	// Model model sends the data to the JSP
	public String home(@ModelAttribute("language") Language language, Model model) {
		// Go through service to get all books and assign it to a variable
		// List is the data type
		List<Language> lang = serv.allLanguages();
		
		// key value pair, "languages" can be named what you want and plural
		// language is the value name for the array list created
		model.addAttribute("languages", lang);
		return "index.jsp";
	}	
	

	// ==== Action ============
	

}
