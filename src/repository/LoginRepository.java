package repository;

import model.Login;

public class LoginRepository {
	public Login findOne(String username) {
		// DB
		// return null;
		return new Login(1,"admin","saltedhash", "salted");
	}
}