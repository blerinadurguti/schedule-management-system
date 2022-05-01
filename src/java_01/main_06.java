package java_01;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class main_06 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
	
	Circle circle = new Circle();	
		circle.setRadius(50);
		circle.setFill(Color.TEAL);
		circle.setStrokeWidth(2);
		circle.setStroke(Color.DARKBLUE);
		circle.setCenterX(52);
		circle.setCenterY(52);
		
		Rectangle rectangle = new Rectangle();
		rectangle.setStyle("-fx-fill: firebrick; -fx-stroke: #333333; -fx-stroke-width: 3px");
		rectangle.setX(200);
		rectangle.setY(26.5);
//		rectangle.setArcHeight(5);
//		rectangle.setArcWidth(5);
		rectangle.setWidth(150);
		rectangle.setHeight(150);
		
		Line line = new Line(rectangle.getX(),rectangle.getY(),rectangle.getX() + rectangle.getWidth(),rectangle.getY() + rectangle.getHeight());
		line.setStroke(Color.ORANGERED);
		Line line2 = new Line(rectangle.getX() + rectangle.getWidth(),rectangle.getY(),rectangle.getX(),rectangle.getY() + rectangle.getHeight());
		line2.setStroke(Color.ORANGERED);
		
		 Arc arc1 = new Arc(circle.getCenterX(), circle.getCenterY(), circle.getRadius() / 2, circle.getRadius() / 2, 0, 45);
		    arc1.setStyle("-fx-fill: #E8DE2A");
		    arc1.setType(ArcType.ROUND);
		    Arc arc2 = new Arc(circle.getCenterX(), circle.getCenterY(), circle.getRadius() / 2, circle.getRadius() / 2, 120, 45);
		    arc2.setStyle("-fx-fill: #E8DE2A");
		    arc2.setType(ArcType.ROUND);
		    Arc arc3 = new Arc(circle.getCenterX(), circle.getCenterY(), circle.getRadius() / 2, circle.getRadius() / 2, 240, 45);
		    arc3.setStyle("-fx-fill: #E8DE2A");
		    arc3.setType(ArcType.ROUND);
		    
		    Polygon polygon = new Polygon();
		    polygon.setFill(Color.DARKSEAGREEN);
		    polygon.setStroke(Color.CADETBLUE);
		    polygon.setStrokeWidth(5);
		    polygon.getPoints().addAll(400.0, 111.00, 600.0, 111.0, 500.0, 11.0);
		    
		    Line line3 = new Line(500,16,500,108);
		    line3.setStroke(Color.CYAN);
		    
		    Text text = new Text("Lenda KNK");
		    Font font = Font.font("Times New Roman", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 16);
		    text.setFont(font);
		    text.setStroke(Color.CRIMSON);
		    text.setX(500);
		    text.setY(150);
		    text.setTextAlignment(TextAlignment.CENTER);
		    text.setTextOrigin(VPos.CENTER);
		
	Pane pane = new Pane();
	pane.getChildren().addAll(
			circle,
			rectangle,
			line,
			line2,
			arc1,
			arc2,
			arc3,
			polygon,
			line3,
			text
			);
	Scene scene = new Scene(pane,650,200);
	stage.setScene(scene);
	stage.show();	
	}

	
	
}
