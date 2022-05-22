package application;
	
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import processor.GjuhaProcessor;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			GjuhaProcessor g = new GjuhaProcessor();
			Locale locale = new Locale(g.setGjuha());
			ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
			Parent root = FXMLLoader.load(getClass().getResource("/views/log_in.fxml"),bundle);
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setX(100);
			stage.setY(100);
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
