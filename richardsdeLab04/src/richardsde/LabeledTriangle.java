/*
 * Course: CS1021 - 081
 * Winter 2020/2021
 * Lab 4 - Inheritance with Shapes
 * Name: Derek Richards
 * Created: 1/6/2021
 */
package richardsde;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.scene.paint.Color;

/**
 * This class describes a LabeledTriangle object with a text label in the lower left corner.
 */
public class LabeledTriangle extends Triangle {
    private final String name;

    /**
     * Constructor for the LabeledTriangle object
     * @param x - The lower left corner x-value of the Triangle.
     * @param y - The lower left corner y-value of the Triangle.
     * @param base - The length of the base of the Triangle.
     * @param height - The height of the Triangle.
     * @param color - The color of the Triangle.
     * @param name - The text assigned to the label.
     */
    public LabeledTriangle(double x, double y, double base,
                           double height, Color color, String name){
        super(x, y, base, height, color);
        this.name = name;
    }

    /**
     * A method that draws a LabeledTriangle using WinPlotterFX
     * @param plotter - WinPlotterFX object used for drawing the shape.
     */
    public void draw(WinPlotterFX plotter){
        super.draw(plotter);
        plotter.printAt(x, y, name);
    }
}
