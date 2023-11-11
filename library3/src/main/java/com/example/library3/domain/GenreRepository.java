package com.example.library3.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {
	Optional<Genre> findById(Long id);
	List<Genre> findByName(String name);
	
}
