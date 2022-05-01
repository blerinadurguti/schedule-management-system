package java_02;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class main_02 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
//		Circle circle = new Circle();	
//		circle.setRadius(50);
//		circle.setFill(Color.TEAL);
//		circle.setStrokeWidth(2);
//		circle.setStroke(Color.DARKBLUE);
//		circle.setCenterX(52);
//		circle.setCenterY(52);
//		
//		Arc arc1 = new Arc(circle.getCenterX(), circle.getCenterY(), circle.getRadius() / 2, circle.getRadius() / 1.5, 0, 45);
//	    arc1.setStyle("-fx-fill: #E8DE2A");
//	    arc1.setType(ArcType.ROUND);
//	    Arc arc2 = new Arc(circle.getCenterX(), circle.getCenterY(), circle.getRadius() / 2, circle.getRadius() / 2, 90, 45);
//	    arc2.setStyle("-fx-fill: #E8DE2A");
//	    arc2.setType(ArcType.ROUND);
//	    Arc arc3 = new Arc(circle.getCenterX(), circle.getCenterY(), circle.getRadius() / 2, circle.getRadius() / 2, 180, 45);
//	    arc3.setStyle("-fx-fill: #E8DE2A");
//	    arc3.setType(ArcType.ROUND);
//	    Arc arc4 = new Arc(circle.getCenterX(), circle.getCenterY(), circle.getRadius() / 2, circle.getRadius() / 2, 270, 45);
//	    arc4.setStyle("-fx-fill: #E8DE2A");
//	    arc4.setType(ArcType.ROUND);
	    
		MyFan f = new MyFan();
		f.getWidtha(200);
		f.kendi(5);
		
		Pane pane = new Pane();
		pane.getChildren().add(f);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
	stage.show();	
	}

	
	class MyFan extends Pane{
		
		private double kendi;
		private int a;
	
		private void draw() {
			double x,y,radius;
			x = 10 + super.getWidth() / 2;
			y = 10 + super.getHeight() / 2;
			radius = super.getWidth() / 2;
			
			Circle circle = new Circle(x,y,radius);
			circle.setStroke(Color.WHITE);
			
			
			Group gr = new Group();
			for(int i = 0; i < this.a;i++) {
				Arc arc = new Arc(x,y,radius - 10, radius - 10, i * this.kendi , this.kendi / 2);
				arc.setFill(null);
				arc.setStroke(Color.GREEN);
				arc.setStrokeWidth(3);
				arc.setType(ArcType.ROUND);
			gr.getChildren().add(arc);
			}
			
			
//		    Pane pane = new Pane();
//		    pane.getChildren().addAll(circle,arc1,arc2,arc3,arc4);
		    super.getChildren().clear();
			super.getChildren().addAll(circle,gr);
		}
		
		
		public void kendi(int b) {
			this.kendi = 360 / b;
			this.a = b;
		}
		
		public void getWidtha(double width) {
			super.setWidth(width);
			super.setHeight(width);
			this.draw();
		}
		
	}
	
	
}
