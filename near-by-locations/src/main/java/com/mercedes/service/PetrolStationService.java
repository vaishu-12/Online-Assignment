package com.mercedes.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.mercedes.model.Item;
import com.mercedes.model.LocationCoardinates;

public interface PetrolStationService {

	CompletableFuture<List<Item>> getNearByPetrolStations(LocationCoardinates locationCoardinates, String url,
			String apiKey);

}
