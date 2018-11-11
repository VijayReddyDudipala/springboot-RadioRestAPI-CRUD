package com.example.genre;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Genre {
	@Id
	private String genreId;
	private String name;
	private String callSign;
	
	
	public Genre(String genreId, String name, String callSign) {
		super();
		this.genreId = genreId;
		this.name = name;
		this.callSign = callSign;
		
	}
	
	public Genre() {
		super();
	}

	public String getGenreId() {
		return genreId;
	}
	public void setStationId(String genreId) {
		this.genreId = genreId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCallSign() {
		return callSign;
	}
	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}
	

}
