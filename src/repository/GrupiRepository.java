package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import model.Grupi;

public class GrupiRepository {

	private DBConnection connection;
	
	public GrupiRepository() {
		this.connection = DBConnection.getConnection();
	}
	
	public int getIdByEmri(String grupi,String a_b, int vitiId) throws SQLException {
		String query = "select * from grupet where emri = '" + grupi +"' and a_b = '" + a_b + "' and Viti = " + vitiId;
		ResultSet res = this.connection.executeQuery(query);
		res.next();		
		return Grupi.fromResultSet(res).getId();
	}
	
}
