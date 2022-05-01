package java_05;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class main_01 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	Pane pane  = new Pane();
	//tabele
	StudentForm stdForm = new StudentForm();
	Button btn = new Button("Add new Student +");
	btn.setOnAction(e -> {
		stdForm.loadCreateForm();
	});
	
	pane.getChildren().add(btn);
	Scene scene = new Scene(pane,500,500);
	primaryStage.setScene(scene);
	primaryStage.show();
	}

}

class StudentForm extends GridPane{
	private Stage studentStage;
	
	private TextField txtEmri;
	private TextField txtMbiemri;
	private Button btnCreate;
	private Button btnCancel;
	
	
	
	public void loadCreateForm() {
		Label lblEmri = new Label("Emri: ");
		txtEmri = new TextField();
		Label lblMbiemri = new Label("Mbiemri: ");
		txtMbiemri = new TextField();
		btnCreate = new Button("Create");
		btnCancel = new Button("Cancel");
		btnCreate.setOnAction(e ->{
			this.createAction();
		});
		btnCancel.setOnAction(e->{
			this.cancelAction();
		});
		HBox buttonPane = new HBox();
		buttonPane.getChildren().addAll(btnCreate, btnCancel);
		buttonPane.setSpacing(10);
		buttonPane.setAlignment(Pos.CENTER);
		
		
		super.add(lblEmri, 0, 0);
		super.add(txtEmri, 1, 0);
		super.add(lblMbiemri, 0, 1);
		super.add(txtMbiemri, 1, 1);
		super.add(buttonPane, 0, 2,2,1);
		super.setVgap(10);
		super.setHgap(10);
		super.setAlignment(Pos.CENTER);
		
		this.studentStage = new Stage();
		Scene scene = new Scene(this,400,400);
		this.studentStage.setScene(scene);
//		this.studentStage.show();
		this.studentStage.showAndWait();
	}
	
	public void loadUpdateForm() {
	//ruajm studentin	
	}
	
	private void createAction() {
	//to do later	
	}
	
	private void cancelAction() {
		this.studentStage.close();
	}
}
