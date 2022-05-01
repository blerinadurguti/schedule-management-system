package java_07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private static String DRIVER_NAME = "com.mysql.cj.jbdc.Driver";
	private static String IP = "localhost:3306";
	private static String DATABASE_NAME = "sems";
	private static String USER_NAME = "root";
	private static String PASSWORD = "1244561752";
	private Connection connection;
	
public static DBConnection getConnection() {
		return new DBConnection();
	}
	
	private DBConnection(){
		this.connection = this.initConnection();
	}
	
	private Connection initConnection() {
		try {
			Class.forName(DBConnection.DRIVER_NAME);
			Connection con = DriverManager.getConnection("jbdc:mysql://"
			+DBConnection.IP 
			+"/"
			+DBConnection.DATABASE_NAME,
			DBConnection.USER_NAME,
			DBConnection.PASSWORD);
			return con;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public ResultSet executeQuery(String query) {
		try {
		Statement st = this.connection.createStatement();
		ResultSet res = st.executeQuery(query);
		while(res.next()) {
			System.out.println(res.getInt("Id"));
			System.out.println(res.getString("studentId"));
		}
		return res;
		}catch(SQLException e){
		e.printStackTrace();	
		return null;
		}
		}
	
}
