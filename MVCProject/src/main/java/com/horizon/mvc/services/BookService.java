package com.horizon.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.horizon.mvc.models.Book;
import com.horizon.mvc.repositories.BookRepository;

@Service
public class BookService {
	// this is the instance we are going to use
	// the variable will call all the methods we have in repo
	// adding the book repository as a dependency
	private final BookRepository bookRepo;
	
	public BookService(BookRepository r) {
		this.bookRepo = r;
	}
	
    // returns all the books
    public List<Book> allBooks() {
        return bookRepo.findAll();
    }
    
    // creates a book
    public Book createBook(Book b) {
        return bookRepo.save(b);
    }
    
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    // update book by id
	public Book updateBook(Book b) {
		// TODO Auto-generated method stub
		return bookRepo.save(b);
	}
	
	// deletes book by id
	public void deleteBook(Long id) {
		// TODO Auto-generated method stub
		bookRepo.deleteById(id);
	}
	
	
}
