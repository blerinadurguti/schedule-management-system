package java_03_nga_profi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main01 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Pane pane = new Pane();
				CreateUserForm userForm = new CreateUserForm();
				
				Scene scene = new Scene(userForm, 850, 760);
				primaryStage.setScene(scene);
				primaryStage.setTitle("Detyra e pare ne javen e trete!");
				primaryStage.show();
	}
}

class CreateUserForm extends GridPane {
	private UserRepository userRepository = new UserRepository();
	
	private TextField txtEmri;
	private PasswordField txtMbiemri;
	private ToggleGroup gender;
	private CheckBox pranoniKushtet;
	
	private void load() throws FileNotFoundException {
		FileInputStream input = 
				new FileInputStream("src/java_03_nga_profi/unipr.png");
		Image image = new Image(input);
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(150);
		imageView.setFitWidth(200);
		
		Label lblEmri = new Label("Emri: ");
		this.txtEmri = new TextField();
		this.txtEmri.setPromptText("Shkruani emrin ...");
		
		Label lblMbiemri = new Label("Mbiemri: ");
		this.txtMbiemri = new PasswordField();
		this.txtMbiemri.setPromptText("Shkruani mbiemrin ...");
		
		this.gender = new ToggleGroup();
		RadioButton female = new RadioButton("Female");
		female.setToggleGroup(this.gender);
		RadioButton male = new RadioButton("Male");
		male.setToggleGroup(gender);
		RadioButton undefined = new RadioButton("Undefined");
		undefined.setToggleGroup(gender);
		HBox genderPane = new HBox();
		genderPane.getChildren().addAll(male, female, undefined);
		genderPane.setSpacing(2.5);
		
		pranoniKushtet = 
				new CheckBox("A pranoni kushtet e vendosura ?");
		
		Button submit = new Button("Submit");
		submit.setOnAction(e -> {
			this.submitAction();
		});
		
		Button cancel = new Button("Cancel");
		cancel.setOnAction(e -> {
			this.cancelAction();
		});
		
		HBox buttonPane = new HBox();
		buttonPane.getChildren().addAll(submit, cancel);
		buttonPane.setSpacing(10);
		
		// 			Node - Column - Row
		super.getChildren().clear();
		super.add(imageView, 1, 0);
		super.add(lblEmri, 0, 1);
		super.add(txtEmri, 1, 1);
		super.add(lblMbiemri, 0, 2);
		super.add(txtMbiemri, 1, 2);
		super.add(genderPane, 1, 3);
		super.add(pranoniKushtet, 1, 4);
		super.add(buttonPane, 1, 6);
		super.setAlignment(Pos.CENTER);
		super.setVgap(10);
		super.setHgap(10);
	}
	
	public CreateUserForm() throws FileNotFoundException {
		super();
		this.load();
	}
	
	private void submitAction() {
		String emri = this.txtEmri.getText();
		String mbiemri = this.txtMbiemri.getText();
		RadioButton genderSelected =(RadioButton)this.gender.getSelectedToggle();
		String gender = genderSelected.getText();
		boolean kushtet = this.pranoniKushtet.isSelected();
		
		User user = User.fromValues(emri, mbiemri, gender, kushtet);
		user = this.userRepository.create(user);
		if(user == null) {
			Alert alert = new Alert(AlertType.ERROR, 
					"Perdoruesi nuk eshte krijuar me sukses!",
					ButtonType.OK);
			alert.showAndWait();
		}else {
			Alert alert = new Alert(AlertType.INFORMATION, 
					"Perdoruesi eshte krijuar me sukses!",
					ButtonType.OK);
			alert.showAndWait();
		}
		
		this.cancelAction();
		
	}
	
	private void cancelAction() {
		this.txtEmri.setText("");
		this.txtMbiemri.setText("");
		this.gender.selectToggle(null);
		this.pranoniKushtet.setSelected(false);
	}
	
}

class User {
	private String emri;
	private String mbiemri;
	private String gender;
	private boolean kushtet;
	
	public static User fromValues(String emri, String mbiemri, String gender, boolean kushtet) {
		// validime ...
		return new User(emri, mbiemri, gender, kushtet);
	}
	
	private User(String emri, String mbiemri, String gender, boolean kushtet) {
		this.emri = emri;
		this.mbiemri = mbiemri;
		this.gender = gender;
		this.kushtet = kushtet;
	}
	
	public String getEmri() {
		return this.emri;
	}
	
	public String getMbiemri() {
		return this.mbiemri;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public boolean getKushtet() {
		return this.kushtet;
	}
}

class UserRepository {
	
	public User create(User user) {
		// lidhja me DB
		// ruajtja e user ne table user
		return user;
	}
	
	public User update(User user) {
		// lidhja me DB
		// perditesimi i te dhenave
		return user;
	}
	
	public List<User> findAll(){
		// lidhjen me db
		// select * from user;
		return null;
	}
	
}

