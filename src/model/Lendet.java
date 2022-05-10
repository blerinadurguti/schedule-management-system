package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Lendet{

	private int id;
	private String emri;
	
	public static Lendet fromResultSet(ResultSet res) {
		try {
			int id = res.getInt("Id");
			String emri = res.getString("Emri");
			return new Lendet(id,emri);
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lendet createLendet(
			int id, String emri
			) {
		return new Lendet(id,emri);
	}
	
	public Lendet(int id, String emri) {
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