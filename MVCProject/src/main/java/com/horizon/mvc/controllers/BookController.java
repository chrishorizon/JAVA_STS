package com.horizon.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.horizon.mvc.models.Book;
import com.horizon.mvc.services.BookService;

@Controller
public class BookController {
	
	// Use dependency injection to have access to our service
	@Autowired
	BookService bookService;
	
	// ============== Display ===============================
	
	@GetMapping("/")
	public String home() {
		return "redirect:/books";
	}
	
	// Route to render one book by ID
	@GetMapping("/books/{bookId}")
	public String index(@PathVariable("bookId") Long bookId, Model model) {
		
		//System.out.println(bookId);
		Book book = bookService.findBook(bookId);
		//System.out.println(book);
		
		// variable for an array of all books
		List<Book> books = bookService.allBooks();
		
		// adds book to model
		model.addAttribute("bk", book);
		model.addAttribute("bks", books);
		
		return "show.jsp";
	}
	
	// Route to render all books
	@GetMapping("/books")
	public String showBooks(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
	        
		return "index.jsp";
	}
	
	// 
    @GetMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/books/new.jsp";
    }
    
    
	// ============== Actions ===============================
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
	
	
}
