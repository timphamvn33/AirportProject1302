package prob1;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class AirportManagerTest {
	static final String path = "src/prob1/";
	static final String file1 = path + "airportsSameCities.txt";
	static final String file2= path + "airportsSmall.txt";
	static final String file3= path+ "airportsMedium.txt";
	public static void main(String [] args) {
		testGetDistancebyString();
		testGetDistancebyObject();
		testGetAirport();
		testGetListAirports();
		testGetListAirportsByCity();
		testGetListAirportsByCityandState();
		testGetListAirportsFollowByNWS();
		testGetListAirportsSortedByCity();
		testGetListAirportsSortedByState();
		testGetAirportsClosestToString();
		testGetAirportsWithin();
		testGetAirportsWithin2Codes();
		testGetAirportsClosestTo1();
		testGetAirportsClosestTo2();
		testGetAirportsClosestTo3();
		testGetAirportsWithinLatLon();
	}
	public static void testGetDistancebyString() {
		System.out.println("----> test distance by string");
		Map<String, Airport> hmAirs = getFile(file3);
		AirportManager a = new AirportManager(hmAirs);
		
		double ans = a.getDistanceBetween("ANB", "HSV");
		System.out.println(ans);
	}
	public static void testGetDistancebyObject() {
		System.out.println("----> test distance by object");
		Map<String, Airport> hmAirs = getFile(file2);
		AirportManager a = new AirportManager(hmAirs);
		Airport a1 = new Airport("ANB",	33.58,	85.85,	"Anniston",	"AL");
		Airport a2 = new Airport ("VLD",	30.78,	83.28,	"Valdosta", "GA");
		
	
		double ans = a.getDistanceBetween(a1, a2);
		System.out.println(ans);
	
	}
	
	public static void testGetAirport() {
		System.out.println("----> test get Airport");
		Map<String, Airport> hmAirs = getFile(file2);
		AirportManager a = new AirportManager (hmAirs);
		System.out.println(a.getAirport("ANB"));
	}
	public static void testGetListAirports() {
		System.out.println("----> test get List Airports ");
		Map<String, Airport> hmAirs = getFile(file2);
		AirportManager a = new AirportManager (hmAirs);
		System.out.println(a.getAirports());
	}
	public static void testGetListAirportsByCity() {
		System.out.println("----> test get List Airports by city ");
		Map<String, Airport> hmAirs = getFile(file1);
		AirportManager a = new AirportManager (hmAirs);
		System.out.println(a.getAirportsByCity("Greenville"));
	}
	public static void testGetListAirportsByCityandState() {
		System.out.println("----> test get List Airports by city state ");
		Map<String, Airport> hmAirs = getFile(file1);
		AirportManager a = new AirportManager (hmAirs);
		System.out.println(a.getAirportsByCityState("Greenville", "TX"));
	}
	public static void testGetListAirportsFollowByNWS() {
		System.out.println("----> test get List Airports by city state ");
		Map<String, Airport> hmAirs = getFile(file3);
		AirportManager a = new AirportManager (hmAirs);
		System.out.println(a.getNWSNamedAirports());
	}
	public static void testGetListAirportsSortedByCity() {
		System.out.println("----> test get List Airports sorted by city ");
		Map<String, Airport> hmAirs = getFile(file3);
		AirportManager a = new AirportManager (hmAirs);
		System.out.println(a.getAirportsSortedBy("City"));
	}
	public static void testGetListAirportsSortedByState() {
		System.out.println("----> test get List Airports sorted by state ");
		Map<String, Airport> hmAirs = getFile(file3);
		AirportManager a = new AirportManager (hmAirs);
		System.out.println(a.getAirportsSortedBy("state"));
	}
	public static void testGetAirportsClosestToString() {
		System.out.println("----> test get Airports closest toString");
		Map<String, Airport> hmAirs = getFile(file2);
		AirportManager a = new AirportManager (hmAirs);
		System.out.println(a.getAirportsClosestToString("HSV"));
	}
	public static void testGetAirportsWithin() {
		System.out.println("----> test get Airports with in a distance ");
		Map<String, Airport> hmAirs = getFile(file3);
		AirportManager a = new AirportManager (hmAirs);
		System.out.println(a.getAirportsWithin("ANB",150));
	}
	public static void testGetAirportsWithin2Codes() {
		System.out.println("----> test get Airports with in 2 codes ");
		Map<String, Airport> hmAirs = getFile(file3);
		AirportManager a = new AirportManager (hmAirs);
		System.out.println(a.getAirportsWithin("ANB","VLD",150));
	}
	
	public static void testGetAirportsClosestTo1() {
		System.out.println("----> test get 1 Airports closest to");
		Map<String, Airport> hmAirs = getFile(file2);
		AirportManager a = new AirportManager (hmAirs);
		System.out.println(a.getAirportsClosestTo("ANB", 1));
	}
	
	public static void testGetAirportsClosestTo2() {
		System.out.println("----> test get 2 Airports closest to ");
		Map<String, Airport> hmAirs = getFile(file2);
		AirportManager a = new AirportManager (hmAirs);
		System.out.println(a.getAirportsClosestTo("ANB", 2));
	}
	public static void testGetAirportsClosestTo3() {
		System.out.println("----> test get 3 Airports closest to ");
		Map<String, Airport> hmAirs = getFile(file2);
		AirportManager a = new AirportManager (hmAirs);
		System.out.println(a.getAirportsClosestTo("ANB", 3));
	}
	
	public static void testGetAirportsWithinLatLon() {
		System.out.println("----> test get  Airports with in to latititude and longtitude ");
		Map<String, Airport> hmAirs = getFile(file2);
		AirportManager a = new AirportManager (hmAirs);
		System.out.println(a.getAirportsWithin(150, 32.38, 86.37));
	}
	// helper method
	private static Map<String, Airport> getFile(String x) {
		File file = new File(x);
		Map<String, Airport> hmAirs = new HashMap<String, Airport> ();
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
			return hmAirs;
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
		return null;
	}

}
