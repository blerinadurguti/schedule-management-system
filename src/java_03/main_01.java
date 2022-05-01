package java_03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class main_01 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		CreateUserForm form = new CreateUserForm();
		
		Scene scene = new Scene(form,870,560);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Detyra e pare ne javen e trete!");
		primaryStage.show();
	}

}


class CreateUserForm extends GridPane{
	
	
	private TextField emri;
	private TextField mbiemri;
	private ToggleGroup gender;
	private CheckBox pranoniKushtet;
	
	private void load() throws FileNotFoundException {
		
		FileInputStream input = new FileInputStream("src/java_03/logo.png");
		
		Image image = new Image(input);
		ImageView imageview = new ImageView(image);
		imageview.setFitHeight(150);
		imageview.setFitWidth(200);
		
		
		Label lblEmri = new Label("Emri: ");
		emri = new TextField();
		emri.setPromptText("Shkruani emrin ...");
		
		Label lblMbiemri = new Label("Mbiemri: ");
		mbiemri = new TextField();
		mbiemri.setPromptText("Shkruani mbiemrin ...");
		
		gender = new ToggleGroup();
		
		RadioButton male = new RadioButton("Male");
		male.setToggleGroup(gender);
		RadioButton female = new RadioButton("Female");
		female.setToggleGroup(gender);
		RadioButton undefined = new RadioButton("Undefined");
		undefined.setToggleGroup(gender);
		
		HBox genderPane = new HBox();
		genderPane.getChildren().addAll(male,female,undefined);
		genderPane.setSpacing(2.5);
		
		pranoniKushtet = new CheckBox("A pajtoheni me kushtet e kerkuara?");
		
		Button submit = new Button("Submit");
		Button clear = new Button("Clear");
		
		HBox buttonPane = new HBox();
		buttonPane.getChildren().addAll(submit,clear);
		buttonPane.setSpacing(2.5);
		
		super.getChildren().clear();
		
		super.setHgap(10);
		super.setVgap(10);
		super.add(imageview, 1, 0);
		super.add(lblEmri, 0, 1);
		super.add(emri, 1, 1);
		super.add(lblMbiemri, 0, 2);
		super.add(mbiemri, 1, 2);
		super.add(genderPane, 1, 3);
		super.add(pranoniKushtet, 1,4);
		super.add(buttonPane, 1, 5);
		super.setAlignment(Pos.CENTER);
		
	}   
	
	private void submitAction() {
		String emri = this.emri.getText();
		String mbiemri = this.mbiemri.getText();
		RadioButton selectedGender = (RadioButton) this.gender.getSelectedToggle();
		String gender = selectedGender.getText();
		boolean terms = this.pranoniKushtet.isSelected();
		User createdUser = User.fromValues(emri, mbiemri, gender, terms);

		
	}
	
	private void clearAction() {
		this.emri.setText("");
		this.mbiemri.setText("");
		this.pranoniKushtet.setSelected(false);
		//this.gender.
	}
	
	public CreateUserForm() throws FileNotFoundException {
		super();
		this.load();
	}
	
	
	
}


class User {
	private String emri;
	private String mbiemri;
	private String gender;
	private boolean terms;
	
	public static User fromValues(String emri,String mbiemri,String gender,boolean terms) {
		return new User(emri,mbiemri,gender,terms);
	}
	
	private User(String emri,String mbiemri,String gender,boolean terms) {
		this.emri = emri;
		this.mbiemri = mbiemri;
		this.gender = gender;
		this.terms = terms;
	}
	
	public String getEmri() {
		return this.emri;
	}
	
	public String getMbiermi() {
		return this.mbiemri;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public boolean getTerms() {
		return this.terms;
	}
}

class UserRepository{
	public User create(User user) {
		return user;
	}
	
}
