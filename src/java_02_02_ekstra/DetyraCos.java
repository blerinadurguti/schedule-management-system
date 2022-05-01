package java_02_02_ekstra;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DetyraCos extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		CosWave cosWave = new CosWave(-360, 360);
		
		
		Pane pane = new Pane();
		pane.getChildren().add(cosWave);
		
		Scene scene = new Scene(pane, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}

class CosWave extends Pane {
	private int startAngle;
	private int endAngel;
	public CosWave(int start, int end) {
		super();
		this.startAngle = start;
		this.endAngel = end;
		draw();
	}
	
	private void draw() {
		Polyline polyline = new Polyline();
	    for (double angle = this.startAngle; angle <= this.endAngel; angle++) {
	      polyline.getPoints().addAll(
	        angle, Math.cos(Math.toRadians(angle)));
	    }
	    polyline.setTranslateY(100);
	    polyline.setTranslateX(200);
	    polyline.setScaleX(0.5);
	    polyline.setScaleY(50); 
	    polyline.setStrokeWidth(1.0 / 25);
	    
	    // Draw x-axis 
	    Line line1 = new Line(10, 100, 420, 100);
	    Line line2 = new Line(420, 100, 400, 90);
	    Line line3 = new Line(420, 100, 400, 110);

	    // Draw y-axis
	    Line line4 = new Line(200, 10, 200, 200);
	    Line line5 = new Line(200, 10, 190, 30);
	    Line line6 = new Line(200, 10, 210, 30);

	    // Draw x, y axis labels
	    Text text1 = new Text(380, 70, "X");
	    Text text2 = new Text(220, 20, "Y");    
	    
	    // Add nodes to a pane
	    getChildren().clear();
	    getChildren().addAll(polyline, line1, line2, line3, line4,
	      line5, line6, text1, text2);

	}
}
