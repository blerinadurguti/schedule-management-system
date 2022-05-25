package repository;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.StafiAkademik;
import model.profesoriUser;
import processor.SaltedHash;

public class StafiAkademikRepository {

	private DBConnection connection;
	private SaltedHash saltedHash = new SaltedHash();
	
	public StafiAkademikRepository() {
		this.connection = DBConnection.getConnection();
	}
	
	public ObservableList<StafiAkademik> getData() throws SQLException{
		ObservableList<StafiAkademik> obList = FXCollections.observableArrayList();
		String query = "select * from stafiakademik";
		ResultSet res = connection.executeQuery(query);
		
		while(res.next()) {
			obList.add(StafiAkademik.fromResultSet(res));
		}
		res.close();
		return obList;
	}
	
public boolean validateLogin(String username, String password) throws SQLException, NoSuchAlgorithmException {
		
		profesoriUser puseri = findByUsername(username);		
		String salted = puseri.getSalted();
		String databaseSaltedHash = puseri.getSaltedHash();
		String inputSaltedHash = saltedHash.generatehash(password, salted);
		
		if(databaseSaltedHash.equals(inputSaltedHash)) {
			return true;
			}
		return false;
	}
	
	public profesoriUser findByUsername(String username) throws SQLException {
		
		String a = "'" + username + "'";
		String query = "Select * from profesoruser where username = " + a;
		ResultSet res = this.connection.executeQuery(query);
		res.next();
		profesoriUser p = profesoriUser.fromResultSet(res);
		res.close();
		return p;
	}


	public StafiAkademik findById2(String id) throws SQLException {
		String query = "SELECT * FROM STAFIAKADEMIK WHERE ID = " + id;
		ResultSet res = this.connection.executeQuery(query);
		res.next();
		StafiAkademik s = StafiAkademik.fromResultSet(res);
		res.close();
		return s;
	}
	
	
	
	public void changePassword(String a, String cid) throws NoSuchAlgorithmException, SQLException {
		SaltedHash s = new SaltedHash();
		String salted = s.generateSalted();
		String SaltedHash = s.generatehash(a, salted);
		String querysh = "Update profesorUser set SaltedHash = '" + SaltedHash + "' where id = " + cid;
		this.connection.executeU(querysh);
		String querys = "UPDATE profesorUSER SET Salted = '" + salted + "' where id = " + cid;
		this.connection.executeU(querys);
	}
	
	public String findUsernameById(String id) throws SQLException {
		String query = "SELECT * FROM profesorUSER WHERE ID = " + id;
		ResultSet res = this.connection.executeQuery(query);
		res.next();
		String s = profesoriUser.fromResultSet(res).getUsername();
		res.close();
		return s;
	}
	
	public String getProfaById(String id) throws SQLException {
	
		String query = "select * from stafiakademik where id = " + id;
		ResultSet res = this.connection.executeQuery(query);
		res.next();
		String s = StafiAkademik.fromResultSet(res).getEmri() + " " + StafiAkademik.fromResultSet(res).getMbiemri();
		res.close();
		return s;
	}
	
	public String getProfaByIdI(int id) throws SQLException {
		
		String query = "select * from stafiakademik where id = " + id;
		ResultSet res = this.connection.executeQuery(query);
		res.next();
		String s = StafiAkademik.fromResultSet(res).getEmri() + " " + StafiAkademik.fromResultSet(res).getMbiemri();
		res.close();
		return s;
	}
	
	public ArrayList<StafiAkademik> findAll() throws SQLException{
		
		String query = "select * from stafiakademik";
		ResultSet res = this.connection.executeQuery(query);
		ArrayList<StafiAkademik> a = new ArrayList<StafiAkademik>();
		
		while(res.next()) {
			a.add(StafiAkademik.fromResultSet(res));
		}
		res.close();
		return a;
	}
	
	public String[] getProfa() throws SQLException {
		
		ArrayList<StafiAkademik> a = findAll();
		
		String[] p = new String[a.size()];
		
		for(int i = 0;i < a.size();i++) {
			p[i] = a.get(i).getEmri() + " " + a.get(i).getMbiemri();
		}
		
		return p;
	}
	
	public void addProfesori(String emri, String mbiemri, String pozita) throws SQLException {
		String query = "Insert into stafiakademik(emri,mbiemri,pozita)value('"+emri+"','"+mbiemri+"','"+pozita+"')";
		this.connection.executeU(query);
	}

	public void updateProfesori(String id, String emri, String mbiemri, String pozita) throws SQLException {
		String query = "call updateProfesori("+id+",'"+emri+"','"+mbiemri+"','"+pozita+"')";
		this.connection.executeU(query);
	}
	
	public String[] findAllPozitat() throws SQLException{
		
		ArrayList<StafiAkademik> a = new ArrayList<StafiAkademik>();;
		
		String query = "SELECT * FROM stafiakademik group by(Pozita)";
		ResultSet res = this.connection.executeQuery(query);
		
		while(res.next()) {
			a.add(StafiAkademik.fromResultSet(res));
		}
		res.close();
		String[] p = new String[a.size()];
		
		for(int i = 0;i<a.size();i++) {
			p[i] = a.get(i).getPozita();
		}
		
		return p;
	}
	
}
