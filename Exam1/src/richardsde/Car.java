package richardsde;

public class Car extends Vehicle {
    protected double fuel;
    protected String brand;

    public Car(int numberOfWheels, String color, int weight,
               int numberOfSeats, double fuel, String brand){
        super(numberOfWheels, color, weight, numberOfSeats);
        this.fuel = fuel;
        this.brand = brand;
    }

    public Car(){
        super();
        fuel = 200;
        brand = "Toyota";
    }

    public double getFuel(){
        return fuel;
    }

    public String getBrand(){
        return brand;
    }


}
