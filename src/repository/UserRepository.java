package repository;

import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import database.InsertQueryBuilder;
import model.User;
import processor.SaltedHash;

public class UserRepository {

	private DBConnection connection;
	private SaltedHash saltedHash = new SaltedHash();
	
	public UserRepository() {
		this.connection = DBConnection.getConnection();
	}
	
	// VALIDATION
		
	public boolean validateLogin(String username, String password) throws SQLException, NoSuchAlgorithmException {
		
		User useri = findByUsername(username);		
		String salted = useri.getSalted();
		String databaseSaltedHash = useri.getSaltedHash();
		String inputSaltedHash = saltedHash.generatehash(password, salted);
		
		if(databaseSaltedHash.equals(inputSaltedHash)) {
			return true;
			}
		return false;
	}
	
//	public boolean validateChangePassword(String id, String password) throws SQLException, NoSuchAlgorithmException {
////		String username = findUsernameById(id);
////		User useri = findByUsername(username);		
//		User useri = findById(id);
//		String salted = useri.getSalted();
//		String databaseSaltedHash = useri.getSaltedHash();
//		String inputSaltedHash = saltedHash.generatehash(password, salted);
//		
//		if(databaseSaltedHash.equals(inputSaltedHash)) {
//			return true;
//			}
//		return false;
//	}
	
	public User findByUsername(String Username) throws SQLException {
		
		String a = "'" + Username + "'";
		String query = "SELECT * FROM User WHERE Username = " + a;
		ResultSet res = this.connection.executeQuery(query);
		res.next();
		return User.fromResultSet(res);
	}
	
	public User findById(String id) throws SQLException {
		
		String query = "SELECT * FROM USER WHERE ID = " + id;
		ResultSet res = this.connection.executeQuery(query);
		res.next();
		return User.fromResultSet(res);
	}
	
	public String findUsernameById(String id) throws SQLException {
		String query = "SELECT * FROM USER WHERE ID = " + id;
		ResultSet res = this.connection.executeQuery(query);
		res.next();
		return User.fromResultSet(res).getUsername();
	}
	
public int findIdByUsername(String Username) throws SQLException {
		
		String a = "'" + Username + "'";
		String query = "SELECT * FROM User WHERE Username = " + a;
		ResultSet res = connection.executeQuery(query);
		res.next();
		return User.fromResultSet(res).getId();
	}
	
	public boolean IsThereOne(String username) throws SQLException {
		String a = "'" + username + "'";
		String query = "SELECT * FROM User WHERE Username = " + a;
		ResultSet res = this.connection.executeQuery(query);
		
		if(res.next()) {
			return true;
		}
		return false;
	}
	
	//REGISTRATION
	
	public void create(User user) throws Exception {
		InsertQueryBuilder query = (InsertQueryBuilder)
				InsertQueryBuilder.create("user")
				.add("id", user.getId(), "i")
				.add("username", user.getUsername(), "s")
				.add("saltedhash", user.getSaltedHash(), "s")
				.add("salted", user.getSalted(), "s");
		
		int lastInsertedId = this.connection.execute(query);
//		User createdUser = this.findById(lastInsertedId);
//		
//		if(createdUser != null) {
//			return createdUser;
//		}
//		
//		throw new Exception("User failed to create!");
	}
	
	
	
	
	
	//OTHER METHODS
	
	public User findById(int id) throws SQLException {
		String query = "SELECT * FROM USER WHERE ID = " + id;
		ResultSet res = this.connection.executeQuery(query);
		res.next();
		return User.fromResultSet(res);
	}
	
	
	public boolean checkIfUsernameExists(String username) throws SQLException {
		String query = "SELECT * FROM USER WHERE USERNAME = '" + username + "'";
		ResultSet res = this.connection.executeQuery(query);
		
		if(res.next()) {
			return true;
		}else {
		return false;
		}
	}
	
	//update
	
	
	public void changePassword(String a, String cid) throws NoSuchAlgorithmException, SQLException {
		SaltedHash s = new SaltedHash();
		String salted = s.generateSalted();
		String SaltedHash = s.generatehash(a, salted);
		String querysh = "Update User set SaltedHash = '" + SaltedHash + "' where id = " + cid;
		this.connection.executeU(querysh);
		String querys = "UPDATE USER SET Salted = '" + salted + "' where id = " + cid;
		this.connection.executeU(querys);
	}
	
}
