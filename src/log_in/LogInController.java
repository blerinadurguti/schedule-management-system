package log_in;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import processor.Validations;

public class LogInController {

	private Validations v = new Validations();
	
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
    	
    	boolean a = this.v.NullTextFields(this.txtUsername);
    	boolean b = this.v.NullPasswordFields(this.pswPassword);
    	boolean c = this.v.SelectedCheckBox(this.CBMbajMend);
    	
    	if(a || b || !c) {
    		return false;
    	}else {
    		return true;
    	}
    }
    
}
