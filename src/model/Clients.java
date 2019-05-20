package model;

import java.sql.Blob;

public class Clients {
	private int user_id;
	private Blob drivelic;
	private String bankcard;
	
	public Clients(int user_id, Blob drivelic, String bankcard) {
		super();
		this.user_id = user_id;
		this.drivelic = drivelic;
		this.bankcard = bankcard;
	}
	
	public Clients() {
		
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Blob getDrivelic() {
		return drivelic;
	}
	public void setDrivelic(Blob drivelic) {
		this.drivelic = drivelic;
	}
	public String getBankcard() {
		return bankcard;
	}
	public void setBankcard(String bankcard) {
		this.bankcard = bankcard;
	}
}
