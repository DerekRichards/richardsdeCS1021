/*
 * Course: CS1021 - 081
 * Winter 2020/2021
 * Lab 7 - Revisiting Shapes
 * Name: Derek Richards
 * Created: 1/27/2021
 */
package richardsde;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.scene.paint.Color;

/**
 * This class describes a LabeledRectangle with text in the lower left corner.
 */
public class LabeledRectangle extends Rectangle {
    private final String name;

    /**
     * Constructor for the LabeledRectangle object
     * @param x - The lower-left corner x-value of the rectangle.
     * @param y - The lower-left corner y-value of the rectangle.
     * @param width - The width of the rectangle.
     * @param height - The height of the rectangle.
     * @param color - The color of the rectangle.
     * @param name - The text assigned to the label.
     */
    public LabeledRectangle(double x, double y, double width, double height,
                            Color color, String name) {
        super(x, y, width, height, color);
        this.name = name;
    }

    /**
     * A method that draws the LabeledRectangle object using WinPlotterFX
     * @param plotter - WinPlotterFX object used for drawing the shape.
     */
    public void draw(WinPlotterFX plotter){
        super.draw(plotter);
        plotter.printAt(x, y, name);
    }
}
