package food;

import java.util.ArrayList;

public class FoodOMatic {
    public double blend(ArrayList<Fruit> fruits){
        double sum = 0;
        for (Fruit fruit: fruits){
            sum += fruit.getVolume();
        }
        return sum;
    }

    public void prep(ArrayList<Apple> fruits){
        for (Apple fruit: fruits){
            while (!fruit.isPrepped()){
                fruit.removeSeeds();
            }
        }
    }
}
