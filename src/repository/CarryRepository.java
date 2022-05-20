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
	
	public Carry getCarry() throws SQLException {
		
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
	
	public void setIdGjuha() throws SQLException {
		String CID = getIdGjuha();
		String query;
		if(CID.equals("0")) {
			query = "Update Carry set CID = '1' where ID = 3";
			this.connection.executeU(query);
		}else if(CID.equals("1")) {
			query = "UPDATE CARRY SET CID = '0' WHERE ID = 3";
			this.connection.executeU(query);
		}else {
			query = "UPDATE CARRY SET CID = '0' WHERE ID = 3";
			this.connection.executeU(query);
		}
	}
	
	public String getIdOraret() throws SQLException {
		String query = "Select * from Carry where id = 2";
		ResultSet res = this.connection.executeQuery(query);
		res.next();
		return Carry.fromReultSet(res).getCID();
	}
	
	public String getIdGjuha() throws SQLException {
		
		String query = "Select * from Carry where id = 3";
		ResultSet res = this.connection.executeQuery(query);
		res.next();
		
		return Carry.fromReultSet(res).getCID();
	}
	
}
