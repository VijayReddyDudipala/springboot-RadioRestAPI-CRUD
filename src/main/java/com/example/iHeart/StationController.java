package com.example.iHeart;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.StationNotFoundException;
import com.example.genre.Genre;

@RestController
public class StationController {
	@Autowired
	private StationService stationService;
	
	@RequestMapping("/genre/{genreId}/stations")
	public List<Station> getStations(@PathVariable("genreId") String genreId) {
		return stationService.getAll(genreId);
	}
	@RequestMapping("/genre/{genreId}/stations/{id}")
	public Optional<Station> getStation(@PathVariable("id") String identification) {
		if(stationService.getStationById(identification)==null)
			throw new StationNotFoundException();
		return stationService.getStationById(identification);
	}
	/*@RequestMapping("/stations/{name}")
	public Optional<Station> getStationByName(@PathVariable("name") String name) {
		return stationService.getStationByName(name);
	}*/
	@RequestMapping("/genre/{genreId}/stations/hd")
	public List<Station> getStationHd() {
		return stationService.getStationHd();
	}
	@RequestMapping(method=RequestMethod.POST,path="/genre/{genreId}/stations")
	public void addStation(@RequestBody Station s,@PathVariable("genreId") String genreId) {
		 s.setGenre(new Genre(genreId,"",""));
		 stationService.addStation(s);
	}
	@RequestMapping(method=RequestMethod.PUT,path="/genre/{genreId}/stations/{id}")
	public void updateStation(@RequestBody Station s,@PathVariable("id") String identification,@PathVariable("genreId") String genreId) {
		s.setGenre(new Genre(genreId,"",""));
		stationService.updateStation(s);
	}
	@RequestMapping(method=RequestMethod.DELETE,path="/genre/{genreId}/stations/{id}")
	public void deleteStation(@PathVariable("id") String identification) {
		stationService.deleteStation(identification);
	}
}
