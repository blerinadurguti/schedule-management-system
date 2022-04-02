package model;

public class Login {
	private int id;
	private String username;
	private String saltedHash;
	private String salted;
	
	public Login(int id, String username, String saltedHash, String salted) {
		this.id = id;
		this.username = username;
		this.saltedHash = saltedHash;
		this.salted = salted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSaltedHash() {
		return saltedHash;
	}

	public void setSaltedHash(String saltedHash) {
		this.saltedHash = saltedHash;
	}

	public String getSalted() {
		return salted;
	}

	public void setSalted(String salted) {
		this.salted = salted;
	}

}