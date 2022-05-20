package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Ditet {

	private int id;
	private String dita;
	
	public static Ditet fromResultSet(ResultSet res) {
		
		try {
			int id = res.getInt("id");
			String dita = res.getString("dita");
			return new Ditet(id,dita);
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public Ditet createDitet(int id, String dita) {
		return new Ditet(id,dita);
	}
	
	public Ditet(int id, String dita) {
		super();
		this.id = id;
		this.dita = dita;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDita() {
		return dita;
	}

	public void setDita(String dita) {
		this.dita = dita;
	}
	
	
}
