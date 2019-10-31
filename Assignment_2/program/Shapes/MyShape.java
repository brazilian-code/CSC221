package program.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import program.MyColor;

public abstract class MyShape extends Object implements MyShapePositionInterface {
    private double x,y;
    private MyColor color;
    
    public MyShape(double xCoordinate, double yCoordinate, MyColor colour){
        this.x = xCoordinate;
        this.y = yCoordinate;
        this.color = colour;
    }
    
    public double getX(){return this.x;}
    
    public double getY(){return this.y;}
    
    public Color getColor(){return this.color.getColor();}
    
    public void setX(double xCoordinate){this.x = xCoordinate;}
    
    public void setY(double yCoordinate){this.y = yCoordinate;}
    
    public void setColor(MyColor colour){this.color = colour;}

    public void draw(GraphicsContext gc){
        gc.setFill(this.getColor());
        gc.fillRect(0, 0, 800, 500);
    }

    @Override
    public String toString(){
        return "This is a shape with\nx-coordinate: " + this.x + "\ny-coordinate: " + this.y + "\nColor: " + this.color.toString();
    }

    @Override
    public double[] getPoint(){
        double[] point = new double[2];
        point[0] = this.x;
        point[1] = this.y;

        return point;
    }

    @Override
    public void moveTo(double xx, double yy){
        this.x += xx;
        this.y += yy;
    }

    @Override
    public double distanceTo(double xx, double yy){
        double deltaX = this.x - xx;
        double deltaY = this.y - yy;

        return Math.sqrt((Math.pow(deltaX,2))+(Math.pow(deltaY,2)));
    }

}