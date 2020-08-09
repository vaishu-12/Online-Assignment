package com.mercedes.utils;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mercedes.model.Item;

@Component
public class Utils {

	// Sorting Items as per distanceWithCurrentLoc field
	public List<Item> sortByDistance(List<Item> items){
		items.sort(new Comparator<Item>() {
			public int compare(Item o1, Item o2) {
				if (o1.getDistanceWithCurrentLoc() > o2.getDistanceWithCurrentLoc()) {
					return 1;
				}
				if (o1.getDistanceWithCurrentLoc() < o2.getDistanceWithCurrentLoc()) {
					return -1;
				}
				return 0;
			}
		});
		return items;
	}
}
