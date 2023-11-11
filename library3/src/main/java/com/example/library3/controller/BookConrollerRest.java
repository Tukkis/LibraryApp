package com.example.library3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.library3.domain.Book;
import com.example.library3.domain.BookRepository;

import jakarta.validation.Valid;

@Controller
public class BookConrollerRest {
	@Autowired
	private BookRepository bookRepository;
	
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) bookRepository.findAll();
	}
	
	@RequestMapping(value="/books/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
			return bookRepository.findById(bookId);
	} 
	
	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public String saveBook(@Valid Book book){
		bookRepository.save(book);
		return "Book successfully saved to the database";
	}
	
	@RequestMapping(value = "/editBook/{id}")
	public String modBook(@PathVariable("id") Long bookId, @RequestBody Book book){
		Book updateBook = bookRepository.findById(bookId).get();
		updateBook.setAuthor(book.getAuthor());
		updateBook.setTitle(book.getTitle());
		updateBook.setGenre(book.getGenre());
		updateBook.setPublished(book.getPublished());
		return "Book successfully updated";
	}
	
	@RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId) {
		bookRepository.deleteById(bookId);
		return "Book successfully deleted";
	}
	
}
