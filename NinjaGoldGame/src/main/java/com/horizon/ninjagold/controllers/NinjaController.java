package com.horizon.ninjagold.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaController {
	
	@GetMapping("/")
	public String index() {		
		return "redirect:/Gold";
	}
	
	@GetMapping("/Gold")
	public String home(HttpSession session, Model model) {
		if(session.getAttribute("messages") == null) {
			session.setAttribute("messages", new ArrayList<String>());
		}
		if(session.getAttribute("messages") != null) {
			model.addAttribute("messages", session.getAttribute("message"));
		}
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		
		Integer allGold = (Integer) session.getAttribute("gold");
		model.addAttribute("gold", allGold);
		
		return "index.jsp";
	}
	
	@PostMapping("/process")
	public String process(@RequestParam(value="find") String find, HttpSession session) {
		Integer gold = (Integer) session.getAttribute("gold");
		ArrayList<String> messages = (ArrayList<String>) session.getAttribute("messages");
		
		Random rand = new Random();
		Date now = new Date();
		
		if (find.equals("cave")) {
			int newGold = (rand.nextInt(6)+5);
			gold += newGold;
			session.setAttribute("gold", gold);
			messages.add("" +now + ": Went to the cave, got " + newGold + " gold");
		}
		
		if (find.equals("farm")) {
			int newGold = (rand.nextInt(11)+10);
			gold += newGold;
			session.setAttribute("gold", gold);
			messages.add("" +now + ": Went to the farm, got " + newGold + " gold");
		}
		
		if (find.equals("house")) {
			int newGold = (rand.nextInt(4)+2);
			gold += newGold;
			session.setAttribute("gold", gold);
			messages.add("" +now + ": Went to the house, got " + newGold + " gold");
		}
		
		if (find.equals("casino")) {
			int newGold = (rand.nextInt(101)-50);
			gold += newGold;
			session.setAttribute("gold", gold);
			messages.add("" +now + ": Went to the casino, won/loss " + newGold + " gold");
		}
		
		session.setAttribute("messages", messages);
		return "redirect:/";
		
	}

}
