package com.mercedes.near_by_locations;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/*
 * while testing please change active apiKey in application.properties
 */

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDistanceController {
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	
	@Before
	public  void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	/*
	 * tried to check each item category but there is NO consistency in category title.
	 */
	@Test
	public void testNearestItemsByCategories() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/city").param("city","berlin"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.response.message").value("Data Received"))
			.andExpect(jsonPath("$.response.restaurants").isNotEmpty())
			.andExpect(jsonPath("$.response.restaurants.length()").value("3"))
			.andExpect(jsonPath("$.response.petrolStations").isNotEmpty())
			.andExpect(jsonPath("$.response.petrolStations.length()").value("3"))
			.andExpect(jsonPath("$.response.shoppings").isNotEmpty())
			.andExpect(jsonPath("$.response.shoppings.length()").value("3"));

	}

}
