package prob1;

import java.util.Collections;

import java.util.List;
import java.util.HashMap;
//import java.util.HashSet;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;



public class AirportManager {
	

	private Map<String, Airport> hmAirs;
	public AirportManager (Map<String, Airport> hmAirs) {
		this.hmAirs = hmAirs;
	}
	// method to get the distance between 2 codes
	public double getDistanceBetween(String code1, String code2) {
		
		Airport a1 = hmAirs.get(code1);
		Airport a2 = hmAirs.get(code2);
		 return DistanceCalculator.getDistance(a1.getLatitude(), a1.getLongtitude(), a2.getLatitude(), a2.getLongtitude());
		

 
	}
	// method to get distance between 2 airports
	public double getDistanceBetween(Airport a1, Airport a2) {
		return DistanceCalculator.getDistance(a1.getLatitude(), a1.getLongtitude(), a2.getLatitude(), a2.getLongtitude());

		
	}
	// get airport method
	public Airport getAirport(String code) {
		return hmAirs.get(code);
	}
	
	
	//method to get list of airports
	public List<Airport> getAirports(){
		List<Airport> airports = new ArrayList<>();
		for(Airport values: hmAirs.values()) {
			airports.add(values);
		}
		return airports;
	}
	// method to get the list of airports by city
	public List<Airport> getAirportsByCity(String city){
		List<Airport> airports = new ArrayList<>();
		for(Airport values: hmAirs.values()) {
			if(values.getCity().equals(city)) {
				airports.add(values);
			}
			
		}
		return airports;
	}
	// method to get list of airports by city and state
	public List<Airport> getAirportsByCityState(String city, String state){
		List<Airport> airports = new ArrayList<>();
		for(Airport values: hmAirs.values()) {
			if(values.getState().equals(state) && values.getCity().equals(city)) {
				airports.add(values);
			}
		}
		return airports;
		
	}
	// method to get list of airports whose code follows NWS
	public List<Airport> getNWSNamedAirports(){
		List<Airport> airports = new ArrayList<>();
		for(Airport values: hmAirs.values()) {
			String a = "X";
			if(values.getCode().contains(a)) {
				airports.add(values);
			}
		}
		return airports;
		 
	}
	// method to get list of airports that are sorted according to sort type
	public List<Airport> getAirportsSortedBy(String sortType){
		List<Airport> airports=getAirports();
		
		if(sortType.equalsIgnoreCase("city")) {
			 Collections.sort(airports, new AirportCityComparator());
		}
		if(sortType.equalsIgnoreCase("state")) {
			 Collections.sort(airports, new AirportStateComparator());
		}
		return airports;
	    
		
		
    }
	// get airports closest toString method
		public Airport getAirportsClosestToString(String code) {
			
			double dist = 0.0;
			int equal = 0;
            
			List<Double> distances = new ArrayList<>();
			Map<String, Double> hmCodes = new HashMap <>();
			for (Airport values1: hmAirs.values()) {
				if(values1.getCode().equals(code)){
					equal++;
				}
				
			}
			
			if(equal == 1) {
			   Airport a1 = getAirport(code); 
					
			
			   for(Airport values: hmAirs.values()) {
				   
				 
				   if( getDistanceBetween( a1, values) != 0) {
					  dist = getDistanceBetween(a1, values);
					  distances.add(dist);
					  hmCodes.put(values.getCode(), dist );
				   }
			 }
			   String ans = "";
			   Collections.sort(distances);
			   double min = distances.get(1);
			   for(String key: hmCodes.keySet()) {
			   if(hmCodes.get(key)== min) {
					ans = key;
				}
			}
				
			return hmAirs.get(ans) ;
			}
			return null;

		}
	// method get the list of Airports which are within a distance of the airport with code
		public List<Airport> getAirportsWithin(String code, double withinDist){
			List<Airport> airports = new ArrayList<>();
			
			for(Airport values: hmAirs.values()) {
				
				if(getDistanceBetween(values.getCode(), code) <= withinDist) {
					airports.add(values);
				}
			}
			return airports;
		}
	// method get a list of Airports which are within distance of both the airports 
		public List<Airport> getAirportsWithin(String code1, String code2, double withinDist){
			List<Airport> listReturn = new ArrayList<Airport>();
			List<Airport> airports = new ArrayList<>();
			List<Airport> airports2 = new ArrayList<>();
			airports = getAirportsWithin(code1, withinDist);
			airports2= getAirportsWithin(code2, withinDist);
			for(Airport a: airports) {
				for(Airport a2: airports2) {
					if(a.equals(a2)) {
						listReturn.add(a);
					}
				}
			}
		 return listReturn;
      }
	//method to get a list of Airports that closest to the Airport with code
		public List<Airport> getAirportsClosestTo(String code, int num){
			List<Airport> airports = new ArrayList<Airport>();
			Map<String, Double> hmCodes = new HashMap<>();
			double dist = 0.0;
			
			Airport a1 = getAirport(code);
			
			List<Double> distances = new ArrayList<>();
			int equal = 0;
			for(Airport values: hmAirs.values()) {
				if(values.getCode().equals(code)){
					equal++;
				}
			}
			if(num>=0 && num<hmAirs.size() && equal ==1 ) {
				
				for(Airport values: hmAirs.values()) {
					   
					 
					   if( getDistanceBetween( a1, values) != 0) {
						  dist = getDistanceBetween(a1, values);
						  distances.add(dist);
						  hmCodes.put(values.getCode(), dist );
					   }
				 }
				for(int j =1; j< num+1; j++) {
				   String ans = "";
				   Collections.sort(distances);
				   double min = distances.get(j);
				   for(String key: hmCodes.keySet()) {
				   if(hmCodes.get(key)== min) {
						ans = key;
						
					}
				   }
				   airports.add(hmAirs.get(ans));
				   
				}
				return airports;
		    }
			return null;
         }
		// a method to get a list of Airports with in distance to the lat and lon 
		public List<Airport> getAirportsWithin( double withinDist, double lat, double lon){
			
			String code = "c", city = "ci", state = "st";
			Airport a = new Airport(code, lat, lon, city, state);
			
			Airport b = new Airport (null);
			for(Airport values: hmAirs.values()) {
				if(values.equals(a)) {
					
					b= values;
				}
			}
			
				return getAirportsWithin(b.getCode(), withinDist);
			
		}

}

