package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import processor.CreateUserProcessor;
import processor.Validations;
import repository.DrejtimiRepository;
import repository.StudentRepository;
import repository.UserRepository;
import repository.VitiAkademikRepository;

public class CreateUserController implements Initializable{
	
	private Stage stage;
	private Scene scene;
	
	private Validations v = new Validations();
	private DrejtimiRepository drejtimetRepository = new DrejtimiRepository();
	private VitiAkademikRepository var = new VitiAkademikRepository();
	private StudentRepository studentRepository = new StudentRepository();
	private UserRepository userRepository = new UserRepository();
	CreateUserProcessor createUserProcessor = new CreateUserProcessor();
	private Alert a = new Alert(AlertType.NONE);
	
    @FXML
    private Label lblDrejtimi;

    @FXML
    private Label lblEmri;

    @FXML
    private Label lblGrupi;

    @FXML
    private Label lblMbiemri;

    @FXML
    private Label lblStudentId;
    
    @FXML
    private Label lblPassword;

    @FXML
    private Label lblUsername;

    @FXML
    private Label lblViti;
    
    @FXML
    private Label lblCPassword;
	
	   @FXML
	    private ChoiceBox<String> ChBoxDrejtimi;
	       
	    
	    @FXML
	    private ChoiceBox<String> ChBoxViti;	
	    
	    @FXML
	    private ChoiceBox<String> ChBoxGrupi;
	    private String[] Grupet = {"1A","1B","2A","2B","3A","3B","4A","4B","5A","5B"
				};
	    
	    @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
	    	try {
				ChBoxDrejtimi.getItems().addAll(drejtimetRepository.getDrejtimet());
				ChBoxViti.getItems().addAll(var.getVitet());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	    	ChBoxGrupi.getItems().addAll(this.Grupet);

		}
	  
	
    @FXML
    private PasswordField pswConfirmPassword;

    @FXML
    private PasswordField pswPassword;

    @FXML
    private TextField txtEmail; 

    @FXML
    private TextField txtEmri;

//    @FXML
//    private TextField txtGrupi;

    @FXML
    private TextField txtMbiemri;
    
    @FXML
    private TextField txtStudentId;

    @FXML
    private TextField txtUsername;

    @FXML
    void ClearEventHandler(ActionEvent event) {
    	pswConfirmPassword.setText("");
    	pswPassword.setText("");
    	txtEmri.setText("");
    	ChBoxGrupi.setValue(null);
    	txtMbiemri.setText("");
    	txtStudentId.setText("");
    	txtUsername.setText("");
    	this.ChBoxDrejtimi.setValue(null); 
    	ChBoxViti.setValue(null);
    	EmptyLabel();
    }

    @FXML
    void CreateEventHandler(ActionEvent event) throws Exception {
    	
    if((this.v.MatchingPasswords(pswPassword, pswConfirmPassword)) && (this.ValidateNotNull())) {
    	
    	if(!studentRepository.checkIfSIDExists(this.txtStudentId.getText())) {
    		if(!userRepository.checkIfUsernameExists(this.txtUsername.getText())) {
    			
    			String emri = this.txtEmri.getText();
    			String mbiemri = this.txtMbiemri.getText();
    			String studentId = this.txtStudentId.getText();
    			String drejtimi = this.ChBoxDrejtimi.getValue();
    			String viti = this.ChBoxViti.getValue();
    			String grupi = this.ChBoxGrupi.getValue();
    			String username = this.txtUsername.getText();
    			String password = this.pswPassword.getText();
    			
    			createUserProcessor.Create(emri, mbiemri, studentId, drejtimi, viti, grupi, username, password);
    			
    			this.a.setAlertType(AlertType.CONFIRMATION);
    			this.a.setContentText("User Created!");
    			this.a.show();
    			
    			Parent root = FXMLLoader.load(getClass().getResource("/views/log_in.fxml"));
    			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    			scene = new Scene(root);
    			stage.setScene(scene);
    			stage.show();
    			
    			this.EmptyLabel();
    		}else {
    			this.UsernameErr(lblUsername);
    		}
    	}else {
    		this.StudentIdErr(lblStudentId);
    	}   	
    	}else {
    		if(!this.v.MatchingPasswords(pswPassword, pswConfirmPassword) && !this.ValidateNotNull()) {   	
    			if(v.NullPasswordFields(pswConfirmPassword)) {
    				this.FillLabelErr(lblCPassword);
    			}else {
    				if(!this.pswConfirmPassword.equals(pswPassword)) {
    					this.PasFilledLabelErr(lblCPassword);
    				}else {
    				this.FillLabel(lblCPassword);
    					}
    				}

    			if(v.NullPasswordFields(pswPassword)) {
    				this.FillLabelErr(lblPassword);
    			}else {
    				if(!this.pswPassword.equals(pswConfirmPassword)) {
    					this.PasFilledLabelErr(lblPassword);
    				}else {
    				this.FillLabel(lblPassword);
    			}
    			}
    			
    		}else if(!this.v.MatchingPasswords(pswPassword, pswConfirmPassword)) {
    			this.PasFilledLabelErr(this.lblPassword);
    			this.PasFilledLabelErr(this.lblCPassword);
    		}else if(!this.ValidateNotNull()){
    			if(!this.v.NullPasswordFields(this.pswPassword)) {
    				this.PasFillLabel(this.lblPassword);
    			}
    			
    			if(!this.v.NullPasswordFields(pswConfirmPassword)) {
    				this.PasFillLabel(lblCPassword);
    			}
    		}
    	}
   }
    
    @FXML
    void LogIn(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/views/log_in.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
    
    private boolean ValidateNotNull() {
    
    	boolean a = this.v.NullTextFields(this.txtEmri);
    	if(a == true) {this.FillLabelErr(this.lblEmri);}else {this.FillLabel(this.lblEmri);}
    	boolean b = this.v.NullTextFields(this.txtMbiemri);
    	if(b == true) {this.FillLabelErr(this.lblMbiemri);}else {this.FillLabel(this.lblMbiemri);}
    	boolean c = this.v.NullTextFields(this.txtStudentId);
    	if(c == true) {this.FillLabelErr(this.lblStudentId);}else {this.FillLabel(this.lblStudentId);}
    	boolean d = this.v.NullChoiceBox(ChBoxGrupi);
    	if(d == true) {this.FillLabelErr(this.lblGrupi);}else {this.FillLabel(this.lblGrupi);}
    	boolean e = this.v.NullTextFields(this.txtUsername);
    	if(e == true) {this.FillLabelErr(this.lblUsername);}else {this.FillLabel(this.lblUsername);}
    	boolean f = this.v.NullPasswordFields(this.pswConfirmPassword);
    	boolean g = this.v.NullPasswordFields(this.pswPassword);
    	boolean h = this.v.NullChoiceBox(this.ChBoxDrejtimi);
    	if(h == true) {this.FillLabelErr(this.lblDrejtimi);}else {this.FillLabel(this.lblDrejtimi);}
    	boolean i = this.v.NullChoiceBox(this.ChBoxViti);
    	if(i == true) {this.FillLabelErr(this.lblViti);}else {this.FillLabel(this.lblViti);}
    	
    	if(a || b || c || d || e || f || g || h || i) {
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
    	a.setTextFill(Color.RED);
    }
    
    private void StudentIdErr(Label a) {
    	a.setText("StudentId already registered!");
    	a.setTextFill(Color.RED);
    }
    
    private void UsernameErr(Label a) {
    	a.setText("Username taken!");
    	a.setTextFill(Color.RED);
    }
    
    private void PasFillLabel(Label a) {
    	a.setText("Filled and matching!");
    	a.setTextFill(Color.GREEN);
    }
    
    private void PasFilledLabelErr(Label a) {
    	a.setText("Passwords do not match!");
    	a.setTextFill(Color.RED);
    }
    
    private void EmptyLabel() {
    	this.lblEmri.setText("");
    	this.lblMbiemri.setText("");
    	this.lblStudentId.setText("");
    	this.lblDrejtimi.setText("");
    	this.lblViti.setText("");
    	this.lblGrupi.setText("");
    	this.lblUsername.setText("");
    	this.lblPassword.setText("");
    	this.lblCPassword.setText("");
    }
        
}