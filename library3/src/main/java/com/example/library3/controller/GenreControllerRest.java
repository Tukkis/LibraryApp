package com.example.library3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.library3.domain.Genre;
import com.example.library3.domain.GenreRepository;

import jakarta.validation.Valid;

@Controller
public class GenreControllerRest {
	@Autowired
	private GenreRepository genreRepository;

	@RequestMapping(value="/genres", method = RequestMethod.GET)
	public @ResponseBody List<Genre> genreListRest() {
		return (List<Genre>) genreRepository.findAll();
	}
	@RequestMapping(value="/genres/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Genre> findGenreRest(@PathVariable("id") Long genreId) {
			return genreRepository.findById(genreId);
	} 
	
	@RequestMapping(value = "/saveGenre", method = RequestMethod.POST)
	public String saveBook(@Valid Genre genre){
		genreRepository.save(genre);
		return "Genre successfully saved to the database";
	}
	
	@RequestMapping(value = "/editGenre/{id}")
	public String modGenre(@PathVariable("id") Long genreId, @RequestBody Genre genre){
		Genre updateGenre = genreRepository.findById(genreId).get();
		updateGenre.setName(genre.getName());
		return "Genre successfully updated";
	}
	
	@RequestMapping(value = "/deleteGenre/{id}", method = RequestMethod.GET)
	public String deleteGenre(@PathVariable("id") Long genreId) {
		genreRepository.deleteById(genreId);
		return "Genre successfully deleted";
	}
}
