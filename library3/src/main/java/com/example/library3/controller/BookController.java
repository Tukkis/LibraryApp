package com.example.library3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.library3.domain.Book;
import com.example.library3.domain.BookRepository;
import com.example.library3.domain.GenreRepository;

import jakarta.validation.Valid;



@Controller
public class BookController {
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private GenreRepository genreRrepository;
	
	@RequestMapping("/booklist")
	public String list(Model model) {
		model.addAttribute("books",  bookRepository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value = "/add")
	public String addBook(Model model){
		model.addAttribute("book", new Book());
		model.addAttribute("genres", genreRrepository.findAll());
		return "addbook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(@Valid Book book, BindingResult result, Model model){
		if (result.hasErrors()) {
			model.addAttribute("genres", genreRrepository.findAll());
            return "addbook";
        }
		bookRepository.save(book);
		return "redirect:booklist";
	}

	@RequestMapping(value = "/save_edited")
	public String saveModBook(@Valid Book book, BindingResult result, Model model){
		if (result.hasErrors()) {
			model.addAttribute("genres", genreRrepository.findAll());
            return "editbook";
        }
		bookRepository.save(book);
		return "redirect:booklist";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String showModBook(@PathVariable("id") Long bookId, Model model){
		model.addAttribute("book", bookRepository.findById(bookId));
		model.addAttribute("genres", genreRrepository.findAll());
		return "editbook";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		bookRepository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
}
