package program.Shapes;

public interface MyPositionInterface{
    double[] getPoint();
    void moveTo(double xx, double yy);
    double distanceTo(double xx, double yy);
}