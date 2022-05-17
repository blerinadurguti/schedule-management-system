package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class profesoriUser {

	private int Id; 
	private String Username;
	private String SaltedHash;
	private String Salted;
	
	
	public static profesoriUser fromResultSet(ResultSet res) {

		try {
			int id = res.getInt("Id");
			String username = res.getString("Username");
			String SaltedHash = res.getString("SaltedHash");
			String Salted = res.getString("Salted");
			return new profesoriUser(id, username, SaltedHash, Salted);			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	public static profesoriUser createUser(
			int id, String username ,String saltedHash, String salted
			) {
		return new profesoriUser(id,username,saltedHash,salted);
	}
	
	
	public profesoriUser(int id, String username, String saltedHash, String salted) {
		Id = id;
		Username = username;
		SaltedHash = saltedHash;
		Salted = salted;
	}



	public int getId() {
		return Id;
	}



	public void setId(int id) {
		Id = id;
	}



	public String getUsername() {
		return Username;
	}



	public void setUsername(String username) {
		Username = username;
	}



	public String getSaltedHash() {
		return SaltedHash;
	}



	public void setSaltedHash(String saltedHash) {
		SaltedHash = saltedHash;
	}



	public String getSalted() {
		return Salted;
	}



	public void setSalted(String salted) {
		Salted = salted;
	}
	
	
	
}
