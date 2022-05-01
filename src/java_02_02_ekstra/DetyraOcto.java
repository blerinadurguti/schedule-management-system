package java_02_02_ekstra;


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;


public class DetyraOcto extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		StackPane pane = new StackPane();
		OctoPane octo = new OctoPane();
		octo.setWidth(500);
		octo.setHeight(500);
		pane.getChildren().add(octo);
		Scene scene = new Scene(pane, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}


class OctoPane extends Pane {
	private void paint() {
		Polygon polygon = new Polygon();
		polygon.setFill(null);
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
		
		getChildren().clear();
		getChildren().add(polygon);
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
