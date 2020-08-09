package com.mercedes.model;

// LocationCoardinates Model holds details of city.
public class LocationCoardinates {
	private Double longitude;
	private Double altitude;
	private String cityName;
	
	public LocationCoardinates() {
		super();
	}
	public LocationCoardinates(Double longitude, Double altitude, String cityName) {
		super();
		this.longitude = longitude;
		this.altitude = altitude;
		this.cityName = cityName;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getAltitude() {
		return altitude;
	}
	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@Override
	public String toString() {
		return "LocationCoordinates [longitude=" + longitude + ", altitude=" + altitude + ", cityName=" + cityName
				+ "]";
	}
	
	
}
