package model;

public class Employees {
	private int user_id;
	private String possition;
	
	public Employees(int user_id, String possition) {
		super();
		this.user_id = user_id;
		this.possition = possition;
	}
	
	public Employees() {
		
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getPossition() {
		return possition;
	}
	public void setPossition(String possition) {
		this.possition = possition;
	}
}
