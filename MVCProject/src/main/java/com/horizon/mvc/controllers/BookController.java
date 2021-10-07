package com.horizon.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.horizon.mvc.models.Book;
import com.horizon.mvc.services.BookService;

@Controller
public class BookController {
	
	// Use dependency injection to have access to our service
	@Autowired
	BookService bookService;
	
	@GetMapping("/book/{bookId}")
	public String index(@PathVariable("bookId") Long bookId, Model model) {
		
//		System.out.println(bookId);
		Book book = bookService.findBook(bookId);
//		System.out.println(book);
		
		// variable for an array of all books
		List<Book> books = bookService.allBooks();
		
		// adds book to model
		model.addAttribute("bk", book);
		model.addAttribute("bks", books);
		
		return "show.jsp";
	}
	
	
}
