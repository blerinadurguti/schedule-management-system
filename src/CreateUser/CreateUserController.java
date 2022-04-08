package CreateUser;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import processor.Validations;

public class CreateUserController implements Initializable{

	private Validations v = new Validations();
	private Alert a = new Alert(AlertType.NONE);
	
	   @FXML
	    private ChoiceBox<String> ChBoxDrejtimi;
	    private String[] Drejtimi = {"Automatik� e Kompjuterizuar dhe Robotik�",
	    								"Elektroenergjetik�",
	    								"Elektronik�",
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

    if((this.v.MatchingPasswords(pswPassword, pswConfirmPassword)) && (this.ValidateNotNull())) {
    	this.a.setAlertType(AlertType.CONFIRMATION);
		this.a.setContentText("User Created!");
		this.a.show();
    	}else {
    		if(!this.v.MatchingPasswords(pswPassword, pswConfirmPassword) && !this.ValidateNotNull()) {
    			this.a.setAlertType(AlertType.ERROR);
    			this.a.setContentText("The passwords do not match!\nOne ore more fields unfilled!");
    			this.a.show();
    		}else if(!this.v.MatchingPasswords(pswPassword, pswConfirmPassword)) {
    			this.a.setAlertType(AlertType.ERROR);
    			this.a.setContentText("The passwords do not match!");
    			this.a.show();
    		}else if(!this.ValidateNotNull()){
    			this.a.setAlertType(AlertType.ERROR);
    			this.a.setContentText("One ore more fields unfilled!");
    			this.a.show();
    		}
    	}
   }
    private boolean ValidateNotNull() {
    
    	boolean a = this.v.NullTextFields(this.txtEmri);
    	boolean b = this.v.NullTextFields(this.txtMbiemri);
    	boolean c = this.v.NullTextFields(this.txtEmail);
    	boolean d = this.v.NullTextFields(this.txtGrupi);
    	boolean e = this.v.NullTextFields(this.txtUsername);
    	boolean f = this.v.NullPasswordFields(this.pswConfirmPassword);
    	boolean g = this.v.NullPasswordFields(this.pswPassword);
    	boolean h = this.v.NullChoiceBox(this.ChBoxDrejtimi);
    	boolean i = this.v.NullChoiceBox(this.ChBoxViti);
    	
    	if(a || b || c || d || e || f || g || h || i) {
    		return false;
    	}else {
    		return true;
    	}
    }
        
}