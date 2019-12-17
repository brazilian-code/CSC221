package program;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import program.MyColor;

public class MyPieChart {

    private double x, y;
    private int n;
    private double[] frequency;
    private String[] letters;

    public MyPieChart(double xCoordinate, double yCoordinate, int nn, double[] ff, String[] ll) {
        this.x = xCoordinate - 150;
        this.y = yCoordinate - 150;
        this.n = nn;
        this.frequency = ff;
        this.letters = ll;
    }

    public void draw(GraphicsContext gc){
        int i;
        //Starting Angle Positions
        double[] pAngle = new double[this.n];
        double total = 0;
        int length = letters.length;
        for(i = 0; i < this.n; i++){
            pAngle[i] = total;
            total += this.frequency[i] * 360;
        }

        //Input n Events
        for(i = 1; i < this.n + 1; i++){
            gc.setFill(Color.color(Math.random(),Math.random(),Math.random()));
            gc.fillArc(this.x, this.y, 300, 300, pAngle[i - 1], this.frequency[i - 1] * 360 + 0.55, ArcType.ROUND);
            gc.fillText("" + this.letters[i - 1] + ": " + Math.round(this.frequency[i - 1] * 10000d) / 10000d, 620, 30 + ((i-1) * 20));
            gc.fillRect(595, ((i) * 20), 10, 10);
        }
    }
}