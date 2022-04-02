package views;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import processor.LoginProcessor;

public class LoginViewController {
	private LoginProcessor loginProcessor;

	public LoginViewController() {
		this.loginProcessor = new LoginProcessor();
	}
	
	// @FXML
	private TextField username;
	private PasswordField password;
	
	public void login() {
		String username = this.username.getText();
		String password = this.password.getText();
		if(this.loginProcessor.isUserValid(username, password)) {
			//vazhdojme me faqen tjeter
		}
		// alert user
		
	}
}