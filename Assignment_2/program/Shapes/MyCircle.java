package program.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import program.MyColor;

public class MyCircle extends MyShape {
    private double x, y, radius;
    private MyColor color;

    public MyCircle(double xx, double yy, double r, MyColor colour){
        super(xx,yy,colour);
        this.x = xx;
        this.y = yy;
        this.radius = r;
        this.color = colour;
    }

    public double getRadius(){return this.radius;}

    public double getX(){return this.x;}

    public double getY(){return this.y;}

    public Color getColor(){return this.color.getColor();}

    public void setRadius(double r){this.radius = r;}

    public void setX(double xx){this.x = xx;}

    public void setY(double yy){this.y = yy;}

    public void setColor(MyColor colour){this.color = colour;}

    @Override
    public String toString() {
        return this.color.toString() + " Circle with Radius: " + this.radius + ", centered at (" + this.x + "," + this.y + ").";
    }

    @Override
    public void draw(GraphicsContext gc) {
        double xx, yy;

        xx = this.getX() - (this.getRadius()/2);
        yy = this.getY() - (this.getRadius()/2);

        gc.setFill(this.getColor());
        gc.strokeOval(xx,yy,this.getRadius(),this.getRadius());
        gc.fillOval(xx,yy,this.getRadius(),this.getRadius());
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
        MyRectangle boundBox = new MyRectangle(this.x, this.y, this.radius, this.radius, this.color );

        return boundBox;
    }

    @Override
    public boolean doOverlap(MyShape secondShape) {
        boolean overlap = this.x + this.radius >= secondShape.getX() && this.x <= secondShape.getX() + secondShape.getMyBoundingBox().getWidth() && this.y + this.radius >= secondShape.getY() && this.y <= secondShape.getY() + secondShape.getMyBoundingBox().getHeight();

        return overlap;
    }
}
