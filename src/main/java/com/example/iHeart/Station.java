package com.example.iHeart;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Station {
	private String stationId;
	private String name;
	private String callSign;
	private boolean hdEnabled;
	public Station(String stationId, String name, String callSign, boolean hdEnabled) {
		super();
		this.stationId = stationId;
		this.name = name;
		this.callSign = callSign;
		this.hdEnabled = hdEnabled;
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
