package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;
import model.Drejtimi;
import model.VitiAkademik;

public class VitiAkademikRepository {

	private DBConnection connection;
	
	public VitiAkademikRepository() {
		this.connection = DBConnection.getConnection();
	}
	
	public ArrayList<VitiAkademik> findAll() throws SQLException{
		String query = "SELECT * FROM VITIAKADEMIK";
		ResultSet res = this.connection.executeQuery(query);
		ArrayList<VitiAkademik> viti = new ArrayList<VitiAkademik>();

			while(res.next() != false) {
				viti.add(VitiAkademik.fromResultSet(res));
			}
		return viti;
	}
	
	public String[] getVitet() throws SQLException {
		ArrayList<VitiAkademik> v = findAll();
		
		String[] vitet = new String[v.size()];
		
		for (int i = 0; i < v.size(); i++) {
			vitet[i] = v.get(i).getViti();
        }
		
		return vitet;
	}
	
	public int getIdByEmri(String viti) throws SQLException {
		String query = "SELECT * FROM VITIAKADEMIK WHERE VITI = '" + viti + "'";
		ResultSet res = this.connection.executeQuery(query);
		res.next();		
		return VitiAkademik.fromResultSet(res).getId();
	}
	
	public String getEmriById(int id) throws SQLException {
		
		String query = "SELECT * FROM VITIAKADEMIK WHERE ID = " + id;
		ResultSet res = this.connection.executeQuery(query);
		res.next();
		return VitiAkademik.fromResultSet(res).getViti();
	}
	
public String getEmriBySId(String id) throws SQLException {
		
		String query = "SELECT * FROM VITIAKADEMIK WHERE ID = " + id;
		ResultSet res = this.connection.executeQuery(query);
		res.next();
		return VitiAkademik.fromResultSet(res).getViti();
	}
	
}
