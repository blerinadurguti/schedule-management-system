package java_08_nga_profi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentRepository {
	private DBConnection connection;
	
	public StudentRepository() {
		this.connection = DBConnection.getConnection();
	}
	
	public ArrayList<Student> findAll() throws SQLException{
		String query = "SELECT * FROM STUDENT";
		ResultSet res = this.connection.executeQuery(query);
		ArrayList<Student> students = new ArrayList<Student>();
		while(res.next()) {
			students.add(Student.fromResultSet(res));
		}
		return students;
	}
	
	public Student findById(int id) throws SQLException {
		String query = "SELECT * FROM STUDENT WHERE ID = " + id;
		ResultSet res = this.connection.executeQuery(query);
		res.next();
		return Student.fromResultSet(res);
	}
	
	public Student findByStudentId(String studentId) throws SQLException {
		String query = "SELECT * FROM STUDENT WHERE STUDENTID = " + studentId;
		ResultSet res = this.connection.executeQuery(query);
		res.next();
		return Student.fromResultSet(res);
	}
	
	
	public Student create(Student student) throws Exception {
		InsertQueryBuilder query = (InsertQueryBuilder)
				InsertQueryBuilder.create("student")
				.add("id", 0, "i")
				.add("emri", student.getEmri(), "s")
				.add("mbiemri", student.getMbiemri(), "s")
				.add("studentId", student.getStudentId(), "s")
				.add("mosha", student.getMosha(), "i");
		
		int lastInsertedId = this.connection.execute(query);
		Student createdStudent = this.findById(lastInsertedId);
		
		if(createdStudent != null) {
			return createdStudent;
		}
		
		throw new Exception("Student failed to create!");
	}
	
	public Student update(Student student) throws Exception {
		UpdateQueryBuilder query = (UpdateQueryBuilder)
				UpdateQueryBuilder.create("student")
				.add("emri", student.getEmri(), "s")
				.add("mbiemri", student.getMbiemri(), "s")
				.add("studentId", student.getStudentId(), "s")
				.add("mosha", student.getMosha(), "i")
				.addWhere("id", student.getId(), "i");
		
		
		this.connection.execute(query);

		Student updatedStudent = this.findById(student.getId());
		
		if(updatedStudent != null) {
			return updatedStudent;
		}
		
		throw new Exception("Student failed to update!");
	}
}








