package program;

import javafx.scene.paint.Color;


public enum MyColor {

    RED (Color.DARKRED),
    BLUE (Color.LIGHTSKYBLUE),
    BROWN (Color.BURLYWOOD),
    PINK (Color.LIGHTPINK),
    BLACK (Color.rgb(0,0,0)),
    WHITE (Color.SNOW),
    MAGENTA (Color.MEDIUMORCHID),
    GREEN (Color.SEAGREEN);

    private Color color;
    private String name;


    MyColor(Color colour) {
        this.color = colour;
    }

    public Color getColor(){return this.color;}


}
