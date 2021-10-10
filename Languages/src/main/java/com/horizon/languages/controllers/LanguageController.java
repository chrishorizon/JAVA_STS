package com.horizon.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
	
	// Renders all on home page
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
	
	// Show one to edit
	@GetMapping("/languages/edit/{id}")
	public String editLang(@PathVariable("id") Long id, Model model) {
		Language lang = serv.oneLanguage(id);
		model.addAttribute("lange", lang);
		return "edit.jsp";
	}
	
	// Renders one in Show page
	@GetMapping("/languages/{id}")
	public String showLang(@PathVariable("id") Long id, Model model) {
		Language lang = serv.oneLanguage(id);
		model.addAttribute("langs", lang);
		return "show.jsp";
	}
	
	// ===================== Action ===================
	
	// Create one
	@PostMapping("/languages")
	public String createLang(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Language> lang = serv.allLanguages();
			model.addAttribute("language", lang);
			return "index.jsp";
		} else {
			serv.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	// Delete one
	@DeleteMapping("/languages/{id}")
	public String deleteLang(@PathVariable("id") Long id) {
		serv.deleteLanguage(id);
		return "redirect:/languages";
	}
	
	// Update one
	@PutMapping("/languages/{id}")
	public String updateLang(@Valid @ModelAttribute("language") Language lan, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			serv.createLanguage(lan);
			return "redirect:/languages";
		}
	}

}
