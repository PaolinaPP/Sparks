package model;

public class Admins {
	private int user_id;

	public Admins(int user_id) {
		super();
		this.user_id = user_id;
	}
	public Admins() {
		
	}
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
