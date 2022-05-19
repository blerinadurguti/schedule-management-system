package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.SqlViewStudentet;

public class SqlViewStudentetRepository {

	private DBConnection connection;
	
	public SqlViewStudentetRepository() {
		this.connection = DBConnection.getConnection();
	}
	
	public ObservableList<SqlViewStudentet> getData() throws SQLException{
		ObservableList<SqlViewStudentet> obList = FXCollections.observableArrayList();
		String query = "select * from studentet";
		ResultSet res = connection.executeQuery(query);
		
		while(res.next()) {
			obList.add(SqlViewStudentet.fromResultSet(res));
		}
		
		return obList;
	}
	
}
