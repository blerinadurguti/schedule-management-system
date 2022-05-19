package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Carry {

	private int id;
	private String CID;
	
	public static Carry fromReultSet(ResultSet res) {
		
		try {
			int id = res.getInt("Id");
			String CID = res.getString("CID");
			return new Carry(id,CID);
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Carry createCarry(int id, String CID) {
		return new Carry(id,CID);
	}
	
	public Carry(int id, String cID) {
		this.id = id;
		CID = cID;
	}


	public String getCID() {
		return CID;
	}

	public void setCID(String cID) {
		CID = cID;
	}
	

	
}
