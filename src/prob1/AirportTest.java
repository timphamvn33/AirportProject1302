package prob1;


public class AirportTest {
	public static void main (String [] args) {
		testEqual();
	}
	public static void testEqual() {
		System.out.println("-----> test equal");
		Airport a = new Airport("CSG", 32.52, 84.93, "Columbus", "GA"); 
		
		Airport b = new Airport("VLD", 30.78, 83.28, "Valdosta", "GA");
		boolean x = a.equals(b);
		System.out.println(x);


}
}
