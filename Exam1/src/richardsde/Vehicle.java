package richardsde;

public abstract class Vehicle {
    protected int numberOfWheels;
    protected String color;
    protected int weight;
    protected int numberOfSeats;

    public Vehicle(int numberOfWheels, String color, int weight, int numberOfSeats){
        this.numberOfWheels = numberOfWheels;
        this.color = color;
        this.weight = weight;
        this.numberOfSeats = numberOfSeats;
    }

    public Vehicle(){
        this(4, "Black", 300, 2);
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public String getColor(){
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }
}
