/*
 * Course: CS1021-081
 * Winter 2020-2021
 * Lab 2
 * Name: Derek Richards
 * Created: 12/9/2020
 */
package richardsde;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a food with a mix of ingredients.
 */
public class Mix implements Ingredient {
    private final List<Ingredient> ingredients = new ArrayList<>();
    private final String name;

    /**
     * Constructor of the class.
     * @param name - The name of the mixed ingredient
     */
    public Mix(String name){
        this.name = name;
    }

    /**
     * Adds an ingredient to the list.
     * @param ingredient - An ingredient
     */
    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }

    /**
     * Checks whether or not the list has a dry ingredient.
     * @return - true if there is a dry ingredient, false otherwise.
     */
    public boolean hasDryIngredient(){
        if (!ingredients.isEmpty()){
            for (Ingredient ingredient : ingredients) {
                if (ingredient.isDry()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /**
     * Checks whether or not the list has a wet ingredient.
     * @return - true if there is a wet ingredient, false otherwise
     */
    public boolean hasWetIngredient(){
        if (!ingredients.isEmpty()){
            for (Ingredient ingredient : ingredients) {
                if (!ingredient.isDry()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /**
     * Gets the total amount of calories from the list.
     * @return - The total amount of calories.
     */
    public double getCalories(){
        double sum = 0;
        for (Ingredient ingredient : ingredients){
            sum += ingredient.getCalories();
        }
        return sum;
    }

    /**
     * Gets the total volume in cups from the list.
     * @return - The total amount of volume in cups.
     */
    public double getCups(){
        double sum = 0;
        for (Ingredient ingredient : ingredients){
            sum += ingredient.getCups();
        }
        return sum;
    }

    public String getName(){
        return name;
    }

    /**
     * Checks whether or not the mixed ingredient is completely dry.
     * @return - false if even one ingredient is wet, true otherwise.
     */
    public boolean isDry(){
        for (Ingredient ingredient : ingredients){
            if (!ingredient.isDry()){
                return false;
            }
        }
        return true;
    }

    /**
     * Prints out the name and attributes of the mixed ingredient,
     * as well as printing out the wet and dry ingredients.
     */
    public void printRecipe(){
        System.out.println("====================================================");
        System.out.println(getName());
        System.out.println("====================================================");
        if (hasDryIngredient()){
            System.out.println("Dry Ingredients:");
            for (Ingredient ingredient : ingredients){
                if (ingredient.isDry()){
                    System.out.println("\t" + ingredient.getName());
                }
            }
        }
        if (hasWetIngredient()){
            System.out.println("Wet Ingredients:");
            for (Ingredient ingredient : ingredients){
                if (!ingredient.isDry()){
                    System.out.println("\t" + ingredient.getName());
                }
            }
        }
        System.out.println("Cups: " + CUP_FORMAT.format(getCups()) + " Cups");
        System.out.println("Energy: " + CUP_FORMAT.format(getCalories()) + " Calories\n");
        for (Ingredient ingredient : ingredients){
            ingredient.printRecipe();
        }
    }
}
