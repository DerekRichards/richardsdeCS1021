/*
 * Course: CS1021-081
 * Winter 2020-2021
 * Lab 2
 * Name: Derek Richards
 * Created: 12/9/2020
 */
package richardsde;


import java.text.DecimalFormat;

/**
 * Represents an ingredient used in a cooking recipe.
 */
public interface Ingredient {
    /**
     * DecimalFormat object used for rounding purposes.
     */
    DecimalFormat CUP_FORMAT = new DecimalFormat("#.##");

    /**
     * Returns the amount of calories in an ingredient.
     * @return - The amount of calories in an ingredient.
     */
    double getCalories();

    /**
     * Returns the volume of the ingredient in cups.
     * @return - The volume of the ingredient.
     */
    double getCups();

    /**
     * Returns the ingredient's name.
     * @return - The ingredient's name.
     */
    String getName();

    /**
     * Checks if the ingredient is dry.
     * @return - True if the ingredient is dry, false otherwise.
     */
    boolean isDry();

    /**
     * Displays the name of the ingredient and basic information about the ingredient.
     */
    void printRecipe();
}
