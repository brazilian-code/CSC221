package program;

import java.lang.Object;
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

    private String name;


    MyColor(String n) {
        this.name = n;
    }



    public String getName(){return this.name;}

}
