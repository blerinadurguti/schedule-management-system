package java_08;


import java.sql.ResultSet;
import java.util.ArrayList;

// findAll() - returns all rows from table
// findOneById() - return a row with corresponding id
// update() - update a row on table
// delete() - delete row from table 
// create() - create a new row on table

public class StudentRepository {
	private static String TABLE_NAME = "STUDENT";
	private DBConnect connection;

	public StudentRepository() {
		this.connection = DBConnect.getConnection();
	}

	public ArrayList<Student> findAll(){
		try {
			String query = "SELECT * FROM " + StudentRepository.TABLE_NAME;
			ResultSet stdRes = this.connection.executeQuery(query);
			
			
			ArrayList<Student> students = new ArrayList<Student>();
			while(stdRes.next()) {
				students.add(Student.createFromResultSet(stdRes));
			}
			return students;
		}catch(Exception e) {
			System.out.println(e.getMessage());

			return null;
		}
	}
	
	public Student getOneById(int id) {
		try {
			String query = "SELECT * FROM " + StudentRepository.TABLE_NAME + " WHERE ID = " + id;
			ResultSet res = this.connection.executeQuery(query);
			if(res.next()) {
				return Student.createFromResultSet(res);
			}
			return null;
		}catch(Exception e) {
			return null;
		}
	}
	
}