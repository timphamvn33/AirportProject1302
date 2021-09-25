package prob1;


public class Airport {
	private String code;
	private String city;
	private String state;
	private double latitude;
	private double longtitude;
	
	public Airport(String code, double latitude, double longtitude, String city, String state ) {
		this.code=code;
		this.latitude=latitude;
		this.longtitude=longtitude;
		this.city=city;
		this.state=state;

}
	protected Airport (String code) {
		this.code=code;
	}
	public String getCode() {
		return code;
	}
	public double getLatitude() {
		return latitude;
	}
	public double getLongtitude() {
		return longtitude;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	// equal method
	public boolean equals(Object o) {
		if(o instanceof Airport) {
			Airport a = (Airport)o;
			return(this.code==a.code || this.latitude ==a.latitude || this.longtitude==a.longtitude);
				
		}
		return false;
	
	}
	@Override
	public String toString() {
		return String.format(" Code:%s  latitude:%.2f  longtitude:%.2f  city:%s  state:%s\n\n", getCode(), getLatitude(), getLongtitude(), getCity(), getState());
	}
}
