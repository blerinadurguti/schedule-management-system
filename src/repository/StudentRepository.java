package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;
import database.InsertQueryBuilder;
import model.Studenti;

public class StudentRepository {

	private DBConnection connection;
	
	public StudentRepository() {
		this.connection = DBConnection.getConnection();
	}
	
	public Studenti findById(int id) throws SQLException {
		String query = "SELECT * FROM STUDENTI WHERE ID = " + id;
		ResultSet res = this.connection.executeQuery(query);
		res.next();
		return Studenti.fromResultSet(res);
	}
	
	public void create(Studenti student) throws Exception {
		InsertQueryBuilder query = (InsertQueryBuilder)
				InsertQueryBuilder.create("studenti")
				.add("emri", student.getEmri(), "s")
				.add("mbiemri", student.getMbiemri(), "s")
				.add("studentId", student.getStudentId(), "s")
				.add("drejtimi", student.getDrejtimi(), "i")
				.add("viti", student.getViti(), "i")
				.add("grupi", student.getGrupi(), "i");
		
		int lastInsertedId = this.connection.execute(query);
//		Studenti createdStudent = this.findById(lastInsertedId);
//		
//		if(createdStudent != null) {
//			return createdStudent;
//		}
//		
//		throw new Exception("Student failed to create!");
	}
	
	
	public ArrayList<Studenti> findAll() throws SQLException{
		String query = "SELECT * FROM STUDENTI";
		ResultSet res = this.connection.executeQuery(query);
		ArrayList<Studenti> student = new ArrayList<Studenti>();
		
		while(res.next()) {
			student.add(Studenti.fromResultSet(res));
		}
		return student;
	}
	
	public int getIdByStudentId(String studentId) throws SQLException {
		String query = "SELECT * FROM STUDENTI WHERE STUDENTID = '" + studentId + "'";
		ResultSet res = this.connection.executeQuery(query);
		if(res.next()) {	
		return Studenti.fromResultSet(res).getId();
		}else {
			return 0;
		}
	}
	
	public boolean checkIfSIDExists(String studentId) throws SQLException {
		String query = "SELECT * FROM STUDENTI WHERE STUDENTID = '" + studentId + "'";
		ResultSet res = this.connection.executeQuery(query);
		
		if(res.next()) {
			return true;
		}else {
		return false;
		}
	}
	
}
