/*
 * Course: CS1021 - 081
 * Winter 2020/2021
 * Lab 7 - Revisiting Shapes
 * Name: Derek Richards
 * Created: 1/27/2021
 */
package richardsde;

import javafx.scene.paint.Color;
import edu.msoe.winplotterfx.WinPlotterFX;

/**
 * This object describes a Rectangle object that extends the Shape object
 */
public class Rectangle extends Shape {
    protected final double height;
    protected final double width;

    /**
     * Constructor for the Rectangle object
     * @param x - The lower left corner x-value of the rectangle
     * @param y - The lower left corner y-value of the rectangle
     * @param width - The width of the rectangle
     * @param height - The height of the rectangle
     * @param color - The color of the rectangle
     * @throws IllegalArgumentException - If width and height aren't positive
     */
    public Rectangle(double x, double y, double width,
                     double height, Color color) throws IllegalArgumentException{
        super(x, y, color);
        if (width <= 0 || height <= 0){
            throw new IllegalArgumentException("Height and width " +
                    "cannot be less than or equal to zero.");
        } else {
            this.width = width;
            this.height = height;
        }

    }

    /**
     * This method draws the rectangle using WinPlotterFX
     * @param plotter - WinPlotterFX object used for drawing the shape.
     */
    public void draw(WinPlotterFX plotter){
        plotter.moveTo(x, y);
        plotter.drawTo(x + width, y);
        plotter.drawTo(x + width, y + height);
        plotter.drawTo(x, y + height);
        plotter.drawTo(x, y);

    }
}
