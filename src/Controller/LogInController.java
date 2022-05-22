package Controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import processor.GjuhaProcessor;
import processor.Validations;
import repository.CarryRepository;
import repository.ProfesoriUserRepository;
import repository.UserRepository;

public class LogInController {

	private Stage stage;
	private Scene scene;
	
	private Validations v = new Validations();
	private Alert a = new Alert(AlertType.NONE);
	private UserRepository userRepository = new UserRepository();
	private ProfesoriUserRepository profesoriUserRepository = new ProfesoriUserRepository();
	private CarryRepository carryRepository = new CarryRepository();
	
    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

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
    	EmptyLabel();
    }

    @FXML
    void LogInButton(ActionEvent event) throws NoSuchAlgorithmException, SQLException, IOException {  	
    	
    	if(this.CheckNull()) {
    	
    		String username = this.txtUsername.getText();
    		String password = this.pswPassword.getText();
    		 
    		if((userRepository.IsThereOne(username)) && (userRepository.validateLogin(username, password))) {
    			if(userRepository.validateLogin(username, password)) {
        			
    				if(username.equals("admin")) {
    					carryRepository.setId(userRepository.findIdByUsername(username));
    					GjuhaProcessor g = new GjuhaProcessor();
    					Locale locale = new Locale(g.setGjuha());
    					ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
    					Parent root = FXMLLoader.load(getClass().getResource("/views/DashboardAdmin.fxml"),bundle);stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            			scene = new Scene(root);
            			stage.setScene(scene);
            			stage.setX(100);
            			stage.setY(100);
            			stage.show();
            			this.EmptyLabel();
    				}else {
   					carryRepository.setId(userRepository.findIdByUsername(username));
   					GjuhaProcessor g = new GjuhaProcessor();
   					Locale locale = new Locale(g.setGjuha());
   					ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
   					Parent root = FXMLLoader.load(getClass().getResource("/views/DashboardStudenti.fxml"),bundle);stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        			scene = new Scene(root);
        			stage.setScene(scene);
        			stage.show();
        			this.EmptyLabel();
    				}
    				
        			}else {
        				this.Wrong();
        			}
    		}else if(profesoriUserRepository.IsThereOne(username)){
    			if(profesoriUserRepository.validateLogin(username, password)) {
    				
    				carryRepository.setId(profesoriUserRepository.findIdByUsername(username));
    				
    				GjuhaProcessor g = new GjuhaProcessor();
    				Locale locale = new Locale(g.setGjuha());
    				ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
    				Parent root = FXMLLoader.load(getClass().getResource("/views/Dashboard.fxml"),bundle);stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        			scene = new Scene(root);
        			stage.setScene(scene);
        			stage.show();
        			this.EmptyLabel();
    			}else {
    				this.PWrong();
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
    void SignUp(ActionEvent event) throws IOException, SQLException {
    	GjuhaProcessor g = new GjuhaProcessor();
		Locale locale = new Locale(g.setGjuha());
		ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
		Parent root = FXMLLoader.load(getClass().getResource("/views/CreateUser.fxml"),bundle);stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void login(KeyEvent event) throws NoSuchAlgorithmException, SQLException, IOException {
    if(event.getCode()== KeyCode.ENTER){
    if(this.CheckNull()) {
       
        String username = this.txtUsername.getText();
        String password = this.pswPassword.getText();
       
        if((userRepository.IsThereOne(username)) && (userRepository.validateLogin(username, password))) {
        if(userRepository.validateLogin(username, password)) {
           
        if(username.equals("admin")) {
        carryRepository.setId(userRepository.findIdByUsername(username));
        GjuhaProcessor g = new GjuhaProcessor();
        Locale locale = new Locale(g.setGjuha());
        ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
        Parent root = FXMLLoader.load(getClass().getResource("/views/DashboardAdmin.fxml"),bundle);stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                this.EmptyLabel();
        }else {
        carryRepository.setId(userRepository.findIdByUsername(username));
        GjuhaProcessor g = new GjuhaProcessor();
        Locale locale = new Locale(g.setGjuha());
        ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
        Parent root = FXMLLoader.load(getClass().getResource("/views/DashboardStudenti.fxml"),bundle);stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            this.EmptyLabel();
        }
       
            }else {
            this.Wrong();
            }
        }else if(profesoriUserRepository.IsThereOne(username)){
        if(profesoriUserRepository.validateLogin(username, password)) {
       
        carryRepository.setId(profesoriUserRepository.findIdByUsername(username));
        GjuhaProcessor g = new GjuhaProcessor();
        Locale locale = new Locale(g.setGjuha());
        ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
        Parent root = FXMLLoader.load(getClass().getResource("/views/Dashboard.fxml"),bundle);stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            this.EmptyLabel();
        }else {
        this.PWrong();
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
    
    private void Wrong() {
    	this.lbl2.setText("Student Password wrong!");
    	this.lbl2.setTextFill(Color.RED);    	
    }    
    
    private void PWrong() {
    	this.lbl2.setText("Profesor Password wrong!");
    	this.lbl2.setTextFill(Color.RED);    	
    }
    
}
