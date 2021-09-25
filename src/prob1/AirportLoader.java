package prob1;

import java.io.FileNotFoundException;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;

public class AirportLoader {
	
	public AirportLoader() {
	}
	
	
	
	public static Map<String, Airport> getAirportMap(File file) {
		Map<String, Airport> hmAirs = new HashMap<String, Airport>();
		try {
			Scanner input = new Scanner(file);
			while(input.hasNext()) {
				String code = input.next();
				double latitude = input.nextDouble();
				double longtitude = input.nextDouble();
				String city = input.next();
				String state = input.next();
				Airport a = new Airport(code, latitude, longtitude, city, state);
				hmAirs.put(a.getCode(), a);
				
				
			}
			
			input.close();
		}
		catch (FileNotFoundException e) {
			System.out.println(e);
		}
		return hmAirs;
		
	}
	

}
