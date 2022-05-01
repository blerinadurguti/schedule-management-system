package java_02_02_ekstra;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
//import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DetyraFan extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Fan fanPane = new Fan();
		fanPane.setWidth(100);
		fanPane.setHeight(100);
		
		Fan fanPane2 = new Fan();
		fanPane2.setWidth(100);
		fanPane2.setHeight(100);
		
		Fan fanPane3 = new Fan();
		fanPane3.setWidth(100);
		fanPane3.setHeight(100);
		
		Fan fanPane4 = new Fan();
		fanPane4.setWidth(100);
		fanPane4.setHeight(100);
		
		FlowPane pane = new FlowPane();
		pane.getChildren().addAll(fanPane, fanPane2, fanPane3, fanPane4);
		
		Scene scene = new Scene(pane, 500, 500);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}

class Fan extends Pane {
	
	private void draw() {
		super.getChildren().clear();

		double radius = Math.min(getWidth(), getHeight()) * 0.8 * 0.6;
		double centerX = getWidth() / 2;
		double centerY = getHeight() / 2;
		
		Circle circle = new Circle(centerX, centerY, radius);
		circle.setFill(null);
		circle.setStroke(Color.BLACK);
		super.getChildren().add(circle);

		for(int i = 0; i < 4; i++) {
			Arc arc = new Arc();
			arc.setCenterX(centerX);
			arc.setCenterY(centerY);
			arc.setRadiusX(radius - 5);
			arc.setRadiusY(radius - 5);
			arc.setType(ArcType.ROUND);
			arc.setStartAngle(i * 90);
			arc.setLength(40);
			arc.setFill(Color.RED);
			super.getChildren().add(arc);
		}
			
	}
	
	public void setWidth(double width) {
		super.setWidth(width);
		this.draw();
	}
	
	public void setHeight(double height) {
		super.setHeight(height);
		this.draw();
	}

}
