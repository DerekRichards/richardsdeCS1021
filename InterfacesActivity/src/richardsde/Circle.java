package richardsde;

public class Circle implements Shape {
    private double radius;
    private double centerX;
    private double centerY;
    private String color;

    public Circle(String color, double radius, double centerX, double centerY){
        this.color = color;
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public double area(){
        return Math.PI * Math.pow(radius, 2);
    }

    public double perimeter(){
        return radius * 2 * Math.PI;
    }

    public double diameter(){
        return radius * 2;
    }

    public String getColor(){
        return color;
    }

    public void move(double x, double y) {
        centerX += x;
        centerY += y;
    }
}
