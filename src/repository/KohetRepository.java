package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;
import model.Kohet;

public class KohetRepository {

private DBConnection connection;
	
	public KohetRepository() {
		this.connection = DBConnection.getConnection();
	}
	
	public ArrayList<Kohet> findAll() throws SQLException{
		
		String query = "Select * from kohet";
		ResultSet res = this.connection.executeQuery(query);
		ArrayList<Kohet> k = new ArrayList<Kohet>();
		while(res.next()) {
			k.add(Kohet.fromResultSet(res));
		}
		res.close();
		return k;
	}
	
	public String[] getKohet() throws SQLException {
		
		ArrayList<Kohet> k = findAll();
		
		String [] kohet = new String[k.size()];
		
		for(int i = 0;i< k.size();i++) {
			kohet[i] = k.get(i).getKoha();
		}
	
		return kohet;
		
	}
	
}
