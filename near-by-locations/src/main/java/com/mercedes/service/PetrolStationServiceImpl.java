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
public class PetrolStationServiceImpl implements PetrolStationService{

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Utils utils;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PetrolStationServiceImpl.class);
	
	/* - service for fetching nearest 3 Petrol stations for given location/city.
	 * - Distance with each Item (Petrol Station) is calculated.
	 * - sorted Items using sortByDistance.
	 * - returns nearest 3 petrol stations.
	 */
	@Async
	public CompletableFuture<List<Item>> getNearByPetrolStations(LocationCoardinates locationCoardinates, String url,
			String apiKey) {
		LOGGER.info("Petrol service");
		Double longitude = locationCoardinates.getLongitude();
		Double altitude = locationCoardinates.getAltitude();
		String petrolStationtUrl = url + "" + longitude + "," + altitude + "&cat=petrol-station&apiKey=" + apiKey;
		ResultFromApi res = restTemplate.getForObject(petrolStationtUrl, ResultFromApi.class);

		List<Item> petrolStationItems = res.getResults().getItems();
		for (Item item : petrolStationItems) {
			Double xdist = (longitude - (item.getPosition()[0])) * (longitude - (item.getPosition()[0]));
			Double ydist = (altitude - (item.getPosition()[1])) * (altitude - (item.getPosition()[1]));
			Double distance = Math.sqrt(xdist + ydist);
			item.setDistanceWithCurrentLoc(distance);
		}
		petrolStationItems = utils.sortByDistance(petrolStationItems);
		
		List<Item> closetPetrolStations = new ArrayList<Item>();
		closetPetrolStations.add(petrolStationItems.get(0));
		closetPetrolStations.add(petrolStationItems.get(1));
		closetPetrolStations.add(petrolStationItems.get(2));
		LOGGER.info("Nearest Petrol Stations: "+closetPetrolStations);
		return CompletableFuture.completedFuture(closetPetrolStations);
	}

}
