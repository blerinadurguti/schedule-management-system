package java_05_nga_profi;

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

public class Main01 extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Pane pane = new Pane();
		Button btn = new Button("Click");
		btn.setOnAction(e -> {
			CreateStudentModal stModal = new CreateStudentModal();
		});
		pane.getChildren().add(btn);
		Scene scene = new Scene(pane, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}

class CreateStudentModal extends GridPane {
	private Stage primaryStage;
	private Scene prevScene;
	
	private TextField txtEmri;
	private TextField txtMbiemri;
	
	private void load() {
		Label lblEmri = new Label("Emri: ");
		this.txtEmri = new TextField();
		this.txtEmri.setPromptText("Type firstname ...");
		
		Label lblMbiemri = new Label("Mbiemri: ");
		this.txtMbiemri = new TextField();
		this.txtMbiemri.setPromptText("Type lastname ...");
		
		
		Button submit = new Button("Submit");
		Button cancel = new Button("Cancel");
		
		submit.setOnAction(e -> {
			this.submitAction();
		});
		
		cancel.setOnAction(e -> {
			this.cancelAction();
		});
		
		HBox buttonPane = new HBox();
		buttonPane.setSpacing(10);
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.getChildren().addAll(submit, cancel);
		
		super.add(lblEmri, 0, 1);
		super.add(txtEmri, 1, 1);
		super.add(lblMbiemri, 0, 2);
		super.add(txtMbiemri, 1, 2);
		super.add(buttonPane, 0, 3, 2, 1);
		super.setAlignment(Pos.CENTER);
		super.setVgap(5);
		super.setHgap(5);
		
		

		
		Scene scene = new Scene(this, 500, 500);

		this.primaryStage.setScene(scene);
		this.primaryStage.setTitle("Create Student");
		this.primaryStage.show();
	}
	
	private void submitAction() {
		
	}
	
	private void cancelAction() {
		this.primaryStage.close();
	}
	
	public CreateStudentModal() {
		this.primaryStage = new Stage();
		this.load();
	}
}

class Student {
	private int id;
	private String emri;
	private String mbiemri;
	
	public static Student getInstance(int id, String emri, String mbiemri) {
		return new Student(id, emri, mbiemri);
	}
	
	private Student(int id, String emri, String mbiemri) {
		this.id = id;
		this.emri = emri;
		this.mbiemri = mbiemri;
	}
}

class StudentRepository {
	//TODO: 
}
