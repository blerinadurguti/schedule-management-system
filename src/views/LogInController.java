package views;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import processor.Validations;

public class LogInController {

	private Stage stage;
	private Scene scene;
	
	private Validations v = new Validations();
	private Alert a = new Alert(AlertType.NONE);
	
    @FXML
    private CheckBox CBMbajMend;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnLogIn;

    @FXML
    private Button btnSignUp;
    
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
    
    @FXML
    void SignUp(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/model/CreateUser.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
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
