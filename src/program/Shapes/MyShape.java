package program.Shapes;

import javafx.scene.canvas.GraphicsContext;
import program.MyColor;

public abstract class MyShape extends Object {
    private double x,y;
    private MyColor color;
    
    public MyShape(double xCoordinate, double yCoordinate, MyColor colour){
        this.x = xCoordinate;
        this.y = yCoordinate;
        this.color = colour;
    }
    
    public double getX(){return this.x;}
    
    public double getY(){return this.y;}
    
    public MyColor getColor(){return this.color;}
    
    public void setX(double xCoordinate){this.x = xCoordinate;}
    
    public void setY(double yCoordinate){this.y = yCoordinate;}
    
    public void setColor(MyColor colour){this.color = colour;}

    public void draw(GraphicsContext gc){
        gc.setFill(this.getColor());
        gc.fillRect(0, 0, 800, 500);
    }

    @Override
    public String toString(){
        String message = "This is a shape with\nx-coordinate: " + this.x + "\ny-coordinate: " + this.y + "\nColor: " + this.color.getName();
        return message;
    }

}