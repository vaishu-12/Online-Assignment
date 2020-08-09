package com.mercedes.model;

import java.util.Arrays;

/* - Item Model used for Restaurants, PetrolStations and Shopping Locations.
 * - distanceWithCurrentLoc field used for calculating distance of each item with given city.
 * */
public class Item {
	private Integer distance;
	private Double distanceWithCurrentLoc;
	private String title;
	private Double[] position = new Double[2] ;
	private Integer averageRating;
	private Category category;
	private OpeningHours openingHours;
	
	public Item() {
		super();
	}

	public Item(Integer distance, Double distanceWithCurrentLoc, String title, Double[] position, Integer averageRating,
			Category category, OpeningHours openingHours) {
		super();
		this.distance = distance;
		this.distanceWithCurrentLoc = distanceWithCurrentLoc;
		this.title = title;
		this.position = position;
		this.averageRating = averageRating;
		this.category = category;
		this.openingHours = openingHours;
	}

	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(Integer averageRating) {
		this.averageRating = averageRating;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public OpeningHours getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(OpeningHours openingHours) {
		this.openingHours = openingHours;
	}
	
	public Double[] getPosition() {
		return position;
	}

	public void setPosition(Double[] position) {
		this.position = position;
	}

	public Double getDistanceWithCurrentLoc() {
		return distanceWithCurrentLoc;
	}

	public void setDistanceWithCurrentLoc(Double distanceWithCurrentLoc) {
		this.distanceWithCurrentLoc = distanceWithCurrentLoc;
	}

	@Override
	public String toString() {
		return "Item [distance=" + distance + ", distanceWithCurrentLoc=" + distanceWithCurrentLoc + ", title=" + title
				+ ", position=" + Arrays.toString(position) + ", averageRating=" + averageRating + ", category="
				+ category + ", openingHours=" + openingHours + "]";
	}
	
}
