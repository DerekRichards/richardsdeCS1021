package richardsde;

/**
 * A simple class representing a rectangle
 */
public class Rectangle implements Shape {
    private double width;
    private double height;
    private double upperLeftX;
    private double upperLeftY;
    private String color;

    public Rectangle(String color, double height, double width,
                     double upperLeftX, double upperLeftY){
        this.color = color;
        this.height = height;
        this.width = width;
        this.upperLeftX = upperLeftX;
        this.upperLeftY = upperLeftY;
    }

    public double area(){
        return width * height;
    }

    public double perimeter(){
        return (2 * width) + (2 * height);
    }

    public boolean isSquare(){
        return width == height;
    }

    public String getColor(){
        return color;
    }

    public void move(double x, double y){
        upperLeftX += x;
        upperLeftY += y;
    }
}
