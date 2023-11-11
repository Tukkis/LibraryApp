package com.example.library3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.library3.domain.Genre;
import com.example.library3.domain.GenreRepository;



@Controller
public class GenreController {
	@Autowired
	private GenreRepository repository;
	
	@RequestMapping("/genrelist")
	public String genreList(Model model) {
		model.addAttribute("genres",  repository.findAll());
		return "genrelist";
	}


	@RequestMapping(value = "/addgenre")
	public String addGenre(Model model){
		model.addAttribute("genre", new Genre());
		return "addgenre";
	}
	
	@RequestMapping(value = "/savegenre", method = RequestMethod.POST)
	public String saveCategory(Genre genre){
		repository.save(genre);
		return "redirect:genrelist";
	}
	@RequestMapping(value = "/editgenre/{id}")
	public String showModGenre(@PathVariable("id") Long genreId, Model model){
		model.addAttribute("genres", repository.findById(genreId));
		return "editgenre";
	}
	
	@RequestMapping(value = "/deletegenre/{id}", method = RequestMethod.GET)
	public String deleteGenre(@PathVariable("id") Long genreId, Model model) {
		repository.deleteById(genreId);
		return "redirect:../booklist";
	}
	
}

