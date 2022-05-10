package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Salla {

	private int id;
	private String emri;
	
	public static Salla fromResultSet(ResultSet res) {
		try {
			int id = res.getInt("Id");
			String emri = res.getString("Emri");
			return new Salla(id,emri);
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static Salla createSalla(
			int id, String emri
			) {
		return new Salla(id,emri);
	}
	
	public Salla(int id, String emri) {
		this.id = id;
		this.emri = emri;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmri() {
		return emri;
	}

	public void setEmri(String emri) {
		this.emri = emri;
	}

}