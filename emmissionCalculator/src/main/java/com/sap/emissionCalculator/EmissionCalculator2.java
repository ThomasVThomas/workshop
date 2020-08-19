package com.sap.emissionCalculator;

import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sap.util.ArgumentFormatUtil;

public class EmissionCalculator2 {
	
	
	public static void main(String[] args) {
		
		Map<String,String> argMap = ArgumentFormatUtil.getArgumentMap(args);
		
		getLocation(argMap.get("start"));
		getLocation(argMap.get("end"));
		
		System.out.println("test value");
	}
		
	
	
	
		private static String[] getLocation(String location){
			String[] locationPoints = new String[2];
			
			Client client = ClientBuilder.newClient();
			Response response = client.target("http://api.openrouteservice.org/geocode/search?api_key=5b3ce3597851110001cf6248749f2d8ed5e6429994183ba2f2c81f01&text=Namibian%20Brewery")
			  .request(MediaType.TEXT_PLAIN_TYPE)
			  .header("Accept", "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8")
			  .get();

			
	
			
			return locationPoints;
		}
	

	
}
