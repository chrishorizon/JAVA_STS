package com.horizon.counter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 1);
		} else {
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount++;
			session.setAttribute("count", currentCount);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/count")
	public String count(HttpSession session, Model model) {
		Integer currentCount = (Integer) session.getAttribute("count");
		if (currentCount == null) {
			currentCount = 0;
		}
		model.addAttribute("showCount", currentCount);
		return "showCount.jsp";
	}
	
	@RequestMapping("/reset")
	public String resetCount(HttpSession session, Model model) {
		session.setAttribute("count", 0);
		model.addAttribute("showCount", session.getAttribute("count"));
		return "showCount.jsp";
	}
	
	@RequestMapping("/double")
	public String doubleCount(HttpSession session, Model model) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 2);
		} else {
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount += 2;
			session.setAttribute("count", currentCount);
		}
		return "index.jsp";
	}

}
