package com.horizon.relationships.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.horizon.relationships.models.License;
import com.horizon.relationships.services.LicenseService;

@Controller
public class LicenseController {
	
	@Autowired
	LicenseService serv;
	
	@GetMapping("/licenses/new")
	public String newLicense() {
		return "license.jsp";
	}
	
	@PostMapping("/licenses")
	public String licenses(@Valid @ModelAttribute("license") License license) {
	    // error handling with binding result omitted    
	    serv.createLicense(license); // Already has the person!
	        
	    return "redirect:/persons";
	}

}
