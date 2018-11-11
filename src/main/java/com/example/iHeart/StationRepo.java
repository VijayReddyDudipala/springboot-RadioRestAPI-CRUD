package com.example.iHeart;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface StationRepo extends CrudRepository<Station,String> {
	List<Station> findAllByHdEnabled(boolean status);

	Optional<Station> findByName(String name);
	
	List<Station> findByGenreGenreId(String genreId);

}
