/*
 * Course: CS1021-081
 * Winter 2020-2021
 * Lab 2
 * Name: Derek Richards
 * Created: 12/9/2020
 */
package richardsde;

/**
 * This class represents an ingredient that is being baked.
 */
public class BakedIngredient implements Ingredient {
    private final Ingredient bakedIngredient;
    private final double expansionFactor;

    /**
     * Constructor for the class
     * @param ingredient - An object of the ingredient interface.
     * @param expansionFactor - A value that the volume is multiplied by to find a new volume.
     */
    public BakedIngredient(Ingredient ingredient, double expansionFactor){
        bakedIngredient = ingredient;
        this.expansionFactor = expansionFactor;
    }

    public double getCalories(){
        return bakedIngredient.getCalories();
    }

    public double getCups(){
        return bakedIngredient.getCups() * expansionFactor;
    }

    public String getName(){
        return bakedIngredient.getName();
    }

    public boolean isDry(){
        return true;
    }

    /**
     * Prints out the name and attributes of a baked ingredient
     * and the ingredient's original attributes.
     */
    public void printRecipe(){
        System.out.println("====================================================");
        System.out.println("Baked " + getName());
        System.out.println("====================================================");
        System.out.println("Ingredient to be baked: " + getName());
        System.out.println("Cups: " + CUP_FORMAT.format(getCups()) + " Cups");
        System.out.println("Energy: " + CUP_FORMAT.format(getCalories()) + " Calories\n");
        bakedIngredient.printRecipe();
    }

}
