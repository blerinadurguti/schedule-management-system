package java_08_nga_profi;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
	private int id;
	private String emri;
	private String mbiemri;
	private String studentId;
	private int mosha;
	
	public static Student fromResultSet(ResultSet res) {
		try {
			int id = res.getInt("id");
			String emri = res.getString("emri");
			String mbiemri = res.getString("mbiemri");
			String studentId = res.getString("studentId");
			int mosha = res.getInt("mosha");
			return new Student(id, emri, mbiemri, studentId, mosha);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	public static Student createStudent(
			String emri, String mbiemri, String studentId, int mosha) {
		return new Student(0, emri, mbiemri, studentId, mosha);
	}
	
	private Student(
			int id, String emri, String mbiemri, String studentId, int mosha) {
		this.id = id;
		this.emri = emri;
		this.mbiemri = mbiemri;
		this.studentId = studentId;
		this.mosha = mosha;
	}

	public int getId() {
		return id;
	}

	public String getEmri() {
		return emri;
	}

	public String getStudentId() {
		return studentId;
	}

	public int getMosha() {
		return mosha;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEmri(String emri) {
		this.emri = emri;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public void setMosha(int mosha) {
		this.mosha = mosha;
	}
	
	public String getMbiemri() {
		return this.mbiemri;
	}
}