package repository;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.StafiAkademik;
import model.User;
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
		return profesoriUser.fromResultSet(res);
	}


	public StafiAkademik findById2(String id) throws SQLException {
		String query = "SELECT * FROM STAFIAKADEMIK WHERE ID = " + id;
		ResultSet res = this.connection.executeQuery(query);
		res.next();
		return StafiAkademik.fromResultSet(res);
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
		return profesoriUser.fromResultSet(res).getUsername();
	}
	
	public String getProfaById(String id) throws SQLException {
	
		String query = "select * from stafiakademik where id = " + id;
		ResultSet res = this.connection.executeQuery(query);
		res.next();
		return StafiAkademik.fromResultSet(res).getEmri() + " " + StafiAkademik.fromResultSet(res).getMbiemri();
	}
	
}
