package program;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import program.Shapes.*;


public class Main extends Application{

	@Override
	public void start(Stage primaryStage) {


		// Setting the Scene and Canvas
		StackPane stackpane = new StackPane();
		Scene scene = new Scene(stackpane,800,500);
		Canvas canvas = new Canvas(800,500);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		// Creating Shapes and drawing them to the board

		// 250 - 405
		// 200 - 324
		// 160 - 259.2

		MyCircle c0 = new MyCircle(400,250,400,MyColor.RED);
		c0.draw(gc);

		MyPolygon p1 = new MyPolygon(400,250,197.5,5,MyColor.BROWN);
		p1.draw(gc);

		MyCircle c1 = new MyCircle(400,250,315, MyColor.GREEN);
		c1.draw(gc);

		MyPolygon p2 = new MyPolygon(400,250,156.5,5,MyColor.PINK);
		p2.draw(gc);

		MyCircle c2 = new MyCircle(400,250,250, MyColor.BLUE);
		c2.draw(gc);

		MyPolygon p3 = new MyPolygon(400,250,124.2,5,MyColor.MAGENTA);
		p3.draw(gc);

		MyCircle c3 = new MyCircle(400,250,198.4, MyColor.YELLOW);
		c3.draw(gc);

		
		MyLine top = new MyLine(0,0,800,0,MyColor.BLACK);
		MyLine bottom = new MyLine(0,500,800,500,MyColor.BLACK);
		MyLine left = new MyLine(0,0,0,500,MyColor.BLACK);
		MyLine right = new MyLine(800,0,800,500,MyColor.BLACK);
		MyLine diagonal1 = new MyLine(0,0,800,500,MyColor.BLACK);
		MyLine diagonal2 = new MyLine(0,500,800,0,MyColor.BLACK);
		top.draw(gc);
		bottom.draw(gc);
		left.draw(gc);
		right.draw(gc);
		diagonal1.draw(gc);
		diagonal2.draw(gc);
		
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
