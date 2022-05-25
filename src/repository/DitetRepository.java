package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;
import model.Ditet;

public class DitetRepository {

private DBConnection connection;
	
	public DitetRepository() {
		this.connection = DBConnection.getConnection();
	}
	
	public ArrayList<Ditet> findAll() throws SQLException{
		
		String query = "SELECT * FROM DITET";
		ResultSet res = this.connection.executeQuery(query);
		ArrayList<Ditet> d = new ArrayList<Ditet>();
		
		while(res.next()) {
			d.add(Ditet.fromResultSet(res));
		}
		res.close();
		return d;
	}
	
	public String[] getDitet() throws SQLException {
		
		ArrayList<Ditet> d = findAll();
		
		String[] ditet = new String[d.size()];
		
		for(int i =0;i<d.size();i++) {
			ditet[i] = d.get(i).getDita();
		}
		return ditet;
	}
	
}
