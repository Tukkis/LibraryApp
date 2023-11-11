package com.example.library3.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.validation.constraints.Pattern;

@Entity
public class BookLoan {
	
	@EmbeddedId
	private BookLoanKey id = new BookLoanKey();
	@ManyToOne
	@MapsId("userId")
	private User user;
	@ManyToOne
	@MapsId("bookId")
	private Book book;
	@Pattern(regexp = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", message="format(yyyy-MM-dd)")
	private String loanStart;
	@Pattern(regexp = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", message="format(yyyy-MM-dd)")
	private String loanEnd;
	
	public BookLoan(User user, Book book, String loanStart, String loanEnd) {
		super();
		this.user = user;
		this.book = book;
		this.loanStart = loanStart;
		this.loanEnd = loanEnd;
	}
	
	public BookLoan() {}
	
	public BookLoanKey getBookLoanKey() {
		return id;
	}
	public void setBookLoanKey(BookLoanKey bookLoanKey) {
		this.id = bookLoanKey;
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
	public String getLoanStart() {
		return loanStart;
	}
	public void setLoanStart(String loanStart) {
		this.loanStart = loanStart;
	}
	public String getLoanEnd() {
		return loanEnd;
	}
	public void setLoanEnd(String loanEnd) {
		this.loanEnd = loanEnd;
	}
	
}
