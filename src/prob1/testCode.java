package prob1;


import java.util.HashMap;
import java.util.Map;

public class testCode {
public static void main ( String [] args) {
	hmExample2();
}
	public static void hmExample2() {
		System.out.println("\nHashMap Example 2\n-----------------");

		Map<String, Airport> hmAirs = new HashMap<String, Airport>();
		Airport a = new Airport ("asd", 454.45, 45.25, "ad","ad");

		hmAirs.put(a.getCode(), a);

		System.out.println("Iterate over all key-value pairs:");
		for(String key : hmAirs.keySet()) {
			System.out.printf("   key=%s, value=%s \n", key, hmAirs.get(key));
		}
	}

}
