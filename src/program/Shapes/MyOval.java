package program.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class MyOval extends MyShape {
    private double x, y, height, width;
    private Color color;
    
    public MyOval(double xx, double yy, double w, double h, Color colour){
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
    
    public Color getColor(){return this.color;}
    
    public void setHeight(double h){this.height = h;}
    
    public void setWidth(double w){this.width = w;}
    
    public void setX(double xx){this.x = xx;}
    
    public void setY(double yy){this.y = yy;}
    
    public void setColor(Color colour){this.color = colour;}
    
    
    @Override
    public String toString(){
        return this.color.toString() + " Oval with Height: " + this.height + " and Width: " + this.width + ", centered at (" + this.x + "," + this.y + ").";
    }
    
    @Override
    public void draw(GraphicsContext gc){
    	double xx,yy;
    	gc.setFill(this.getColor());
    	
    	xx = this.getX() - (this.getWidth()/2);
    	yy = this.getY() - (this.getHeight()/2);
    	
    	gc.strokeOval(xx,yy,this.getWidth(),this.getHeight());
    	gc.fillOval(xx,yy,this.getWidth(),this.getHeight());
    
    }

}
