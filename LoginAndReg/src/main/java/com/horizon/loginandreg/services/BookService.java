package com.horizon.loginandreg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horizon.loginandreg.models.Book;
import com.horizon.loginandreg.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepo;
	
    // return all
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}

    // retrive one
	public Book oneBookById(Long id) {
		Optional<Book> optBook = bookRepo.findById(id);
		if(optBook.isPresent()) {
			return optBook.get();
		} else return null;
	}

    // create
	public Book saveBook(Book b) {
		return bookRepo.save(b);
	}

    // update one by ID

    // delete one by ID
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}

}
