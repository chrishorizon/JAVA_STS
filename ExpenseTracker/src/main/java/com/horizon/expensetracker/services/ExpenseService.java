package com.horizon.expensetracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.horizon.expensetracker.models.Expense;
import com.horizon.expensetracker.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	// bring in expense repo
	private final ExpenseRepository expenseRepo;
	public ExpenseService(ExpenseRepository r) {
		this.expenseRepo = r;
	}
		
	// return all
	public List<Expense> allExpenses(){
		return expenseRepo.findAll();
	}
	
	// retrive one
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExp = expenseRepo.findById(id);
		if(optionalExp.isPresent()) {
			return optionalExp.get();
		} else return null; 
	}
	
	// create
	public Expense createExpense(Expense e) {
		return expenseRepo.save(e);
	}
	
	// update one by ID
	public Expense updateExpenes(Expense e) {
		return expenseRepo.save(e);
	}
	
	// delete one by ID
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}

}
