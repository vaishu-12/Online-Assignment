package com.mercedes.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mercedes.model.Item;
import com.mercedes.model.LocationCoardinates;
import com.mercedes.response.Response;
import com.mercedes.response.ResponseDto;
import com.mercedes.service.CityService;
import com.mercedes.service.PetrolStationService;
import com.mercedes.service.RestaurantService;
import com.mercedes.service.ShoppingService;

/*
 * - RestController 
 * - Selected Categories are Restaurants, Shopping Locations and Petrol stations.
 * - url, apiKey is fetched from application.properties file.
 * - Asynchronous calls to getNearByRestaurants, getNearByPetrolStations, getNearByShoppingLocations Services
 * - Used *Service Interfaces.
 * - Implementations for getNearByRestaurants, getNearByPetrolStations, getNearByShoppingLocations Services are in *ServiceImpl classes.
 * - ResponseDto is User response class.
 * - ResponseDto holds Response object which holds (list of restaurants, petrolStations, shoppings and message) fields.
 * - Response format : {"response" : {"restaurants":[{}..], "petrolStations": [{}..], "shoppings":[{}..],"locationCoardinates":{},"message":""}}
 * - demo url : http://localhost:8191/city?city=berlin
 * */
@RestController
public class DistanceController {
	
	@Autowired
	private PetrolStationService petrolStationService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private ShoppingService shoppingService;
	
	@Autowired
	private CityService cityService;
	
	@Value("${url}")
	private String url;
	
	@Value("${api.key}")
	private String apiKey;
	
	Response response = new Response();
	private static final Logger LOGGER = LoggerFactory.getLogger(DistanceController.class);
	
	@GetMapping("/city")
	public  ResponseDto getNearByDetails(@RequestParam("city") String cityName) {
		LocationCoardinates locationCoardinates = cityService.getCityCoordinates(cityName);
		if(locationCoardinates.getLongitude() == null || locationCoardinates.getAltitude() == null) {
			response.setMessage("Coordinates not found for given location");
			return new ResponseDto(response);
		}
		response.setLocationCoardinates(locationCoardinates);
		List<Item> restaurants = new ArrayList<Item>();
		List<Item> petrolStations = new ArrayList<Item>();
		List<Item> shoppings = new ArrayList<Item>();
		
		CompletableFuture<List<Item>> completedRestaurants = restaurantService.getNearByRestaurants(locationCoardinates, url, apiKey);
		CompletableFuture<List<Item>> completedPetrolStations = petrolStationService.getNearByPetrolStations(locationCoardinates, url, apiKey);
		CompletableFuture<List<Item>> completedShoppings = shoppingService.getNearByShoppingLocations(locationCoardinates, url, apiKey);

		try {
			if(completedRestaurants != null) {
				restaurants = completedRestaurants.get();
				response.setRestaurants(restaurants);
				LOGGER.info("restaurants "+restaurants);
			}
			if(completedPetrolStations != null) {
				petrolStations = completedPetrolStations.get();
				response.setPetrolStations(petrolStations);
				LOGGER.info("Petrol Stations "+petrolStations);
			}
			if(completedShoppings != null) {
				shoppings = completedShoppings.get();
				response.setShoppings(shoppings);
				LOGGER.info("Shopping Locations "+shoppings);
			}
			response.setMessage("Data Received");
		} catch (Exception e) {
			response.setMessage(e.getMessage());
		} 
		return new ResponseDto(response);
	}
}

