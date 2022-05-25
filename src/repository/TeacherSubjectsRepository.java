package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;
import model.TeacherSubjects;

public class TeacherSubjectsRepository {

	private DBConnection connection;
	private CarryRepository carryRepository = new CarryRepository();
	
	public TeacherSubjectsRepository() {
		this.connection = DBConnection.getConnection();
	}
	
	public int[] getLendaId() throws SQLException {
		String query = "Select * from teachersubjects where profesori = " + carryRepository.getId();
		ResultSet res = this.connection.executeQuery(query);
		
		ArrayList<TeacherSubjects> Ts = new ArrayList<TeacherSubjects>();
		
		while(res.next()) {
			Ts.add(TeacherSubjects.fromResultSet(res));
		}
		res.close();
		int[] id = new int[Ts.size()];
		
		for(int i = 0; i < Ts.size();i++) {
			id[i] = Ts.get(i).getLenda();
		}
		
		return id;
	}
	
	
}
