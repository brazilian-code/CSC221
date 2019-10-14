package program.Shapes;

import java.lang.Object;
import javafx.scene.canvas.GraphicsContext;
import program.MyColor;

public class MyLine extends MyShape {
    private double x1,x2,y1,y2;
    private MyColor color;
    
    public MyLine(double xx1, double yy1, double xx2, double yy2, MyColor colour){
        super(xx1,yy1,colour);
        this.x1 = xx1;
        this.x2 = xx2;
        this.y1 = yy1;
        this.y2 = yy2;
        this.color = colour;
    }
    
    public double getX1(){return this.x1;}
    
    public double getX2(){return this.x2;}
    
    public double getY1(){return this.y1;}
    
    public double getY2(){return this.y2;}
    
    public MyColor getColor(){return this.color;}
    
    public void setX1(double x){this.x1 = x;}
    
    public void setX2(double x){this.x2 = x;}
    
    public void setY1(double y){this.y1 = y;}
    
    public void setY2(double y){this.y2 = y;}
    
    public void setColor(MyColor colour){this.color = colour;}
    
    @Override
    public String toString(){
        String message = this.color + " line from (" + this.x1 + "," + this.y1 + ") to (" + this.x2 + "," + this.y2 + ").";
        return message;
    }
    
    @Override
    public void draw(GraphicsContext gc){
    	gc.setStroke(this.getColor());
    	gc.strokeLine(this.getX1(),this.getY1(),this.getX2(),this.getY2());
        
    }
    
}