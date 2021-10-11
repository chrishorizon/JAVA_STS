package com.horizon.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.horizon.dojosandninjas.models.Dojo;
import com.horizon.dojosandninjas.services.DojoService;

@Controller
public class DojoController {
	
	@Autowired
	DojoService serv;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dojos/new";
	}
	
	// ==== Display =================
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo, Model model) {
		List<Dojo> dojos = serv.allDojos();
		model.addAttribute("dj", dojos);
		return "new_dojo.jsp";
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = serv.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "show_dojo.jsp";
	}

	// ==== Action ============
	
	@PostMapping("/dojos")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "new_dojo.jsp";
		} else {
			serv.createDojo(dojo);
			return "redirect:/";
		}
	}

}
