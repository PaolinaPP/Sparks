package model;

public class Users {

	private int id;
	private String fname;
	private String lname;
	private String address;
	private String egn;
	private String password;
	private String possition;
	private String phone;
	private String email;
	
	public Users(int id, String fname, String lname, String address, String egn, String password, String possition,
			String phone, String email) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.egn = egn;
		this.password = password;
		this.possition = possition;
		this.phone = phone;
		this.email = email;
	}
	
	public Users() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEgn() {
		return egn;
	}
	public void setEgn(String egn) {
		this.egn = egn;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPossition() {
		return possition;
	}
	public void setPossition(String possition) {
		this.possition = possition;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
