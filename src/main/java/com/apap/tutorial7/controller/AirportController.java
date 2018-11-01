package com.apap.tutorial7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apap.tutorial7.rest.Setting;

@RestController
@RequestMapping("/airport")
public class AirportController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

	
	@GetMapping(value= "/kota/{query}")
	public ResponseEntity<String> getStatus(@PathVariable("query") String query) {
		String path = Setting.airportUrl+"?apikey="+Setting.airportApikey+"&term="+query+"&country=ID";
		ResponseEntity<String> response = restTemplate.getForEntity(path, String.class);
		return response;
	}
}