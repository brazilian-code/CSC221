package program.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class MyShape extends Object {
    private double x,y;
    private Color color;
    
    public MyShape(double xCoordinate, double yCoordinate, Color colour){
        this.x = xCoordinate;
        this.y = yCoordinate;
        this.color = colour;
    }
    
    public double getX(){return this.x;}
    
    public double getY(){return this.y;}
    
    public Color getColor(){return this.color;}
    
    public void setX(double xCoordinate){this.x = xCoordinate;}
    
    public void setY(double yCoordinate){this.y = yCoordinate;}
    
    public void setColor(Color colour){this.color = colour;}

    public void draw(GraphicsContext gc){
        gc.setFill(this.getColor());
        gc.fillRect(0, 0, 800, 500);
    }

    @Override
    public String toString(){
        return "This is a shape with\nx-coordinate: " + this.x + "\ny-coordinate: " + this.y + "\nColor: " + this.color.toString();
    }

}
