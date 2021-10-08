package com.horizon.expensetracker.controllers;

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

import com.horizon.expensetracker.models.Expense;
import com.horizon.expensetracker.services.ExpenseService;

@Controller
public class ExpenseController {
	
	@Autowired
	ExpenseService serv;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/expenses";
	}
	
	// ==== Display =================
	@GetMapping("/expenses")
	public String home(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = serv.allExpenses();
		model.addAttribute("exp", expenses);
		return "index.jsp";
	}
	
	@GetMapping("/expenses/{id}")
	public String oneExp(@PathVariable("id") Long id, Model model) {
		Expense exp = serv.findExpense(id);
		model.addAttribute("exp", exp);
		return "show.jsp";
	}
    
	// ==== Action ============
	@PostMapping("/expense")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Expense> expenses = serv.allExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		} else {
			serv.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	
}
