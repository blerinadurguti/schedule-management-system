package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Kohet {

	int Id;
	String koha;
	
	public static Kohet fromResultSet(ResultSet res) {
		
		try {
			int id = res.getInt("Id");
			String koha = res.getString("koha");
			
			return new Kohet(id,koha);
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	public static Kohet createKohet(int id, String koha) {
		return new Kohet(id,koha);
	}
	
	public Kohet(int id, String koha) {
		super();
		Id = id;
		this.koha = koha;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getKoha() {
		return koha;
	}


	public void setKoha(String koha) {
		this.koha = koha;
	}
	
	
	
}
