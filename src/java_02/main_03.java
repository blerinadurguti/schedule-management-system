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
import java.util.Scanner;


public class main_03 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int a;
		double w;
		System.out.print("Fan number = ");
		a = sc.nextInt();
		System.out.print("\n" + "Width = ");
		w = sc.nextDouble();
		sc.close();
		MyFan fan = new MyFan(w,a);
		
		Pane pane = new Pane();
		pane.getChildren().add(fan);
		Scene scene = new Scene(pane,500,500);
		stage.setScene(scene);
		stage.show();
	}
	
	class MyFan extends Pane{
		
		private double w;
		private int a;
		
		MyFan(double width, int b){
			this.w = width;
			this.a = b;
			this.draw();
		}
		
		private double kendi() {
			return 360 / this.a;
		}
		
		private void draw() {
			double x,radius;
			radius = this.w/2;
			x = 100 + radius;
			
			Circle circle = new Circle();
			circle.setCenterX(x);
			circle.setCenterY(x);
			circle.setRadius(radius);
			circle.setFill(Color.LIGHTGREEN);
			circle.setStroke(Color.BLACK);
			circle.setStrokeWidth(2);
			
			Group gr = new Group();
			
			for(int i = 0; i < this.a;i++) {
				Arc arc = new Arc(x,x,radius - 10,radius - 10,i* this.kendi(),this.kendi()/2);
				arc.setFill(Color.YELLOW);
				arc.setStroke(Color.BLACK);
				arc.setStrokeWidth(2);
				arc.setType(ArcType.ROUND);
				gr.getChildren().addAll(arc);
			}
			
			super.getChildren().clear();
			super.getChildren().addAll(circle,gr);
		}
		
	}

}
