package CreateUser;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main_01 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	
	FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateUser.fxml"));
	
	Parent parent = loader.load();
	
	Scene scene = new Scene(parent,710,459);	
	
	primaryStage.setScene(scene);
	primaryStage.show();	
	}

}
