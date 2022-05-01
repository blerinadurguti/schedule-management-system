package java_01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class main_04 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage PrimaryStage) throws Exception {
		
		FlowPane pane = new FlowPane();
		pane.setHgap(5);
		pane.setVgap(5);
		
		pane.getChildren().addAll(
				new Label("First Name:"),
				new TextField(),
				new Label("MI:")
				);
		
		TextField tfMi = new TextField();
		tfMi.setPrefColumnCount(1);
		pane.getChildren().addAll(
				tfMi,
				new Label("Last Name:"),
				new TextField()
				);
		
		
		Scene scene = new Scene(pane,500,50);
		PrimaryStage.setTitle("ShowFlowPane");
		PrimaryStage.setScene(scene);
		PrimaryStage.show();
	}

}
