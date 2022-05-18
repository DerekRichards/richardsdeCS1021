package food;

public abstract class Fruit {
    private double volume;
    private String type;

    public Fruit(String type, double volume){
        this.type = type;
        this.volume = volume;
    }

    public double getVolume(){
        return volume;
    }

    public String getType(){
        return type;
    }

    public abstract boolean isPrepped();

}
