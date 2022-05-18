/*
 * Course: CS1021-081
 * Winter 2020-2021
 * Lab 2
 * Name: Derek Richards
 * Created: 12/9/2020
 */
package richardsde;

/**
 * Represents an ingredient that is being measured.
 */
public class Measure implements Ingredient {
    private final int numerator;
    private final int denominator;
    private final Ingredient measuredIngredient;

    /**
     * Primary constructor for the class.
     *
     * @param numerator - The numerator in the fractional value for volume.
     * @param denominator - The denominator in the fractional value for volume.
     * @param measuredIngredient - The ingredient being measured.
     */
    public Measure(int numerator, int denominator, Ingredient measuredIngredient){
        this.numerator = numerator;
        this.denominator = denominator;
        this.measuredIngredient = measuredIngredient;
    }

    /**
     * Another constructor that calls the primary constructor for the class.
     *
     * @param numerator - The value for the volume in cups.
     * @param measuredIngredient - The ingredient being measured.
     */
    public Measure(int numerator, Ingredient measuredIngredient){
        this(numerator, 1, measuredIngredient);
    }

    public double getCalories(){
        return (this.numerator / (double)this.denominator *
                (measuredIngredient.getCalories() / measuredIngredient.getCups()));
    }

    public double getCups(){
        return (this.numerator / (double)this.denominator);
    }

    public String getName(){
        return formatQuantity() + " Cups " + measuredIngredient.getName();
    }

    public boolean isDry(){
        return measuredIngredient.isDry();
    }

    /**
     * Prints out the name and attributes of a measured ingredient
     * and the ingredient's original attributes.
     */
    public void printRecipe(){
        System.out.println("====================================================");
        System.out.println(getName());
        System.out.println("====================================================");
        System.out.println("Measured ingredient: " + measuredIngredient.getName());
        System.out.println("Quantity: " + formatQuantity() + " Cups ("
                + CUP_FORMAT.format(getCups()) + " Cups)");
        System.out.println("Energy: " + CUP_FORMAT.format(getCalories()) + " Calories\n");
        measuredIngredient.printRecipe();
    }

    private String formatQuantity(){
        if (denominator == 1){
            return String.valueOf(numerator);
        } else {
            return numerator + "/" + denominator;
        }
    }
}
