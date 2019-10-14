package program.Shapes;

import java.awt.*;
import java.lang.Object;
import javafx.scene.canvas.GraphicsContext;
import program.MyColor;

public class MyRectangle extends MyShape {
    private double height, width, area, perimeter, x, y;
    private MyColor color;
    
    public MyRectangle(double xx, double yy, double w, double h,  MyColor colour){
        super(xx,yy,colour);
        this.height = h;
        this.width = w;
        this.x = xx;
        this.y = yy;
        this.color = colour;
    }
    
    public double getHeight(){return this.height;}
    
    public double getWidth(){return this.width;}
    
    public double getX(){return this.x;}
    
    public double getY(){return this.y;}
    
    public MyColor getColor(){return this.color;}
    
    public void setHeight(double h){this.height = h;}
    
    public void setWidth(double w){this.width = w;}
    
    public void setX(double xx){this.x = xx;}
    
    public void setY(double yy){this.y = yy;}
    
    public void setColor(MyColor colour){this.color = colour;}
    
    public void setArea(){this.area = this.height * this.width;}
    
    public void setPerimeter(){this.perimeter = ((this.height*2)+(this.width*2));}
    
    @Override
    public String toString(){
        String message = this.color + " rectangle with Height: " + this.height + " and Width: " + this.width + ", centered at (" + this.x + "," + this.y + ").";
        return message;
    }


    @Override
    public void draw(GraphicsContext gc){
    	double xx,yy;
    	gc.setFill(this.getColor());
    	
    	xx = this.getX() - (this.getWidth()/2);
    	yy = this.getY() - (this.getHeight()/2);
    	
    	gc.strokeRect(xx,yy,this.getWidth(),this.getHeight());
    	gc.fillRect(xx,yy,this.getWidth(),this.getHeight());
    
    }

}