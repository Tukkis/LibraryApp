package com.example.library3.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookLoanRepository extends CrudRepository<BookLoan, Long> {
	List<BookLoan> findByuser(User user);
	List<BookLoan> findBybook(Book book);
}
