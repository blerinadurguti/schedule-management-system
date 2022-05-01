package java_02_02_ekstra;

import java.util.Calendar;
import java.util.GregorianCalendar;

//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//import javafx.util.Duration;

public class DetyraOra extends Application{


	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane pane = new BorderPane();
		
		Clock clock = new Clock();
		Label lblTime = new Label(clock.getDescriptionTime());
		pane.setCenter(clock);
		pane.setBottom(lblTime);
		BorderPane.setAlignment(lblTime, Pos.CENTER);
	
		
		Scene scene = new Scene(pane, 250, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}


class Clock extends Pane {
	private int hour;
	private int minute;
	private int second;
	
	public Clock() {
		this.setCurrentTime();
	}
	
	public Clock(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public void setCurrentTime() {
		Calendar calendar = new GregorianCalendar();
		
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.second = calendar.get(Calendar.SECOND);
		
		paintClock();
	}
	
	public String getDescriptionTime() {
		return this.hour + ":" + this.minute+ ":" + this.second;
	}
	
	private void paintClock() {
		double clockRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
		double centerX = getWidth() / 2;
		double centerY = getHeight() / 2;
		
		// Draw circle
 		Circle circle = new Circle(centerX, centerY, clockRadius);
 		circle.setFill(Color.WHITE);
 		circle.setStroke(Color.BLACK);
 		
 		Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
 		Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
 		Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
 		Text t4 = new Text(centerX - 3, centerY + clockRadius -3, "6");
 		
 		//Draw second hand 
 		double sLength = clockRadius * 0.8;
 		double secondX = centerX + sLength * Math.sin(this.second * (2 * Math.PI / 60));
 		double secondY = centerY - sLength * Math.cos(this.second * (2 * Math.PI / 60));
 		Line sLine = new Line(centerX, centerY, secondX, secondY);
 		sLine.setStroke(Color.RED);
 		
 		//Draw minutes hand
 		double mLength = clockRadius * 0.65;
 		double minuteX = centerX + mLength * Math.sin(this.minute * (2 * Math.PI / 60));
 		double minuteY = centerY - mLength * Math.cos(this.minute * (2 * Math.PI / 60));
 		Line mLine = new Line(centerX, centerY, minuteX, minuteY);
 		mLine.setStroke(Color.BLUE);
 		
		//Draw minutes hand
 		double hLength = clockRadius * 0.5;
 		double hourX = centerX + hLength * Math.sin(this.minute * (2 * Math.PI / 60));
 		double hourY = centerY - hLength * Math.cos(this.minute * (2 * Math.PI / 60));
 		Line hLine = new Line(centerX, centerY, hourX, hourY);
 		hLine.setStroke(Color.GREEN);
 		
 		
 		getChildren().clear();
 		getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);
	}
	
	public void setWidth(double width) {
		super.setWidth(width);
		paintClock();
	}
	
	public void setHeight(double height) {
		super.setHeight(height);
		paintClock();
	}
}
