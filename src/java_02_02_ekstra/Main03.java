package java_02_02_ekstra;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
//import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
//import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main03 extends Application{
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		CustomRect myrect= new CustomRect(100, 5);
		Pane pane = new Pane();
		pane.getChildren().add(myrect);
		
		Scene scene = new Scene(pane, 500, 500);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}

class CustomRect extends Pane {
	
	private int numberOfRects;
	private int rateOfRotate;
	
	private void paint() {
		Group group = new Group();
		for (int i = 0; i < this.numberOfRects; i++) {
			  Rectangle r = new Rectangle(150, 150, 200, 50); 
			  r.setRotate(i * 360 / this.rateOfRotate); 
			  r.setStroke(Color.color(Math.random(), Math.random(),Math.random()));
			  r.setFill(null);
			  group.getChildren().add(r);
			  //super.getChildren().add(r);
		 }
		
		super.getChildren().clear();
		super.getChildren().add(group);
	}

	public CustomRect(int numberOfRects, int rateOfRotate) {
		super();
		this.numberOfRects = numberOfRects;
		this.rateOfRotate = rateOfRotate;
		paint();
	}
}
