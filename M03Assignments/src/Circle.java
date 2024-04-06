public class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public int compareTo(Circle other) {
        if (this.radius < other.radius)
            return -1;
        else if (this.radius > other.radius)
            return 1;
        else
            return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Circle other = (Circle) obj;
        return Double.compare(other.radius, radius) == 0;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    public static void main(String[] args) {
        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(7, "blue", true);

        System.out.println("Circle 1:");
        System.out.println("Radius: " + circle1.getRadius());
        System.out.println("Area: " + circle1.getArea());
        System.out.println("Perimeter: " + circle1.getPerimeter());
        System.out.println("Color: " + circle1.getColor());
        System.out.println("Filled: " + circle1.isFilled());

        System.out.println();

        System.out.println("Circle 2:");
        System.out.println("Radius: " + circle2.getRadius());
        System.out.println("Area: " + circle2.getArea());
        System.out.println("Perimeter: " + circle2.getPerimeter());
        System.out.println("Color: " + circle2.getColor());
        System.out.println("Filled: " + circle2.isFilled());

        System.out.println();

        System.out.println("Circle 1 compared to Circle 2: " + circle1.compareTo(circle2));
        System.out.println("Circle 1 equals Circle 2: " + circle1.equals(circle2));
    }

}
