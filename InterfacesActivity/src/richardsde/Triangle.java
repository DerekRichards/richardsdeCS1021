package richardsde;

public class Triangle implements Shape {
    private double sideLengthAB;
    private double sideLengthBC;
    private double sideLengthAC;
    private double x;
    private double y;
    private String color;

    public Triangle(String color, double sideLengthAB, double sideLengthBC,
                    double sideLengthAC, double x, double y){
        this.color = color;
        this.sideLengthAB = sideLengthAB;
        this.sideLengthBC = sideLengthBC;
        this.sideLengthAC = sideLengthAC;
        this.x = x;
        this.y = y;
    }

    public double area(){
        return (1.0/2) * x * y;
    }

    public double perimeter(){
        return sideLengthAC + sideLengthAB + sideLengthBC;
    }

    public boolean isRightTriangle(){
        return sideLengthAB == sideLengthBC;
    }

    public boolean isIsoceles(){
        return (sideLengthAB == sideLengthBC) || (sideLengthAB == sideLengthAC)
                || (sideLengthBC == sideLengthAC);
    }

    public String getColor(){
        return color;
    }


    public void move(double x, double y) {
        this.x += x;
        this.y += y;
    }
}
