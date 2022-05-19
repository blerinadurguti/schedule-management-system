package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.StafiAkademik;

public class StafiAkademikRepository {

	private DBConnection connection;
	
	public StafiAkademikRepository() {
		this.connection = DBConnection.getConnection();
	}
	
	public ObservableList<StafiAkademik> getData() throws SQLException{
		ObservableList<StafiAkademik> obList = FXCollections.observableArrayList();
		String query = "select * from stafiakademik";
		ResultSet res = connection.executeQuery(query);
		
		while(res.next()) {
			obList.add(StafiAkademik.fromResultSet(res));
		}
		
		return obList;
	}
	
}
