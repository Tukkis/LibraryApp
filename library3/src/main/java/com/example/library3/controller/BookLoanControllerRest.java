package com.example.library3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.library3.domain.BookLoan;
import com.example.library3.domain.BookLoanRepository;
import com.example.library3.domain.User;

import jakarta.validation.Valid;

public class BookLoanControllerRest {
	
	@Autowired
	private BookLoanRepository bookLoanRepository;
	
	@RequestMapping(value="/loans", method = RequestMethod.GET)
	public @ResponseBody List<BookLoan> loanListRest() {
		return (List<BookLoan>) bookLoanRepository.findAll();
	}
	
	@RequestMapping(value="/userLoans/{id}", method = RequestMethod.GET)
	public @ResponseBody List<BookLoan> findBookRest(@PathVariable("id") User user) {
			return bookLoanRepository.findByUser(user);
	} 
	
	@RequestMapping(value = "/saveLoan", method = RequestMethod.POST)
	public String saveBook(@Valid BookLoan bookLoan){
		bookLoanRepository.save(bookLoan);
		return "Loan successfully saved to the database";
	}
}
