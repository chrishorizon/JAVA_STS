package com.horizon.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.horizon.dojosandninjas.models.Dojo;
import com.horizon.dojosandninjas.models.Ninja;
import com.horizon.dojosandninjas.services.DojoService;
import com.horizon.dojosandninjas.services.NinjaService;

@Controller
public class NinjaController {
	
	@Autowired
	DojoService dojoServ;
	
	@Autowired
	NinjaService ninjaServ;
	
	// ==== Display =================
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> allDojos = dojoServ.allDojos();
		model.addAttribute("dojos", allDojos);
		return "new_ninja.jsp";
	}

	// ==== Action ============
	
	@PostMapping("/ninjas")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Dojo> allDojos = dojoServ.allDojos();
			model.addAttribute("dojos", allDojos);
			return "new_ninja.jsp";
		} else {
			ninjaServ.createNinja(ninja);
			return "redirect:/";
		}
	}

}
