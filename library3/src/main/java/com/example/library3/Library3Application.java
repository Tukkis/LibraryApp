package com.example.library3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.library3.domain.Book;
import com.example.library3.domain.BookRepository;
import com.example.library3.domain.Genre;
import com.example.library3.domain.GenreRepository;
import com.example.library3.domain.User;
import com.example.library3.domain.UserRepository;

@SpringBootApplication
public class Library3Application {

	public static void main(String[] args) {
		SpringApplication.run(Library3Application.class, args);
	}

	@Bean
	public CommandLineRunner categorycl(GenreRepository genreRepository, BookRepository bookRepository, UserRepository userRepository) {
		return (args) -> {
			Genre genre1 = new Genre("scifi");
			Genre genre2 = new Genre("comic");
			
			genreRepository.save(genre1);
			genreRepository.save(genre2);

			Book book1 = new Book("Kirjoittaja1", "Kirja1", 1991, genreRepository.findByName("comic").get(0));
			Book book2 = new Book("Kirjoittaja2", "Kirja2", 1992, genreRepository.findByName("scifi").get(0));
			Book book3 = new Book("Kirjoittaja2", "Kirja3", 1993, genreRepository.findByName("comic").get(0));

			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "a@b.c", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "a@b.c", "ADMIN");
			
			userRepository.save(user1);
			userRepository.save(user2);
			
			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);
		};
	}

}
