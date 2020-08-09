package com.mercedes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

@EnableAsync
@SpringBootApplication
public class MainApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(MainApplication.class, args);
    }
	
    //Coordinates for Cities are received from city_coordinates.properties.
    @Bean
	public Properties getCityProprties() throws IOException {
		InputStream inputStream;
		Properties properties = new Properties();
		inputStream = new FileInputStream(ResourceUtils.getFile("classpath:city_coordinates.properties"));
		properties.load(inputStream);
		return properties;
	  }
	 
    //Singleton Bean(RestTemplate Type) is created for calling URLs.
    @Bean
    public RestTemplate getRestTemplateInstance() {
    	return new RestTemplate();
    }
    
    //Bean of Type Executor for Asynchronous calls.
    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        return executor;
    }
}
