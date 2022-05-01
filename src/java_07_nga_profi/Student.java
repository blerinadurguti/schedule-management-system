package java_07_nga_profi;


import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
	private int id;
	private String name;
	private int mosha;
	private String studentId;
	
	public static Student createFromResultSet(ResultSet res) throws Exception  {
		int id = res.getInt("id");
		String name = res.getString("emri");
		int mosha = res.getInt("mosha");
		String studentId = res.getString("studentId");
		
		return new Student(id, name, mosha, studentId);
	}
	
	public static Student createFromValues(
			int id,
			String name,
			int mosha, 
			String studentId
			) {
		return new Student(id, name, mosha, studentId);
	}
	
	private Student(int id, String name, int mosha, String studentId) {
		this.id = id;
		this.name = name;
		this.mosha = mosha;
		this.studentId = studentId;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getMosha() {
		return mosha;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMosha(int mosha) {
		this.mosha = mosha;
	}
}