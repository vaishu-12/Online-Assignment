package com.mercedes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mercedes.model.Item;
import com.mercedes.model.LocationCoardinates;
import com.mercedes.model.ResultFromApi;
import com.mercedes.utils.Utils;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Utils utils;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantServiceImpl.class);
	
	/* - service for fetching nearest 3 Restaurants for given location/city.
	 * - Distance with each Item (Restaurants) is calculated.
	 * - sorted Items using sortByDistance.
	 * - returns nearest 3 Restaurants.
	 */
	@Async
	public CompletableFuture<List<Item>> getNearByRestaurants(LocationCoardinates locationCoardinates, String url, String apiKey) {
		LOGGER.info("Restaurant service");
		Double longitude = locationCoardinates.getLongitude();
		Double altitude = locationCoardinates.getAltitude();
		String restaurantUrl = url + "" + longitude + "," + altitude + "&cat=restaurant&apiKey=" + apiKey;
		ResultFromApi res = restTemplate.getForObject(restaurantUrl, ResultFromApi.class);

		List<Item> restaurantItems = res.getResults().getItems();
		for (Item item : restaurantItems) {
			Double xdist = (longitude - (item.getPosition()[0])) * (longitude - (item.getPosition()[0]));
			Double ydist = (altitude - (item.getPosition()[1])) * (altitude - (item.getPosition()[1]));
			Double distance = Math.sqrt(xdist + ydist);
			item.setDistanceWithCurrentLoc(distance);
		}
		restaurantItems = utils.sortByDistance(restaurantItems);
		
		List<Item> closetRestaurants = new ArrayList<Item>();
		closetRestaurants.add(restaurantItems.get(0));
		closetRestaurants.add(restaurantItems.get(1));
		closetRestaurants.add(restaurantItems.get(2));

		LOGGER.info("Closest Restaurants: "+closetRestaurants);
		return CompletableFuture.completedFuture(closetRestaurants);
	}
	
	

}
