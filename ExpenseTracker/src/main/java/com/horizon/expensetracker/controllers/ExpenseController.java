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
import org.springframework.web.bind.annotation.PutMapping;

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
	// Render all expenses in home page
	@GetMapping("/expenses")
	public String home(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = serv.allExpenses();
		model.addAttribute("exp", expenses);
		return "index.jsp";
	}
	
	// Render one expense in edit page
	@GetMapping("/expenses/edit/{id}")
	public String oneExp(@PathVariable("id") Long id, Model model) {
		Expense exp = serv.findExpense(id);
		model.addAttribute("expense", exp);
		return "edit.jsp";
	}
    
	// ==== Action ============
	// create an expense
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
	
	@PutMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			serv.updateExpenes(expense);
			return "redirect:/expenses";
		}
	}
	
	
}
