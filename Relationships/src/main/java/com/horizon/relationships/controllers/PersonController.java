package com.horizon.relationships.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.horizon.relationships.models.License;
import com.horizon.relationships.models.Person;
import com.horizon.relationships.services.PersonService;

@Controller
public class PersonController {
	
	@Autowired
	PersonService serv;
	
	// ==== Display =================
	
	@GetMapping("/")
	public String index() {
		return "redirect:/persons/new";
	}
	
	@GetMapping("/persons/new")
	public String newPerson() {
		return "person.jsp";
	}
	
	@GetMapping("/persons/{person_id}")
	public String showPerson(@PathVariable Long person_id, Model model) {
	    
	    Person someAwesomePerson = serv.onePerson(person_id);
	    model.addAttribute("persons", someAwesomePerson);
	    
	    return "showPerson.jsp";
	}

	// ==== Action ============
	

}
