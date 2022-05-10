package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Oraret {

	private int id;
	private String orari;
	
	public static Oraret fromResultSet(ResultSet res) {
		try {
			int id = res.getInt("Id");
			String orari = res.getString("Orari");
			return new Oraret(id,orari);
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static Oraret createOraret(
			int id, String orari
			) {
		return new Oraret(id,orari);
	}
	
	public Oraret(int id, String orari) {
		this.id = id;
		this.orari = orari;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOraret() {
		return orari;
	}

	public void setOraret(String orari) {
		this.orari = orari;
	}

}