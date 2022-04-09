package processor;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Validations {

	public boolean NullTextFields(TextField a) {
		if(a.getText().equals("")) {
			return true;
		}else {
		return false;	
		}
	}
	
	public boolean NullPasswordFields(PasswordField a) {
		if(a.getText().equals("")) {
			return true;
		}else {
		return false;
		}
	}
	
	public boolean NullChoiceBox(ChoiceBox<String> a) {
		if(a.getSelectionModel().isEmpty()) {
			return true;
		}else {
		return false;
		}
	}
	
	public boolean MatchingPasswords(PasswordField A,PasswordField B) {
		String a = A.getText();
		String b = B.getText();
		
		if(a.equals(b)) {
			return true;
		}else {
		return false;
		}
	}
			
}
