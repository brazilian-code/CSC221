package program;

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
    GREEN (0,255,0);

    private int r,g,b;


    MyColor(int rr, int gg, int bb) {

        this.r = rr;
        this.g = gg;
        this.b = bb;
    }

    public int getR(){return this.r;}
    public int getG(){return this.g;}
    public int getB(){return this.b;}

    public Color getColor(){
        return Color.rgb(this.r,this.g,this.b);
    }

    @Override
    public String toString(){
        return this.getColor().toString();
    }

}
