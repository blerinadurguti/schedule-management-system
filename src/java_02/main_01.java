package java_02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class main_01 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Line line = new Line();
		line.setStartX(0);
		line.setStartY(0);
		line.setEndX(100);
		line.setEndY(100);
	
		MyLine line2 = new MyLine();
		line2.setStartPoints(0, 0);
		line2.setEndPoints(100, 100);
		
		
		//line.setPoints(0,0,100,100);
		//line.setStartPooints(0,0);
		//line.setEndPoints(100,100)
		

		MyRectangle rect = new MyRectangle();
		rect.setWidth(200);
		rect.setHeight(200);
		
		Pane pane= new Pane();
		pane.getChildren().add(rect);
		
		
		
		
		Scene scene = new Scene(pane,500,500);
		
		
		
		stage.setScene(scene);
		stage.setTitle("Detyra e pare");
		stage.show();
	}

	
	class MyLine extends Line{
/*
		private void draw() {
			super.
		};
		
	*/	
	public void setStartPoints(double x,double y) {
		super.setStartX(x);
		super.setStartY(y);
	};	
		public void setEndPoints(double x,double y) {
		super.setEndX(x);
		super.setEndY(y);
		};	
	}
	
	class MyRectangle extends Pane{
		
//		private void draw() {
//			Rectangle rect = new Rectangle();
//			rect.setX(10);
//			rect.setY(10);
//			rect.setWidth(super.getWidth());
//			rect.setHeight(super.getHeight());
//			rect.setFill(null);
//			rect.setStroke(Color.BLACK);
//			
//			Line line1, line2;
//			line1 = new Line(rect.getX(),rect.getY(),rect.getX() + rect.getWidth(),rect.getY() + rect.getHeight());
//			line2 = new Line(rect.getX() + rect.getWidth(),rect.getY(),rect.getX(), rect.getY() + rect.getHeight());
//			
//			super.getChildren().clear();
//			super.getChildren().addAll(line1,line2,rect);
//			
//		}
		
		private void drawColor() {
			Rectangle rect = new Rectangle();
			rect.setX(10);
			rect.setY(10);
			rect.setWidth(super.getWidth());
			rect.setHeight(super.getHeight());
			rect.setFill(null);
			rect.setStroke(Color.BLACK);
			rect.setStrokeWidth(5);
			
			Polygon pg1,pg2,pg3,pg4;
			
			pg1 = new Polygon();
			pg1.getPoints().addAll(rect.getX(),rect.getY(),rect.getX(),rect.getY() + rect.getHeight(),rect.getX() + (int)(rect.getWidth() / 2),rect.getY() + (int)(rect.getHeight() / 2));
			pg1.setFill(Color.GREEN);
						
			pg2 = new Polygon();
			pg2.getPoints().addAll(rect.getX(),rect.getY(),rect.getX() + rect.getWidth(),rect.getY(),rect.getX() + (int)(rect.getWidth() / 2),rect.getY() + (int)(rect.getHeight() / 2));
			pg2.setFill(Color.SKYBLUE);
			
			pg3 = new Polygon();
			pg3.getPoints().addAll(rect.getX() + rect.getWidth(),rect.getY(),rect.getX() + rect.getWidth(),rect.getY() + rect.getHeight(),rect.getX() + (int)(rect.getWidth() / 2),rect.getY() + (int)(rect.getHeight() / 2));
			pg3.setFill(Color.YELLOW);
			
			
			pg4 = new Polygon();
			pg4.getPoints().addAll(rect.getX(),rect.getY() + rect.getHeight(),rect.getX() + rect.getWidth(),rect.getY() + rect.getHeight(),rect.getX() + (int)(rect.getWidth() / 2),rect.getY() + (int)(rect.getHeight() / 2));
			pg4.setFill(Color.RED);
			
			Line line1, line2;
			line1 = new Line(rect.getX(),rect.getY(),rect.getX() + rect.getWidth(),rect.getY() + rect.getHeight());
			line1.setStrokeWidth(3);
			line2 = new Line(rect.getX() + rect.getWidth(),rect.getY(),rect.getX(), rect.getY() + rect.getHeight());
			line2.setStrokeWidth(3);
			
			super.getChildren().clear();
			super.getChildren().addAll(rect,pg1,pg2,pg3,pg4,line1,line2);
		}
		
		public void setWidth(double width) {
			super.setWidth(width);
			this.drawColor();
		}
	
	public void setHeight(double height) {
			super.setHeight(height);
			this.drawColor();
	}
	
	}
	
}
