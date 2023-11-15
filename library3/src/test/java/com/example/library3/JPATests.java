package com.example.library3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.library3.domain.Book;
import com.example.library3.domain.BookLoan;
import com.example.library3.domain.BookLoanRepository;
import com.example.library3.domain.BookRepository;
import com.example.library3.domain.Genre;
import com.example.library3.domain.GenreRepository;
import com.example.library3.domain.User;
import com.example.library3.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class JPATests {

	@Autowired
	private BookRepository bRepository;
	
	@Autowired
	private GenreRepository gRepository;
	
	@Autowired
	private UserRepository uRepository;
	
	@Autowired
	private BookLoanRepository blRepository;
	
	@Test
	public void createNewBook() {
		Book book = new Book("Kirjoittaja1", "Kirja1", 1991, new Genre("comics"));
		bRepository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void deleteBook() {
		Book book = new Book("Kirjoittaja1", "Kirja1", 1991, new Genre("comics"));
		bRepository.save(book);
		bRepository.deleteById(book.getId());
		assertNull(bRepository.findById(book.getId()).orElse(null));
	}
	
	@Test
	public void findBookById() {
		List<Book> books = bRepository.findByTitle("Kirja1");

		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Kirjoittaja1");
	}
	
	@Test
	public void findAllBooks() {
		Iterable<Book> books = bRepository.findAll();

		assertThat(books).isNotNull();
		assertThat(books.iterator().hasNext());

	}

	//CategoryRepository

	@Test
	public void createNewCategory() {
		Genre genre = new Genre("pertin");
		gRepository.save(genre);
		assertThat(genre.getGenreid()).isNotNull();
	}
	
	@Test
	public void deleteCategory() {
		Genre genre = new Genre("pertin");
		gRepository.save(genre);
		gRepository.deleteById(genre.getGenreid());
		assertNull(gRepository.findById(genre.getGenreid()).orElse(null));
	}
	
	@Test
	public void findCategoryById() {
		List<Genre> categories = gRepository.findByName("scifi");

		assertThat(categories).hasSize(1);
	}
	
	@Test
	public void findAllCategories() {
		Iterable<Genre> categories = gRepository.findAll();

		assertThat(categories).isNotNull();
		assertThat(categories.iterator().hasNext());

	}
	
	// UserRepository
	
	@Test
	public void createNewUser() {
		User user = new User("user2", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo7", "a@b.d", "USER");
		uRepository.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void deleteUser() {
		User user = new User("user2", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo7", "a@b.d", "USER");
		uRepository.save(user);
		uRepository.deleteById(user.getId());
		assertNull(uRepository.findById(user.getId()).orElse(null));
	}
	
	@Test
	public void findUserById() {
		User user = uRepository.findByUsername("user");

		assertThat(user).isNotNull();
	}
	
	@Test
	public void findAllUsers() {
		Iterable<User> users = uRepository.findAll();

		assertThat(users).isNotNull();
		assertThat(users.iterator().hasNext());

	}
	
	//BookLoanRepository

	@Test
	public void createNewLoan() {
		User user = uRepository.findByUsername("user");
		Book book = new Book("Kirjoittaja1", "Kirja1", 1991, new Genre("comics"));
		BookLoan loan = new BookLoan(user, book, LocalDate.now().toString(), LocalDate.now().plusDays(7).toString());
		blRepository.save(loan);
		assertThat(loan.getUser()).isNotNull();
	}
	
	@Test
	public void findAllLoans() {
		Iterable<BookLoan> loans = blRepository.findAll();

		assertThat(loans).isNotNull();
		assertThat(loans.iterator().hasNext());

	}
}
