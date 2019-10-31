package program.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import program.MyColor;

public class MyPolygon extends MyShape {
    private double x,y, angle, sideLength;
    private int n;
    private MyColor color;

    public MyPolygon(double xx, double yy, double sLength, int nSides, MyColor colour){
        super(xx,yy,colour);
        this.x = xx;
        this.y = yy;
        this.n = nSides;
        this.sideLength = sLength;
        this.color = colour;
        this.angle = 180*(nSides - 2) / nSides;
    }

    public double getX(){return this.x;}

    public double getY(){return this.y;}

    public Color getColor(){return this.color.getColor();}

    public double getAngle(){return this.angle;}

    public double getSideLength(){return this.sideLength;}

    public void setX(double xx){this.x = xx;}

    public void setY(double yy){this.y = yy;}

    public void setColor(MyColor colour){this.color = colour;}

    public void setSideLength(double l){this.sideLength = l;}


    @Override
    public String toString(){
        return this.color.toString() +" Polygon with " + this.n + " sides of length " + this.sideLength + " and interior angle " + this.angle + ", centered at (" + this.x + "," + this.y + ").";
    }

    @Override
    public void draw(GraphicsContext gc){

        double[] xPoints = new double[this.n];
        double[] yPoints = new double[this.n];

        double angle = (this.n - 1) * this.angle;
        double increment = (2*Math.PI)/this.n;
        for(int i = 0; i < this.n; i++){
            xPoints[i] = (this.sideLength*Math.cos(angle)) + this.x;
            yPoints[i] = (this.sideLength*Math.sin(angle)) + this.y;
            angle += increment;
        }

        gc.setFill(this.getColor());
        gc.strokePolygon(xPoints, yPoints, this.n);
        gc.fillPolygon(xPoints, yPoints, this.n);
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
        MyRectangle boundBox = new MyRectangle(this.x, this.y, this.sideLength, this.sideLength, this.color );

        return boundBox;
    }

    @Override
    public boolean doOverlap(MyShape secondShape) {
        boolean overlap = this.x + this.sideLength >= secondShape.getX() && this.x <= secondShape.getX() + secondShape.getMyBoundingBox().getWidth() && this.y + this.sideLength >= secondShape.getY() && this.y <= secondShape.getY() + secondShape.getMyBoundingBox().getHeight();

        return overlap;
    }
}
