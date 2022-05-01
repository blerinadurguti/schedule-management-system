package processor;

import model.Login;

import repository.LoginRepository;

public class LoginProcessor {
	private LoginRepository loginRepository;
	
	public LoginProcessor() {
		this.loginRepository = new LoginRepository();
	}
	
	public boolean isUserValid(String username, String password) {
		Login loginUser = this.loginRepository.findOne(username);
		if(loginUser == null) {
			return false;
		}
		
		String saltedHash = GenerateHash.generate(password, loginUser.getSalted());
		
		if(loginUser.getSaltedHash().equals(saltedHash)) {
			return true;
		}
		
		return false;
	}
}