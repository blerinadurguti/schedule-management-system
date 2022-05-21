package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherSubjects {

	private int Id,profesori,lenda;

	public static TeacherSubjects fromResultSet(ResultSet res) {

		try {
			int id = res.getInt("Id");
			int profesori = res.getInt("profesori");
			int lenda = res.getInt("lenda");
			return new TeacherSubjects(id,profesori,lenda);
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static TeacherSubjects createTeacherSubjects(int id, int profesori, int lenda) {
		return new TeacherSubjects(id,profesori,lenda);
	}
	
	public TeacherSubjects(int id, int profesori, int lenda) {
		super();
		Id = id;
		this.profesori = profesori;
		this.lenda = lenda;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getProfesori() {
		return profesori;
	}

	public void setProfesori(int profesori) {
		this.profesori = profesori;
	}

	public int getLenda() {
		return lenda;
	}

	public void setLenda(int lenda) {
		this.lenda = lenda;
	}
	
	
	
}
