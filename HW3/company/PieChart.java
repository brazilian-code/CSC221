package company;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import company.MyColor;

public class PieChart {

    private double x, y;
    private int n;
    private double[] frequency;
    private char[] letters;

    public PieChart(double xCoordinate, double yCoordinate, int nn, double[] ff, char[] ll) {
        this.x = xCoordinate - 150;
        this.y = yCoordinate - 150;
        this.n = nn;
        this.frequency = ff;
        this.letters = ll;
    }

    public void draw(GraphicsContext gc){
        int i;
        //Starting Angle Positions
        double[] pAngle = new double[26];
        double total = 0;
        for(i = 0; i < 26; i++){
            pAngle[i] = total;
            total += this.frequency[i] * 360;
        }

        if(this.n !=26) {
            //All Other Events
            double angChart;
            gc.setFill(Color.color(Math.random(),Math.random(),Math.random()));
            if(this.n !=0){
                angChart = (((Math.round(pAngle[n] * 10000d) / 10000d)) / 360);
                gc.fillArc(this.x, this.y, 300, 300, pAngle[n], 374.3 - pAngle[n], ArcType.ROUND);
            }else{
                angChart = 0;
                gc.fillArc(this.x, this.y, 300, 300, pAngle[n], 360 - angChart, ArcType.ROUND);
            }
            gc.fillText("Sum of Other Events: " + Math.round((1 - angChart) * 10000d) / 10000d, 620, 10.5);
            gc.fillRect(595, 0, 10, 10);
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
