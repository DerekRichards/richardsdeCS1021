/*
 * Course: CS1021-081
 * Winter 2020-2021
 * Lab 2
 * Name: Derek Richards
 * Created: 12/9/2020
 */
package richardsde;

/**
 * This class represents a basic ingredient.
 */
public class SimpleIngredient implements Ingredient {
    private final double calories;
    private final double cups;
    private final boolean isDry;
    private final String name;

    /**
     * The constructor for the SimpleIngredient class.
     * @param calories - The amount of calories.
     * @param cups - Volume of the ingredient in cups.
     * @param isDry - Whether or not the ingredient is dry.
     * @param name - The name of the ingredient.
     */
    public SimpleIngredient(double calories, double cups, boolean isDry, String name){
        this.calories = calories;
        this.cups = cups;
        this.isDry = isDry;
        this.name = name;
    }

    public double getCalories(){
        return calories;
    }

    public double getCups(){
        return cups;
    }

    public String getName(){
        return name;
    }

    public boolean isDry(){
        return isDry;
    }

    /**
     * Prints out the name and attributes of a simple ingredient.
     */
    public void printRecipe(){
        System.out.println("====================================================");
        System.out.println(getName());
        System.out.println("====================================================");
        System.out.println("Cups: " + CUP_FORMAT.format(getCups()) + " Cups");
        System.out.println("Energy: " + CUP_FORMAT.format(getCalories()) + " Calories\n");
    }
}
