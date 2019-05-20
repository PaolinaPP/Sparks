package model;

public class Payments {
	private int id;
	private int client_id;
	private double price;
	private String dt;
	private int trip_id;
	
	public Payments(int id, int client_id, double price, String dt, int trip_id) {
		super();
		this.id = id;
		this.client_id = client_id;
		this.price = price;
		this.dt = dt;
		this.trip_id = trip_id;
	}
	public Payments() {
		
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public int getTrip_id() {
		return trip_id;
	}
	public void setTrip_id(int trip_id) {
		this.trip_id = trip_id;
	}

}
