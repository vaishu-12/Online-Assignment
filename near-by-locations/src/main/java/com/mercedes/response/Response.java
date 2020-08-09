package com.mercedes.response;

import java.util.List;

import com.mercedes.model.Item;
import com.mercedes.model.LocationCoardinates;

//User Response Model which holds details of 3 categories ( Restaurants, Shopping Locations and Petrol stations) and Response message.
public class Response {

	private List<Item> restaurants;
	private List<Item> petrolStations;
	private List<Item> shoppings;
	private LocationCoardinates locationCoardinates;
	private String message;
	
	public Response() {
		super();
	}

	public Response(List<Item> restaurants, List<Item> petrolStations, List<Item> shoppings,
			LocationCoardinates locationCoardinates, String message) {
		super();
		this.restaurants = restaurants;
		this.petrolStations = petrolStations;
		this.shoppings = shoppings;
		this.locationCoardinates = locationCoardinates;
		this.message = message;
	}
	public List<Item> getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(List<Item> restaurants) {
		this.restaurants = restaurants;
	}
	public List<Item> getPetrolStations() {
		return petrolStations;
	}
	public void setPetrolStations(List<Item> petrolStations) {
		this.petrolStations = petrolStations;
	}
	public List<Item> getShoppings() {
		return shoppings;
	}
	public void setShoppings(List<Item> shoppings) {
		this.shoppings = shoppings;
	}
	public LocationCoardinates getLocationCoardinates() {
		return locationCoardinates;
	}
	public void setLocationCoardinates(LocationCoardinates locationCoardinates) {
		this.locationCoardinates = locationCoardinates;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseDto [restaurants=" + restaurants + ", petrolStations=" + petrolStations + ", shoppings="
				+ shoppings + ", locationCoardinates=" + locationCoardinates + ", message=" + message + "]";
	}


	
}
