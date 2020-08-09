package com.mercedes.service;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.mercedes.model.LocationCoardinates;


@Service
@PropertySource(value = "classpath:city_coordinates.properties", ignoreResourceNotFound = true)
public class CityServiceImpl implements CityService {

	//Implicitly Properties type of Bean is available in the container. so, used by name.
	@Autowired
	@Qualifier("getCityProprties")
	private Properties cityCoordinates;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);
	
	//Based on given city longitude and altitude property value read from  city_coordinates.properties file
	public LocationCoardinates getCityCoordinates(String city) {
		LOGGER.info(cityCoordinates.getProperty(city+".longitude")+" "+cityCoordinates.getProperty(city+".altitude"));
		Double longitude = new Double(cityCoordinates.getProperty(city+".longitude"));
		Double altitude = new Double(cityCoordinates.getProperty(city+".altitude"));
		return new LocationCoardinates(longitude, altitude, city);
	}

}
