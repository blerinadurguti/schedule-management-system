package log_in;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader=new FXMLLoader(getClass().getResource("log_in.fxml"));
		Parent parent=loader.load();
		
		Scene scene=new Scene(parent,1920,1080);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
