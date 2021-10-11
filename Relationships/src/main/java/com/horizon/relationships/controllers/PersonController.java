package com.horizon.relationships.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.horizon.relationships.models.Person;
import com.horizon.relationships.services.PersonService;

@Controller
public class PersonController {
	
	@Autowired
	PersonService serv;
	
	// ==== Display =================
	
	@GetMapping("/persons/{person_id}")
	public String showPerson(@PathVariable Long person_id, Model model) {
	    
	    Person someAwesomePerson = serv.onePerson(person_id);
	    model.addAttribute("person", someAwesomePerson);
	    
	    return "showPerson.jsp";
	}

	// ==== Action ============

}
