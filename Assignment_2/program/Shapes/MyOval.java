package program.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import program.MyColor;


public class MyOval extends MyShape {
    private double x, y, height, width;
    private MyRectangle boundary;
    private MyColor color;
    
    public MyOval(double xx, double yy, double w, double h, MyColor colour){
        super(xx,yy,colour);
        this.height = h;
        this.width = w;
        this.x = xx;
        this.y = yy;
        this.color = colour;
        this.boundary = new MyRectangle(h, w, xx, yy, colour);
        
    }
    
    public double getHeight(){return this.height;}
    
    public double getWidth(){return this.width;}
    
    public double getX(){return this.x;}
    
    public double getY(){return this.y;}
    
    public Color getColor(){return this.color.getColor();}
    
    public void setHeight(double h){this.height = h;}
    
    public void setWidth(double w){this.width = w;}
    
    public void setX(double xx){this.x = xx;}
    
    public void setY(double yy){this.y = yy;}
    
    public void setColor(MyColor colour){this.color = colour;}
    
    public void setBoundary(){boundary = new MyRectangle(height,width,x,y,color);}
    
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

    @Override
    public double[] getPoint() {
        return super.getPoint();
    }

    @Override
    public void moveTo(double xx, double yy) {
        this.x += xx;
        this.y += yy;
    }

    @Override
    public double distanceTo(double xx, double yy) {
        return super.distanceTo(xx, yy);
    }

    @Override
    public MyRectangle getMyBoundingBox() {
        MyRectangle boundBox = new MyRectangle(this.x,this.y,this.width, this.height,this.color);

        return boundBox;
    }

    @Override
    public boolean doOverlap(MyShape secondShape) {
        boolean overlap = this.x + this.width >= secondShape.getX() && this.x <= secondShape.getX() + secondShape.getMyBoundingBox().getWidth() && this.y + this.height >= secondShape.getY() && this.y <= secondShape.getY() + secondShape.getMyBoundingBox().getHeight();

        return overlap;
    }
}