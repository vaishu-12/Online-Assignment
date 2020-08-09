package com.mercedes.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.mercedes.model.Item;
import com.mercedes.model.LocationCoardinates;

public interface ShoppingService {

	CompletableFuture<List<Item>> getNearByShoppingLocations(LocationCoardinates locationCoardinates, String url,
			String api_key);

}
