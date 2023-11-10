package com.example.library3.domain;


import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String author;
	private String title;
	private int published;
	
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	private Collection<BookLoan> loans = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="genreid")
	private Genre genre;
	
	public Book() {}
	
	public Book(String author, String title, int published, Genre genre) {
		this.author = author;
		this.title = title;
		this.published = published;
		this.genre = genre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPublished() {
		return published;
	}

	public void setPublished(int published) {
		this.published = published;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Collection<BookLoan> getLoans() {
		return loans;
	}

	public void setLoans(Collection<BookLoan> loans) {
		this.loans = loans;
	}
	
	
}
