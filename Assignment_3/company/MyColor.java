package company;

import javafx.scene.paint.Color;

public enum MyColor {

    RED (255,0,0),
    BLUE (0,0,255),
    BROWN (165,42,42),
    PINK (255,192,203),
    BLACK (0,0,0),
    WHITE (255,255,255),
    MAGENTA (255,0,255),
    YELLOW (255,235,59),
    GREEN (0,255,0),
    RANDOM (Math.random(),Math.random(),Math.random());

    private double r,g,b;


    MyColor(){}

    MyColor(double rr, double gg, double bb) {

        this.r = rr;
        this.g = gg;
        this.b = bb;
    }

    public double getR(){return this.r;}
    public double getG(){return this.g;}
    public double getB(){return this.b;}

    public void setR(double rr){this.r = rr;}
    public void setG(double gg){this.g = gg;}
    public void setB(double bb){this.b = bb;}

    public Color getColor(){
        return Color.color(this.r,this.g,this.b);
    }

    @Override
    public String toString(){
        return this.getColor().toString();
    }

}
