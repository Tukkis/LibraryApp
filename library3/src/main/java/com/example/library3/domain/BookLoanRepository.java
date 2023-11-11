package com.example.library3.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookLoanRepository extends CrudRepository<BookLoan, BookLoanKey> {
	List<BookLoan> findByUser(User user);
	List<BookLoan> findByBook(Book book);
}
