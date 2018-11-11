package com.example.genre;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.StationNotFoundException;

@Service
public class GenreService {
	@Autowired
	private GenreRepo genreRepository;
	/*private List<Station> stations= new ArrayList<Station>(Arrays.asList(
			new Station("1","Pop","P",true),
			new Station("2","Rock","R",true),
			new Station("3","Mettalica","M",false),
			new Station("4","Opera","O",false)				
			));*/
	
	public List<Genre> getAll(){
		List<Genre>  genres=new ArrayList<>();
		genreRepository.findAll().forEach(genres::add);
		return genres;
		//return stations;
	}

	public Optional<Genre> getGenreById(String id) {
		
		//return stations.stream().filter(s -> s.getStationId().equals(id)).findFirst().get();
		
		return genreRepository.findById(id);
	}
	
	public void addGenre(Genre s) {
		//stations.add(s);
		genreRepository.save(s);
	}

	public void updateGenre(Genre s, String identification) {
		genreRepository.save(s);
		
		/*for(int i=0;i<stations.size();i++) {
			Station x=stations.get(i);
			if(x.getStationId().equals(identification)) {
				stations.set(i, s);
				return;
			}
		}*/
		
	}

	public void deleteGenre(String identification) {
		genreRepository.deleteById(identification);		
		//stations.removeIf(s -> s.getStationId().equals(identification));
		/*for(int i=0;i<stations.size();i++) {
			Station x=stations.get(i);
			
			if(x.getStationId().equals(identification)) {
				stations.remove(i);
				return;
			}
		}*/
	}
	public Optional<Genre> getGenreByName(String name) {
		return genreRepository.findByName(name);
	}
	/*public List<Genre> getStationHd() {
		boolean status=true;
		return genreRepository.findAllByHdEnabled(status);
		List<Station> hdStations=new ArrayList<>();
		for(int i=0;i<stations.size();i++) {
			Station x=stations.get(i);
			if(x.isHdEnabled()) {
				hdStations.add(x);				
			}
		}
		return hdStations;
		//return stations.stream().filter(s -> s.isHdEnabled());
		
	}*/

	
	
}
