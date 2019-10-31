package program.Shapes;

public interface MyShapePositionInterface extends MyPositionInterface{
    MyRectangle getMyBoundingBox();
    boolean doOverlap(MyShape secondShape);
}