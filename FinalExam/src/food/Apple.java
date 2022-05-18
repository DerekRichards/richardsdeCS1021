package food;

public class Apple extends Fruit {
    private int numSeeds;

    public Apple(String type, double volume, int numSeeds){
        super(type, volume);
        this.numSeeds = numSeeds;
    }

    public void removeSeeds(){
        if (numSeeds > 0){
            numSeeds--;
        }
    }

    @Override
    public String toString(){
        return "Type: " + getType() + " Volume: " + getVolume() + " Number of seeds: " + numSeeds;
    }

    public boolean isPrepped(){
        return numSeeds == 0;
    }
}
