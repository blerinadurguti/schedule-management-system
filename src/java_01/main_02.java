package java_01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class main_02 extends Application{

	public static void main(String[] args) {
		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Button btn1 = new Button("Click ME!");
		Button btn2 = new Button("Dont Click me!!!");
		
		Scene scene1 = new Scene(btn1, 250, 250);
		Scene scene2 = new Scene(btn2, 250, 250);
		
		primaryStage.setTitle("Dritarja e pare punuese");
		primaryStage.setScene(scene1);
		primaryStage.show();
		
		Stage stage2 = new Stage();
		stage2.setTitle("Dritarja e dyte punuese");
		stage2.setScene(scene2);
		stage2.show();
	}

}
