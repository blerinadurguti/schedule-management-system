package java_06_nga_profi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
		Parent parent = loader.load();
		
		Scene scene = new Scene(parent, 670, 840);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		HBox pane = new HBox();
//		Circle circle1 = new Circle(50, 50, 30);
//		Circle circle2 = new Circle(150, 50, 30);
//		Rectangle rect1 = new Rectangle(150, 150, 100, 200);
//		
//		//circle1.getStyleClass().addAll("red-fill", "black-stroke", "classn...");
//		circle1.getStyleClass().addAll("red-fill");
//		circle2.getStyleClass().add("black-stroke");
//		rect1.setId("custom-rect");
//		
//		pane.getChildren().addAll(circle1, circle2, rect1);
//		pane.setId("border-pane");
//		
//		Scene scene = new Scene(pane, 500, 500);
//		
//		scene.getStylesheets().add(
//				getClass().getResource("style.css").toExternalForm()
//				);
//		
//		primaryStage.setScene(scene);
//		primaryStage.setTitle("Custom style");
//		primaryStage.show();
//	}

}