package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Grupi {

	private int id;
	private String emri;
	String gr;
	private int viti;
	
	public static Grupi fromResultSet(ResultSet res) {
		try {
			int id = res.getInt("Id");
			String emri = res.getString("Emri");
			String gr = res.getString("a_b");
			int viti = res.getInt("Viti");
			return new Grupi(id,emri,gr,viti);
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static Grupi createDrejtimi(
			int id, String emri, String gr, int viti
			) {
		return new Grupi(id,emri,gr,viti);
	}
	
	public Grupi(int id, String emri, String gr, int viti) {
		this.id = id;
		this.emri = emri;
		this.gr = gr;
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
	
	public String getGr() {
		return gr;
	}

	public void setGr(String gr) {
		this.gr = gr;
	}

	public int getViti() {
		return viti;
	}

	public void setViti(int viti) {
		this.viti = viti;
	}
	

}
