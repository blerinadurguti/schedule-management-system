package repository;

import database.DBConnection;

public class StafiAkademikRepository {

	private DBConnection connection;
	
	public StafiAkademikRepository() {
		this.connection = DBConnection.getConnection();
	}
	
}
