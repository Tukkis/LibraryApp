package com.example.library3.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class BookLoanKey implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
    Long userId;

    @Column(name = "book_id")
    Long bookId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
}
