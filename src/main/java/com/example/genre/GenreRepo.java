package com.example.genre;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface GenreRepo extends CrudRepository<Genre,String> {
	List<Genre> findAllByHdEnabled(boolean status);

	Optional<Genre> findByName(String name);

}
