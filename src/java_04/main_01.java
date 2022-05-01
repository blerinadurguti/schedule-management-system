package java_04;

import javafx.animation.KeyFrame;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class main_01 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		StackPane pane = new StackPane();
		Fan objFan = new Fan();
		objFan.play();
		pane.getChildren().add(objFan);
		
		Scene scene = new Scene(pane,500,500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}

class Fan extends Pane {
	private Color color = Color.RED;

	
	private int time = 0;
	private EventHandler<ActionEvent> event = (e) -> {
		this.increaseTime();
	};
	
	
			private KeyFrame frame;
			private Timeline animation;
			
			public Fan() {
				super();
				this.frame = new KeyFrame(Duration.millis(2.5),event);
				this.animation = new Timeline(this.frame);
				this.animation.setCycleCount(Timeline.INDEFINITE);
			}
			
			public void play() {
				this.animation.play();
			}
			
			public void pause() {
				this.animation.pause();
			}
			
	private void draw() {
		super.getChildren().clear();

		double radius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
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
			arc.setStartAngle(i * 90 + time);
			arc.setLength(40);
			arc.setFill(this.color);
			super.getChildren().add(arc);
		}
			
	}
	
	private void increaseTime() {
		this.time+= 1;
		if(this.time == 360) {
			this.time = 0;
			this.color = new Color(Math.random(),Math.random(),Math.random(),1);
		}
		this.draw();
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


