package repository;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import model.profesoriUser;
import processor.SaltedHash;

public class ProfesoriUserRepository {

	private DBConnection connection;
	private SaltedHash saltedHash = new SaltedHash();
	
	
	public ProfesoriUserRepository() {
		this.connection = DBConnection.getConnection();
	}
	
	
	// VALIDATION
	
		public boolean validateLogin(String username, String password) throws SQLException, NoSuchAlgorithmException {
			
			profesoriUser useri = findByUsername(username);		
			String salted = useri.getSalted();
			String databaseSaltedHash = useri.getSaltedHash();
			String inputSaltedHash = saltedHash.generatehash(password, salted);
			
			if(databaseSaltedHash.equals(inputSaltedHash)) {
				return true;
				}
			return false;
		}
		
		public profesoriUser findByUsername(String Username) throws SQLException {
			
			String a = "'" + Username + "'";
			String query = "SELECT * FROM profesorUser WHERE Username = " + a;
			ResultSet res = this.connection.executeQuery(query);
			res.next();
			return profesoriUser.fromResultSet(res);
		}
		
		public int findIdByUsername(String Username) throws SQLException {
			
			String a = "'" + Username + "'";
			String query = "SELECT * FROM profesoruser WHERE Username = " + a;
			ResultSet res = connection.executeQuery(query);
			res.next();
			return profesoriUser.fromResultSet(res).getId();
		}
		
		public boolean IsThereOne(String username) throws SQLException {
			String a = "'" + username + "'";
			String query = "SELECT * FROM profesorUser WHERE Username = " + a;
			ResultSet res = this.connection.executeQuery(query);
			
			if(res.next()) {
				return true;
			}
			return false;
		}
	
	
}
