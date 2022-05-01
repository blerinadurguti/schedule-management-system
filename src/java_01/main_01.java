package java_01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class main_01 extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage PrimaryStage) throws Exception {
		
		Label lbl = new Label("Mirsevini ne KNK!");
			
		Scene scene = new Scene(lbl,250,250);
		
		PrimaryStage.setScene(scene);
		PrimaryStage.show();
	}
	
}