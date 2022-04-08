package log_in;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import processor.Validations;

public class LogInController {

	private Validations v = new Validations();
	private Alert a = new Alert(AlertType.NONE);
	
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
    		this.a.setAlertType(AlertType.CONFIRMATION);
    		this.a.setContentText("Loged In!");
    		this.a.show();
    	}else {
    		this.a.setAlertType(AlertType.ERROR);
    		this.a.setContentText("One or more fields unfilled!");
    		this.a.show();
    	}
    	
    }

    private boolean CheckNull() {
    	
    	boolean a = this.v.NullTextFields(this.txtUsername);
    	boolean b = this.v.NullPasswordFields(this.pswPassword);
       	
    	if(a || b) {
    		return false;
    	}else {
    		return true;
    	}
    }
    
}
