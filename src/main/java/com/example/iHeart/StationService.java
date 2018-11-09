package com.example.iHeart;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.stereotype.Service;

@Service
public class StationService {
	private List<Station> stations= new ArrayList<Station>(Arrays.asList(
			new Station("1","Pop","P",true),
			new Station("2","Rock","R",true),
			new Station("3","Mettalica","M",false),
			new Station("4","Opera","O",false)				
			));
	
	public List<Station> getAll(){
		return stations;
	}

	public Station getStationById(String id) {
		// TODO Auto-generated method stub
		return stations.stream().filter(s -> s.getStationId().equals(id)).findFirst().get();
	}
	
	public void addStation(Station s) {
		stations.add(s);
	}

	public void updateStation(Station s, String identification) {
		// TODO Auto-generated method stub
		for(int i=0;i<stations.size();i++) {
			Station x=stations.get(i);
			if(x.getStationId().equals(identification)) {
				stations.set(i, s);
				return;
			}
		}
		
	}

	public void deleteStation(String identification) {
		// TODO Auto-generated method stub
		stations.removeIf(s -> s.getStationId().equals(identification));
		/*for(int i=0;i<stations.size();i++) {
			Station x=stations.get(i);
			
			if(x.getStationId().equals(identification)) {
				stations.remove(i);
				return;
			}
		}*/
	}

	public List<Station> getStationHd() {
		// TODO Auto-generated method stub
		List<Station> hdStations=new ArrayList<>();
		for(int i=0;i<stations.size();i++) {
			Station x=stations.get(i);
			if(x.isHdEnabled()) {
				hdStations.add(x);				
			}
		}
		return hdStations;
		//return stations.stream().filter(s -> s.isHdEnabled());
		
	}
	
}
