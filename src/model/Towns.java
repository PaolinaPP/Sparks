package model;

public class Towns {
	private int id;
	private String name;
	
	public Towns(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Towns() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
