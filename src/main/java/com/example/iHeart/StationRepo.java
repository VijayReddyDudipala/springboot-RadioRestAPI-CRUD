package com.example.iHeart;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StationRepo extends CrudRepository<Station,String> {
	List<Station> findAllByHdEnabled(boolean status);

}
