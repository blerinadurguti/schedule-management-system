package java_02_02_ekstra;

import javafx.application.Application;
import javafx.collections.ObservableList;
//import javafx.geometry.Pos;
import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class DetyraStopSign extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		StackPane pane = new StackPane();
		StopSignPane octo = new StopSignPane();
		octo.setWidth(500);
		octo.setHeight(500);
		pane.getChildren().add(octo);
		Scene scene = new Scene(pane, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle(STYLESHEET_CASPIAN);
		primaryStage.show();
	}

}


class StopSignPane extends Pane {
	private void paint() {
		Polygon polygon = new Polygon();
		polygon.setFill(Color.RED);
		polygon.setStroke(Color.BLACK);
		ObservableList<Double> list = polygon.getPoints();
		
		double centerX = getWidth() / 2;
		double centerY = getHeight() / 2;
		double radius = Math.min(centerX, centerY) * 0.5;
		
		for(int i = 0; i< 6; i++) {
			double x = centerX + radius * Math.cos(i * Math.PI / 3);
			double y = centerY - radius * Math.sin(i * Math.PI / 3);
			list.addAll(x,y);
		}
		
		Text stopText = new Text(centerX - radius  + 55, centerY + 15, "STOP");
		stopText.setFill(Color.WHITE);
		stopText.setTextAlignment(TextAlignment.CENTER);
		stopText.setFont(new Font(50));
		getChildren().clear();
		getChildren().addAll(polygon, stopText);
	}
	
	public void setWidth(double width) {
		super.setWidth(width);
		this.paint();
	}
	
	public void setHeight(double height) {
		super.setHeight(height);
		this.paint();
	}

}
