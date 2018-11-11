package com.example.genre;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.StationNotFoundException;

@RestController
public class GenreController {
	@Autowired
	private GenreService genreService;
	
	@RequestMapping("/genres")
	public List<Genre> getGenres() {
		return genreService.getAll();
	}
	@RequestMapping("/genres/{id}")
	public Optional<Genre> getStation(@PathVariable("id") String identification) {
		if(genreService.getGenreById(identification)==null)
			throw new StationNotFoundException();
		return genreService.getGenreById(identification);
	}
	/*@RequestMapping("/stations/{name}")
	public Optional<Station> getStationByName(@PathVariable("name") String name) {
		return stationService.getStationByName(name);
	}*/
	
	@RequestMapping(method=RequestMethod.POST,path="/genre")
	public void addGenre(@RequestBody Genre s) {
		 genreService.addGenre(s);
	}
	@RequestMapping(method=RequestMethod.PUT,path="/genre/{id}")
	public void updateGenre(@RequestBody Genre s,@PathVariable("id") String identification) {
		genreService.updateGenre(s,identification);
	}
	@RequestMapping(method=RequestMethod.DELETE,path="/genre/{id}")
	public void deleteGenre(@PathVariable("id") String identification) {
		genreService.deleteGenre(identification);
	}
}
