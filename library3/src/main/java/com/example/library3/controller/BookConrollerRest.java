package com.example.library3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.library3.domain.Book;
import com.example.library3.domain.BookRepository;
import com.example.library3.domain.GenreRepository;

@Controller
public class BookConrollerRest {
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private GenreRepository genreRrepository;
	
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) bookRepository.findAll();
	}
	
	@RequestMapping(value="/books/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
			return bookRepository.findById(bookId);
	} 
}
