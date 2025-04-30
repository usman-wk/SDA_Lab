package decorator;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle(10.0);
        Shape redCircle = new RedShapeDecorator(new Circle(10.0), 2.0);
        Shape redRectangle = new RedShapeDecorator(new Rectangle(15.0), 3.0);

        System.out.println("Circle with normal border");
        circle.draw();
        System.out.println("Cost: " + circle.computerCost());

        System.out.println("\nCircle of red border");
        redCircle.draw();
        System.out.println("Cost: " + redCircle.computerCost());

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
        System.out.println("Cost: " + redRectangle.computerCost());
    }
}
