package com.sap.emissionCalculator;

import java.util.Map;

/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;*/

import com.sap.DTO.Location;
import com.sap.util.ArgumentFormatUtil;

//@SpringBootApplication
public class EmissionCalculator {/*
	
	private static final Logger log = LoggerFactory.getLogger(EmissionCalculator.class);

	public static void main(String[] args) {
		
		Map<String,String> argMap = ArgumentFormatUtil.getArgumentMap(args);
		SpringApplication.run(EmissionCalculator.class, args);
		// TODO Auto-generated method stub
		
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Location location = restTemplate.getForObject(
					"https://api.openrouteservice.org/geocode/search?api_key=5b3ce3597851110001cf6248749f2d8ed5e6429994183ba2f2c81f01&text=Namibian%20Brewery", Location.class);
			log.info(location.toString());
		};
	}

*/}
