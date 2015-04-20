
public class Vertex {
	private int id;
	private double latitude;
	private double longitude;
	
	public Vertex(int id, double latitude, double longitude){
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public int getID(){
		return id;
	}
	
	public double getLatitude(){
		return latitude;
	}
	
	public double getLongitude(){
		return longitude;
	}
}
