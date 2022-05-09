package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VitiAkademik {

	private int id;
	private String Viti;
	
	public static VitiAkademik fromResultSet(ResultSet res) {
		try {
			int id = res.getInt("Id");
			String viti = res.getString("Viti");
			return new VitiAkademik(id,viti);
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static VitiAkademik createVitiAkademik(
			int id, String viti
			) {
		return new VitiAkademik(id,viti);
	}
	
	private VitiAkademik(int id, String viti) {
		this.id = id;
		Viti = viti;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getViti() {
		return Viti;
	}

	public void setViti(String viti) {
		Viti = viti;
	}
	
}
