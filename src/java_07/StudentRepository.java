package java_07;

import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentRepository {
	private  DBConnection connection;
	
	public StudentRepository() {
		this.connection = DBConnection.getConnection();
	}
	
	public ArrayList<String> findAll(){
		String query = "SELECT ALL FROM student";
		ResultSet res = this.connection.executeQuery(query);
		ArrayList<student> students = new ArrayList<student>();
		while(res.next()) {
			students.add(student.fromResultSet(res));
		}
		return students;
	}
	
}
