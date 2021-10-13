package com.horizon.loginandreg.controllers;

import javax.servlet.http.HttpSession;
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

import com.horizon.loginandreg.models.Book;
import com.horizon.loginandreg.models.User;
import com.horizon.loginandreg.services.BookService;
import com.horizon.loginandreg.services.UserService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookServ;
	
	 @Autowired
	 UserService userServ;
	
	// ==== Display =================
	 
	 // Read all
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book, Model model, HttpSession session) {
		Long id = (Long) session.getAttribute("user_id");
		if(id == null) {
			return "redirect:/";
		}
		User creator = userServ.getOne(id);
		model.addAttribute("user", creator);
		return "add_book.jsp";
	}
	
	// Read One
	@GetMapping("/books/{id}")
	public String showBook(@PathVariable("id") Long id, HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		if(userId == null) {
			return "redirect:/";
		}
		Book book = bookServ.oneBookById(id);
		model.addAttribute("book", book);
		// model.addAttribute("userId", userId);
		return "show_book.jsp";
	}
	
	// Update Display
	@GetMapping("/books/{id}/edit")
	public String editBook(@PathVariable("id") Long id, HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		if(userId == null) {
			return "redirect:/";
		}
		Book book = bookServ.oneBookById(id);
		model.addAttribute("book", book);
		
		// This calls the user data from the model
		// User u = userServ.getOne(userId);
		// model.addAttribute("user", u);
		return "edit_book.jsp";
	}

	// ==== Action ============
	
	// Create
	@PostMapping("/books/create")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
		Long id = (Long) session.getAttribute("user_id");
		if(id == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "add_book.jsp";
		} else {
			User user = userServ.getOne((Long) session.getAttribute("user_id"));
			book.setCreator(user);
			
			bookServ.saveBook(book);
			return "redirect:/home";
		}
	}
	
	// Update
	@PutMapping("/books/{id}/edit")
	public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session, @PathVariable("id") Long id, Model model) {
		// Long uid = (Long) session.getAttribute("user_id");
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "edit_book.jsp";
		} else {
			bookServ.saveBook(book);
			return "redirect:/home";
		}
	}

}
