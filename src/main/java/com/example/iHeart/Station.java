package com.example.iHeart;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.genre.Genre;


@Entity
public class Station {
	@Id
	private String stationId;
	private String name;
	private String callSign;
	private boolean hdEnabled;
	@ManyToOne(targetEntity = Genre.class)
	private Genre genre;//many stations may belong to a genre
	public Station(String stationId, String name, String callSign, boolean hdEnabled,String genreId) {
		super();
		this.stationId = stationId;
		this.name = name;
		this.callSign = callSign;
		this.hdEnabled = hdEnabled;
		this.genre=new Genre(genreId,"","");
	}
	
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Station() {
		super();
	}

	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
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
	public boolean isHdEnabled() {
		return hdEnabled;
	}
	public void setHdEnabled(boolean hdEnabled) {
		this.hdEnabled = hdEnabled;
	}
	

}
