package model;

public class Cars {
	private int id;
	private String carnum;
	private int battery;
	private int town_id;
	private double moneypermin;
	private int clean;
	private boolean isfree;
	private String street;
	
	public Cars(int id, String carnum, int battery, int town_id, double moneypermin, int clean, boolean isfree, String street) {
		super();
		this.id = id;
		this.carnum = carnum;
		this.battery = battery;
		this.town_id = town_id;
		this.moneypermin = moneypermin;
		this.clean = clean;
		this.isfree=isfree;
		this.street=street;
		
	}
	public boolean isIsfree() {
		return isfree;
	}
	public void setIsfree(boolean isfree) {
		this.isfree = isfree;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Cars() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarnum() {
		return carnum;
	}
	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}
	public int getBattery() {
		return battery;
	}
	public void setBattery(int battery) {
		this.battery = battery;
	}
	public int getTown_id() {
		return town_id;
	}
	public void setTown_id(int town_id) {
		this.town_id = town_id;
	}
	public double getMoneypermin() {
		return moneypermin;
	}
	public void setMoneypermin(double moneypermin) {
		this.moneypermin = moneypermin;
	}
	public int getClean() {
		return clean;
	}
	public void setClean(int clean) {
		this.clean = clean;
	}
	

}
