package prob1;

import java.util.Comparator;
public class AirportCityComparator  implements Comparator<Airport >{
    
	public AirportCityComparator() {
		
	}
	
	
		public  int compare(Airport a1, Airport a2) {
			if((a1.getCity()).equalsIgnoreCase(a2.getCity())) {
				return (a1.getState()).compareTo(a2.getState());
			}
			else {
				return (a1.getCity()).compareTo(a2.getCity());
			
			}
					
				
	   }


		

	
}
