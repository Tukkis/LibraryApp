package com.example.library3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.library3.domain.BookLoan;
import com.example.library3.domain.BookLoanRepository;
import com.example.library3.domain.BookRepository;
import com.example.library3.domain.UserRepository;

import jakarta.validation.Valid;

@Controller
public class BookLoanController {
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookLoanRepository bookLoanRepository;

	@RequestMapping("/loanlist")
	public String list(Model model) {
		model.addAttribute("loans",  bookLoanRepository.findAll());
		return "loanlist";
	}
	@RequestMapping(value = "/addLoan")
	public String addLoan(Model model){
		model.addAttribute("loan", new BookLoan());
		model.addAttribute("books", bookRepository.findAll());
		model.addAttribute("users", userRepository.findAll());
		return "addloan";
	}
	
	@RequestMapping(value = "/saveLoan", method = RequestMethod.POST)
	public String saveLoan(@Valid BookLoan loan, BindingResult result, Model model){
		if (result.hasErrors()) {
			model.addAttribute("loan", loan);
			model.addAttribute("books", bookRepository.findAll());
			model.addAttribute("users", userRepository.findAll());
            return "addloan";
        }
		bookLoanRepository.save(loan);
		return "redirect:loanlist";
	}
	
}

