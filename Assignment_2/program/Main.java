package program;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import program.Shapes.*;


public class Main extends Application{

	public class ResizableCanvas extends Canvas{

		public ResizableCanvas(){

			widthProperty().addListener(evt -> draw());
			heightProperty().addListener(evt -> draw());
		}

		private void draw(){

			GraphicsContext gc = getGraphicsContext2D();

			MyRectangle r1 = new MyRectangle(400,250,400,250,MyColor.MAGENTA);
			//r1.draw(gc);

			MyOval o1 = new MyOval(400,250,400,250,MyColor.BLUE);
			//o1.draw(gc);

		/*
			For the size of the rectangle inside an ellipse I'll use the formulas:
			R_Width = (E_width / 2) * sqrt(2)
			R_Height = (E_Height/2) * sqrt(2)
		*/

			MyRectangle r2 = new MyRectangle(400,250,(o1.getWidth()/2)*Math.sqrt(2),(o1.getHeight()/2)*Math.sqrt(2),MyColor.PINK);
			//r2.draw(gc);

			MyOval o2 = new MyOval(400,250,(o1.getWidth()/2)*Math.sqrt(2),(o1.getHeight()/2)*Math.sqrt(2),MyColor.BROWN);
			//o2.draw(gc);

			MyRectangle r3 = new MyRectangle(400,250,(o2.getWidth()/2)*Math.sqrt(2),(o2.getHeight()/2)*Math.sqrt(2),MyColor.RED);
			//r3.draw(gc);

			MyOval o3 = new MyOval(400,250,(o2.getWidth()/2)*Math.sqrt(2),(o2.getHeight()/2)*Math.sqrt(2),MyColor.GREEN);
			//o3.draw(gc);

			// 250 - 405
			// 200 - 324
			// 160 - 259.2

			MyPolygon p1 = new MyPolygon(400,250,250,5,MyColor.BROWN);
			p1.draw(gc);

			MyCircle c1 = new MyCircle(400,250,405, MyColor.GREEN);
			c1.draw(gc);

			MyPolygon p2 = new MyPolygon(400,250,200,5,MyColor.PINK);
			p2.draw(gc);

			MyCircle c2 = new MyCircle(400,250,324, MyColor.BLUE);
			c2.draw(gc);

			MyPolygon p3 = new MyPolygon(400,250,160,5,MyColor.MAGENTA);
			p3.draw(gc);

			MyCircle c3 = new MyCircle(400,250,259.2, MyColor.YELLOW);
			c3.draw(gc);


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

		}

		@Override
		public boolean isResizable() {
			return true;
		}

		@Override
		public double prefWidth(double height) {
			return getWidth();
		}

		@Override
		public double prefHeight(double width) {
			return getHeight();
		}

	}

	
	@Override
	public void start(Stage primaryStage) {

		/*
		// Setting the Scene and Canvas
		StackPane stackpane = new StackPane();
		Scene scene = new Scene(stackpane,800,500);
		Canvas canvas = new Canvas(800,500);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		// Creating Shapes and drawing them to the board

		MyRectangle r1 = new MyRectangle(400,250,400,250,MyColor.MAGENTA);
		//r1.draw(gc);
		
		MyOval o1 = new MyOval(400,250,400,250,MyColor.BLUE);
		//o1.draw(gc);


			For the size of the rectangle inside an ellipse I'll use the formulas:
			R_Width = (E_width / 2) * sqrt(2)
			R_Height = (E_Height/2) * sqrt(2)


		MyRectangle r2 = new MyRectangle(400,250,(o1.getWidth()/2)*Math.sqrt(2),(o1.getHeight()/2)*Math.sqrt(2),MyColor.PINK);
		//r2.draw(gc);
		
		MyOval o2 = new MyOval(400,250,(o1.getWidth()/2)*Math.sqrt(2),(o1.getHeight()/2)*Math.sqrt(2),MyColor.BROWN);
		//o2.draw(gc);
		
		MyRectangle r3 = new MyRectangle(400,250,(o2.getWidth()/2)*Math.sqrt(2),(o2.getHeight()/2)*Math.sqrt(2),MyColor.RED);
		//r3.draw(gc);
		
		MyOval o3 = new MyOval(400,250,(o2.getWidth()/2)*Math.sqrt(2),(o2.getHeight()/2)*Math.sqrt(2),MyColor.GREEN);
		//o3.draw(gc);

		// 250 - 405
		// 200 - 324
		// 160 - 259.2

		MyPolygon p1 = new MyPolygon(400,250,250,5,MyColor.BROWN);
		p1.draw(gc);

		MyCircle c1 = new MyCircle(400,250,405, MyColor.GREEN);
		c1.draw(gc);

		MyPolygon p2 = new MyPolygon(400,250,200,5,MyColor.PINK);
		p2.draw(gc);

		MyCircle c2 = new MyCircle(400,250,324, MyColor.BLUE);
		c2.draw(gc);

		MyPolygon p3 = new MyPolygon(400,250,160,5,MyColor.MAGENTA);
		p3.draw(gc);

		MyCircle c3 = new MyCircle(400,250,259.2, MyColor.YELLOW);
		c3.draw(gc);

		
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
		*/
		ResizableCanvas canvas = addCanvas();

		StackPane stackPane = new StackPane();
		stackPane.getChildren().add(canvas);

		canvas.widthProperty().bind(stackPane.widthProperty());
		canvas.heightProperty().bind(stackPane.heightProperty());

		primaryStage.setTitle("Assignment #2");
		primaryStage.setResizable(true);
		primaryStage.setScene(new Scene(stackPane));
		primaryStage.show();
		
	}

	public ResizableCanvas addCanvas()
	{
		return new ResizableCanvas();
	}

	public static void main(String[] args) {
		launch(args);
	}
}