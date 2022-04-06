package log_in;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LogInController {

    @FXML
    private CheckBox CBMbajMend;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnLogIn;

    @FXML
    private PasswordField pswPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    void ClearButton(ActionEvent event) {
    	this.txtUsername.setText("");
    	this.pswPassword.setText("");
    	this.CBMbajMend.setSelected(false);
    }

    @FXML
    void LogInButton(ActionEvent event) {

    	if(this.CheckNull()) {
    		System.out.println("OK");
    	}else {
    		System.out.println("One or more fields unfilled!");
    	}
    	
    }

    private boolean CheckNull() {
    	String a = this.txtUsername.getText();
    	String b = this.pswPassword.getText();
    	
    	if(a.equals("") || b.equals("") || !(this.CBMbajMend.isSelected())) {
    		return false;
    	}else {
    		return true;
    	}
    }
    
}
