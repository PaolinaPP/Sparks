package model;

public class Bonuses {
	private int id;
	private int client_id;
	private double value;
	private String description;
	private int employee_id;
	private int car_id;
	
	public Bonuses(int id, int client_id, double value, String description, int employee_id, int car_id) {
		super();
		this.id = id;
		this.client_id = client_id;
		this.value = value;
		this.description = description;
		this.employee_id = employee_id;
		this.car_id = car_id;
	}
	public Bonuses() {
		
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
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

}
