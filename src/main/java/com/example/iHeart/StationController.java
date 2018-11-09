package com.example.iHeart;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StationController {
	@Autowired
	private StationService stationService;
	
	@RequestMapping("/stations")
	public List<Station> getStations() {
		return stationService.getAll();
	}
	@RequestMapping("/stations/{id}")
	public Optional<Station> getStation(@PathVariable("id") String identification) {
		return stationService.getStationById(identification);
	}
	@RequestMapping("/stations/hd")
	public List<Station> getStationHd() {
		return stationService.getStationHd();
	}
	@RequestMapping(method=RequestMethod.POST,path="/stations")
	public void addStation(@RequestBody Station s) {
		 stationService.addStation(s);
	}
	@RequestMapping(method=RequestMethod.PUT,path="/stations/{id}")
	public void updateStation(@RequestBody Station s,@PathVariable("id") String identification) {
		stationService.updateStation(s,identification);
	}
	@RequestMapping(method=RequestMethod.DELETE,path="/stations/{id}")
	public void deleteStation(@PathVariable("id") String identification) {
		stationService.deleteStation(identification);
	}
}
