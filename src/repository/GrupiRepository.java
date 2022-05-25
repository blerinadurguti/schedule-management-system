package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;
import model.Grupi;

public class GrupiRepository {

	private DBConnection connection;
	
	public GrupiRepository() {
		this.connection = DBConnection.getConnection();
	}
	
	public ArrayList<Grupi> findAllTypes() throws SQLException{
	String query = "SELECT * FROM GRUPET where id in (1,2,3,4,5,6,7,8,9,10)";
	ResultSet res = this.connection.executeQuery(query);
	ArrayList<Grupi> grupi = new ArrayList<Grupi>();	
	while(res.next()) {
			grupi.add(Grupi.fromResultSet(res));
		}
	res.close();
 
		return grupi;
	}
	
	public String[] getGrupi() throws SQLException{
		ArrayList<Grupi> g = findAllTypes();
		
		String[] grupet = new String[g.size()];
		
		for(int i = 0; i< g.size();i++) {
			grupet[i] = g.get(i).getEmri() + g.get(i).getGr();
		}
		
		return grupet;
	}
	
	public int getIdByEmri(String grupi,String a_b, int vitiId) throws SQLException {
		String query = "select * from grupet where emri = '" + grupi +"' and a_b = '" + a_b + "' and Viti = " + vitiId;
		ResultSet res = this.connection.executeQuery(query);
		res.next();		
		int i = Grupi.fromResultSet(res).getId();
		res.close();
//		this.connection.close();
		return i;
	}
	
	public String getEmriById(int id) throws SQLException {
		String query = "select * from grupet where id = " + id;
		ResultSet res = this.connection.executeQuery(query);
		res.next();		
		String s = Grupi.fromResultSet(res).getEmri() + Grupi.fromResultSet(res).getGr();
		res.close();
//		this.connection.close();
		return s;
	}
	
	public String getEmriByIdS(String id) throws SQLException {
		String query = "select * from grupet where id = " + id;
		ResultSet res = this.connection.executeQuery(query);
		res.next();		
		String s = Grupi.fromResultSet(res).getEmri() + Grupi.fromResultSet(res).getGr();
		res.close();
//		this.connection.close();
		return s;
	}
	
	public String getGrupiPjesa1(String grupi) {	
		return grupi.substring(0,7);
	}	
	
	public String getNenGrupi(String grupi) {
		return grupi.substring(7,8);
	}
	
}
