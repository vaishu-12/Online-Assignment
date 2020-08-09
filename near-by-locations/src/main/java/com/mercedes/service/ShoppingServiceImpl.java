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
public class ShoppingServiceImpl implements ShoppingService{

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Utils utils;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingServiceImpl.class);
	
	/* - Service for fetching nearest 3 Shopping Locations for given location/city.
	 * - Distance with each Item (Shopping Locations) is calculated.
	 * - sorted Items using sortByDistance.
	 * - returns nearest 3 Shopping Locations.
	 */
	@Async
	public CompletableFuture<List<Item>> getNearByShoppingLocations(LocationCoardinates locationCoardinates, String url,
			String apiKey) {
		LOGGER.info("Shopping service");
		Double longitude = locationCoardinates.getLongitude();
		Double altitude = locationCoardinates.getAltitude();
		String shoppinglocationsUrl = url + "" + longitude + "," + altitude + "&cat=shopping&apiKey=" + apiKey;
		ResultFromApi res = restTemplate.getForObject(shoppinglocationsUrl, ResultFromApi.class);

		List<Item> shoppinglocationsItems = res.getResults().getItems();
		for (Item item : shoppinglocationsItems) {
			Double xdist = (longitude - (item.getPosition()[0])) * (longitude - (item.getPosition()[0]));
			Double ydist = (altitude - (item.getPosition()[1])) * (altitude - (item.getPosition()[1]));
			Double distance = Math.sqrt(xdist + ydist);
			item.setDistanceWithCurrentLoc(distance);
		}
		shoppinglocationsItems = utils.sortByDistance(shoppinglocationsItems);
		
		List<Item> closetShoppinglocations = new ArrayList<Item>();
		closetShoppinglocations.add(shoppinglocationsItems.get(0));
		closetShoppinglocations.add(shoppinglocationsItems.get(1));
		closetShoppinglocations.add(shoppinglocationsItems.get(2));
		LOGGER.info("Closest Shopping Locations: "+closetShoppinglocations);
		return CompletableFuture.completedFuture(closetShoppinglocations);
	}

}
