package decorator;

public class Circle implements Shape {
    private double price; 

    public Circle(double price) {
        this.price = price;
    }

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }

    @Override
    public double computerCost() {
        return price;
    }
}
