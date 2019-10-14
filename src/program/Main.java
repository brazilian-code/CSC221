package program;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import program.Shapes.MyLine;
import program.Shapes.MyOval;
import program.Shapes.MyRectangle;

public class Main extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		
		// Setting the Scene and Canvas
		StackPane stackpane = new StackPane();
		Scene scene = new Scene(stackpane,800,500);
		Canvas canvas = new Canvas(800,500);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		// Creating Shapes and drawing them to the board
		
		MyRectangle r1 = new MyRectangle(400,250,320,200,MyColor.MAGENTA);
		r1.draw(gc);
		
		MyOval o1 = new MyOval(400,250,320,200,MyColor.BLUE);
		o1.draw(gc);

		/*
			For the size of the rectangle inside an ellipse I'll use the formulas:
			R_Width = (E_width / 2) * sqrt(2)
			R_Height = (E_Height) * sqrt(2)
		*/

		MyRectangle r2 = new MyRectangle(400,250,(o1.getWidth()/2)*Math.sqrt(2),(o1.getHeight()/2)*Math.sqrt(2),MyColor.PINK);
		r2.draw(gc);
		
		MyOval o2 = new MyOval(400,250,(o1.getWidth()/2)*Math.sqrt(2),(o1.getHeight()/2)*Math.sqrt(2),MyColor.BROWN);
		o2.draw(gc);
		
		MyRectangle r3 = new MyRectangle(400,250,(o2.getWidth()/2)*Math.sqrt(2),(o2.getHeight()/2)*Math.sqrt(2),MyColor.RED);
		r3.draw(gc);
		
		MyOval o3 = new MyOval(400,250,(o2.getWidth()/2)*Math.sqrt(2),(o2.getHeight()/2)*Math.sqrt(2),MyColor.GREEN);
		o3.draw(gc);
		
		MyLine top = new MyLine(0,0,800,0,MyColor.BLACK);
		MyLine bottom = new MyLine(0,500,800,500,MyColor.BLACK);
		MyLine left = new MyLine(0,0,0,500,MyColor.BLACK);
		MyLine right = new MyLine(800,0,800,500,MyColor.BLACK);
		MyLine diagonal = new MyLine(0,0,800,500,MyColor.BLACK);
		top.draw(gc);
		bottom.draw(gc);
		left.draw(gc);
		right.draw(gc);
		diagonal.draw(gc);
		
		// Displaying it all
		stackpane.getChildren().add(canvas);
		primaryStage.setTitle("CSC221 - Project 1; David Balaban");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}