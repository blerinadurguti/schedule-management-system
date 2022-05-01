package java_07_nga_profi;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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

	public ResultSet executeQuery(String query) {
		try {
			Statement statement = this.connection.createStatement();
			
			//statement.execute(query);
			ResultSet results = statement.executeQuery(query);
			
			return results;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}