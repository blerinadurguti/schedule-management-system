package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;
import model.Lendet;

public class LendetRepository {

	private DBConnection connection;
	private TeacherSubjectsRepository teacherSubjectsRepository = new TeacherSubjectsRepository();
	
	public LendetRepository() {
		this.connection = DBConnection.getConnection();
	}
	
	public ArrayList<Lendet> findAllByProfesor() throws SQLException{
		String a = "";
		a = id2String(a);
		String query = "select * from lendet where Id in (" + a + ")";
		ResultSet res = this.connection.executeQuery(query);
		ArrayList<Lendet> l = new ArrayList<Lendet>();
		
		while(res.next()) {
			l.add(Lendet.fromResultSet(res));
		}
		
		return l;
	}
	
	public String id2String(String a) throws SQLException {
		String b = a;
		int[] id = teacherSubjectsRepository.getLendaId();
		
		for(int i = 0; i < id.length;i++) {
			b = b + id[i] + ",";
		}
		
		b = b.substring(0,b.length()-1);
		
		return b;
	}
	
	public String[] getLendet() throws SQLException {
		ArrayList<Lendet> l = findAllByProfesor();
		
		String[] lendet = new String[l.size()];
		
		for(int i = 0;i < l.size();i++) {
			lendet[i] = l.get(i).getEmri();
		}
		
		return lendet;
	}
	
}
