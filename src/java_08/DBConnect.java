package java_08;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnect {
	private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private final String IP = "localhost:3306";
	private final String DATABASE = "sems";
	private final String USERNAME = "root";
	private final String PASSWORD = "1244561752";
	private Connection connection;
	
	public static DBConnect getConnection() {
		return new DBConnect();
	}
	
	private DBConnect() {
		this.connection = this.innitConnection();
	}
	
	private Connection innitConnection() {
		try {
			Class.forName(this.DRIVER_NAME);
			//"jdbc:mysql://{ip}/{database}" , {username}, {password}
			return DriverManager.getConnection(
						"jdbc:mysql://"+this.IP+"/"+this.DATABASE,
						this.USERNAME,
						this.PASSWORD
					);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
//
//	public ResultSet executeQuery(String query) {
//		try {
//			PreparedStatement statement = this.connection.prepareStatement(query);
//			
//			//statement.execute(query);
//			return st.executeQuery(query);
//		}catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//	
	
public ResultSet executeQuery(String query, ArrayList<Object> values) {
	try {
		PreparedStatement pst = this.connection.prepareStatement(query);
		pst.setInt(0, 0);
		pst.setString(1, "Student");
		pst.setString(2, "Student");
		
		return pst.executeQuery();
	}catch(Exception e) {
		return null;
	}	
}
	
	
}