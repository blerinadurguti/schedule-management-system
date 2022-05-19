package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import model.Carry;

public class CarryRepository {

	private DBConnection connection;
	
	public CarryRepository() {
		this.connection = DBConnection.getConnection();
	}
	
	public String getId() throws SQLException {
		Carry c = getCarry();
		return c.getCID();
	}
	
	private Carry getCarry() throws SQLException {
		
		String query = "Select * from Carry where id = 1";
		ResultSet res = this.connection.executeQuery(query);
		res.next();
		
		return Carry.fromReultSet(res);
	}

	public void setId(int id) throws SQLException {
		
		String a = "'" + id + "'";
		String query = "UPDATE CARRY SET CID = " + a + " WHERE ID = 1";
		this.connection.executeU(query);
		
	}
	
	
}
