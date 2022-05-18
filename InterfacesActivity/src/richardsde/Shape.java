package richardsde;

public interface Shape {
    double PI = Math.PI;

    double area();
    double perimeter();
    String getColor();

    public static int maximumArea(Shape shape1, Shape shape2){
        int returnValue = 0;
        if (shape1.area() > shape2.area()){
            returnValue = 1;
        } else if (shape1.area() < shape2.area()){
            returnValue = 2;
        }
        return returnValue;
    }

    void move(double x, double y);

}
