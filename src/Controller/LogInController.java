package Controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import processor.Validations;
import repository.UserRepository;

public class LogInController {

	private Stage stage;
	private Scene scene;
	
	private Validations v = new Validations();
	//alertin duhet me e hek ne nderkoh me gjasa sna vyn
	private Alert a = new Alert(AlertType.NONE);
	private UserRepository userRepository = new UserRepository();
	
    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;
	
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
    	EmptyLabel();
    }

    @FXML
    void LogInButton(ActionEvent event) throws NoSuchAlgorithmException, SQLException, IOException {  	
    	
    	if(this.CheckNull()) {
    	
    		String username = this.txtUsername.getText();
    		String password = this.pswPassword.getText();
    		    		
    		if(userRepository.IsThereOne(username)) {
    			if(userRepository.validateLogin(username, password)) {
        			
        			Parent root = FXMLLoader.load(getClass().getResource("/views/Home.fxml"));
        			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        			scene = new Scene(root);
        			stage.setScene(scene);
        			stage.show();
        			this.EmptyLabel();
        			}
    		}else {
    			NotMatching();
    		}
    	}else {
    		if(this.v.NullTextFields(this.txtUsername)) {
    			this.FillLabelErr(this.lbl1);
    		}else {
    			this.FillLabel(this.lbl1);
    		}
    		
    		if(this.v.NullPasswordFields(this.pswPassword)) {
    			this.FillLabelErr(this.lbl2);
    		}else {
    			this.FillLabel(this.lbl2);
    		}
    	}
    	
    }
    
    @FXML
    void SignUp(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/views/CreateUser.fxml"));
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
    
    private void FillLabel(Label a) {
    	a.setText("Filled!");
    	a.setTextFill(Color.GREEN);
    }
    
    private void FillLabelErr(Label a) {
    	a.setText("Field must be filled!");
    }
    private void EmptyLabel() {
    	this.lbl1.setText("");
    	this.lbl1.setTextFill(Color.RED);
    	this.lbl2.setText("");
    	this.lbl2.setTextFill(Color.RED);
    }
    
    private void NotMatching() {
    	this.lbl1.setText("Username or Password not matching!");
    	this.lbl2.setText("Username or Password not matching!");
    	this.lbl1.setTextFill(Color.RED);
    	this.lbl2.setTextFill(Color.RED);
    }
    
}
