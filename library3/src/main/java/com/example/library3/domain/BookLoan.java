package com.example.library3.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

import java.time.LocalDate;


@Entity
public class BookLoan {
	@EmbeddedId
	private BookLoanKey bookLoanKey = new BookLoanKey();
	@ManyToOne
	@MapsId("userId")
	private User user;
	@ManyToOne
	@MapsId("bookId")
	private Book book;
	private LocalDate loanStart;
	private LocalDate loanEnd;
	
	public BookLoanKey getBookLoanKey() {
		return bookLoanKey;
	}
	public void setBookLoanKey(BookLoanKey bookLoanKey) {
		this.bookLoanKey = bookLoanKey;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public LocalDate getLoanStart() {
		return loanStart;
	}
	public void setLoanStart(LocalDate loanStart) {
		this.loanStart = loanStart;
	}
	public LocalDate getLoanEnd() {
		return loanEnd;
	}
	public void setLoanEnd(LocalDate loanEnd) {
		this.loanEnd = loanEnd;
	}
	
}
