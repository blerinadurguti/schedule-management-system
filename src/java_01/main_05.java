package java_01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class main_05 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		Polygon pg = new Polygon(100,200,446,100,793,200,793,400,446,500,100,400);
		pg.setFill(Color.RED);
		pg.setStroke(Color.BLACK);
		pg.setStrokeWidth(10);
		
		Pane pane = new Pane();
		pane.getChildren().add(pg);
		
		Scene scene = new Scene(pane,1000,700);
		stage.setScene(scene);
		stage.show();
	}

}
