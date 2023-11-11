package com.example.library3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.library3.controller.BookController;
import com.example.library3.controller.GenreController;
import com.example.library3.controller.UserDetailServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class Library3ApplicationTests {

	@Autowired
	private BookController bookController;
	
	@Autowired
	private GenreController genreController;

	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	@Test
	void contextLoads() {
		assertThat(bookController).isNotNull();
		assertThat(genreController).isNotNull();
		assertThat(userDetailServiceImpl).isNotNull();
	}

}
