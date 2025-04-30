package decorator;

public class RedShapeDecorator extends ShapeDecorator {
    private double decorationCost;

    public RedShapeDecorator(Shape decoratedShape, double decorationCost) {
        super(decoratedShape);
        this.decorationCost = decorationCost;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
        System.out.println("Total cost with decoration: " + computerCost());
    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Border Color: Red");
    }

    @Override
    public double computerCost() {
        return super.computerCost() + decorationCost; 
    }
}
