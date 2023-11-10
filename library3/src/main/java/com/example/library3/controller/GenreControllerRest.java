package com.example.library3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.library3.domain.Genre;
import com.example.library3.domain.GenreRepository;

@Controller
public class GenreControllerRest {
	@Autowired
	private GenreRepository repository;

	@RequestMapping(value="/genres", method = RequestMethod.GET)
	public @ResponseBody List<Genre> genreListRest() {
		return (List<Genre>) repository.findAll();
	}
}
