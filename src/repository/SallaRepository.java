package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;
import model.Salla;

public class SallaRepository {

private DBConnection connection;
	
	public SallaRepository() {
		this.connection = DBConnection.getConnection();
	}

	public ArrayList<Salla> findAll() throws SQLException{
		String query = "SELECT * FROM SALLA";
		ResultSet res = this.connection.executeQuery(query);
		ArrayList<Salla> s= new ArrayList<Salla>();
		
		while(res.next()) {
			s.add(Salla.fromResultSet(res));
		}
		res.close();
		return s;
	}
	
	public String[] getSallat() throws SQLException {
	
		ArrayList<Salla> s = findAll();
		
		String[] sallat = new String[s.size()];
		
		for(int i = 0;i < s.size();i++) {
			sallat[i] = s.get(i).getEmri();
		}
		
		return sallat;
	}
	
	
}
