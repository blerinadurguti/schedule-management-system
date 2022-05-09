package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Grupi {

	private int id;
	private String emri;
	private int viti;
	
	public static Grupi fromResultSet(ResultSet res) {
		try {
			int id = res.getInt("Id");
			String emri = res.getString("Emri");
			int viti = res.getInt("Viti");
			return new Grupi(id,emri,viti);
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static Grupi createDrejtimi(
			int id, String emri, int viti
			) {
		return new Grupi(id,emri,viti);
	}
	
	public Grupi(int id, String emri, int viti) {
		this.id = id;
		this.emri = emri;
		this.viti = viti;
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

	public int getViti() {
		return viti;
	}

	public void setViti(int viti) {
		this.viti = viti;
	}
	

}
