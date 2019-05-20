package model;

public class Trips {
	private int id;
	private int client_id;
	private double distance;
	private double price;
	private String startpoint;
	private String endpoint;
	private int car_id;
	
	public Trips(int id, int client_id, double distance, double price, String startpoint, String endpoint, int car_id) {
		super();
		this.id = id;
		this.client_id = client_id;
		this.distance = distance;
		this.price = price;
		this.startpoint = startpoint;
		this.endpoint = endpoint;
		this.car_id = car_id;
	}
	public Trips() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStartpoint() {
		return startpoint;
	}
	public void setStartpoint(String startpoint) {
		this.startpoint = startpoint;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
}
