package CreateUser;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CreateUserController implements Initializable{

	   @FXML
	    private ChoiceBox<String> ChBoxDrejtimi;
	    private String[] Drejtimi = {"Automatikë e Kompjuterizuar dhe Robotikë",
	    								"Elektroenergjetikë",
	    								"Elektronikë",
	    								"Inxhinieri Kompjuterike",
	    								"Telekomunikacion"
	    								};
	       
	    
	    @FXML
	    private ChoiceBox<String> ChBoxViti;	
	    private String[] Viti = {"Viti 1","Viti 2","Viti 3"};
	    
	    
	    @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
	    	ChBoxDrejtimi.getItems().addAll(Drejtimi);
	    	ChBoxViti.getItems().addAll(Viti);
	    	
		}
	   
	    
	
    @FXML
    private PasswordField pswConfirmPassword;

    @FXML
    private PasswordField pswPassword;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEmri;

    @FXML
    private TextField txtGrupi;

    @FXML
    private TextField txtMbiemri;

    @FXML
    private TextField txtUsername;

    @FXML
    void ClearEventHandler(ActionEvent event) {
    	txtEmail.setText("");
    	pswConfirmPassword.setText("");
    	pswPassword.setText("");
    	txtEmri.setText("");
    	txtGrupi.setText("");
    	txtMbiemri.setText("");
    	txtUsername.setText("");
    	this.ChBoxDrejtimi.setValue(null); 
    	ChBoxViti.setValue(null);
    }

    @FXML
    void CreateEventHandler(ActionEvent event) {
    	if((this.ValidatePassword()) && (this.ValidateNotNull())) {
    		System.out.println("OK");
    	}else if(!this.ValidatePassword()){
    		System.out.println("The passwords do not match!");
    	}else {
    	System.out.println("One ore more fields unfilled");	
    	}
    }

    private boolean ValidatePassword() {
    	String a = pswPassword.getText();
    	String b = pswConfirmPassword.getText();
    	if(a.equals(b)) {
    		return true;
    	}else {
    	return false;
    	}
    }
	
    private boolean ValidateNotNull() {
    	String Emri = txtEmri.getText();
    	String Mbiemri = txtMbiemri.getText();
    	String Email = txtEmail.getText();
    	String Username = txtUsername.getText();
    	String Grupi = txtGrupi.getText();
    	String Password = pswPassword.getText();
    	String CPassword = pswConfirmPassword.getText();
    	if(Emri.equals("") || Mbiemri.equals("") || Email.equals("") || Username.equals("") || Grupi.equals("") || Password.equals("") || CPassword.equals("") || this.ValidateChoiceBox()) {
    	return false;
    	}else {
    		return true;
    	}   	
    }
    
    private boolean ValidateChoiceBox() {
    	
    	if(this.ChBoxDrejtimi.getSelectionModel().isEmpty() || this.ChBoxViti.getSelectionModel().isEmpty()) {
    		return true;
    	}else {
    		return false;
    	}
    }
        
}
