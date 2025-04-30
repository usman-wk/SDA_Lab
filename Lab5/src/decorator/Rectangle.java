package decorator;

public class Rectangle implements Shape {
    private double price;

    public Rectangle(double price) {
        this.price = price;
    }

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }

    @Override
    public double computerCost() {
        return price;
    }
}
