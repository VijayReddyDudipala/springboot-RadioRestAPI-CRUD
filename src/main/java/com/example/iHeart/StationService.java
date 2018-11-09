package com.example.iHeart;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationService {
	@Autowired
	private StationRepo stationRepository;
	private List<Station> stations= new ArrayList<Station>(Arrays.asList(
			new Station("1","Pop","P",true),
			new Station("2","Rock","R",true),
			new Station("3","Mettalica","M",false),
			new Station("4","Opera","O",false)				
			));
	
	public List<Station> getAll(){
		List<Station>  stations=new ArrayList<>();
		stationRepository.findAll().forEach(stations::add);
		return stations;
		//return stations;
	}

	public Optional<Station> getStationById(String id) {
		
		//return stations.stream().filter(s -> s.getStationId().equals(id)).findFirst().get();
		return stationRepository.findById(id);
	}
	
	public void addStation(Station s) {
		//stations.add(s);
		stationRepository.save(s);
	}

	public void updateStation(Station s, String identification) {
		stationRepository.save(s);
		
		/*for(int i=0;i<stations.size();i++) {
			Station x=stations.get(i);
			if(x.getStationId().equals(identification)) {
				stations.set(i, s);
				return;
			}
		}*/
		
	}

	public void deleteStation(String identification) {
		stationRepository.deleteById(identification);
		
		//stations.removeIf(s -> s.getStationId().equals(identification));
		/*for(int i=0;i<stations.size();i++) {
			Station x=stations.get(i);
			
			if(x.getStationId().equals(identification)) {
				stations.remove(i);
				return;
			}
		}*/
	}

	public List<Station> getStationHd() {
		boolean status=true;
		return stationRepository.findAllByHdEnabled(status);
		/*List<Station> hdStations=new ArrayList<>();
		for(int i=0;i<stations.size();i++) {
			Station x=stations.get(i);
			if(x.isHdEnabled()) {
				hdStations.add(x);				
			}
		}
		return hdStations;*/
		//return stations.stream().filter(s -> s.isHdEnabled());
		
	}
	
}
