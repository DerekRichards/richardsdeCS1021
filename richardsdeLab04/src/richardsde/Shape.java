/*
 * Course: CS1021 - 081
 * Winter 2020/2021
 * Lab 4 - Inheritance with Shapes
 * Name: Derek Richards
 * Created: 1/6/2021
 */
package richardsde;

import javafx.scene.paint.Color;
import edu.msoe.winplotterfx.WinPlotterFX;

/**
 * An abstract class that describes a generic shape
 */
public abstract class Shape {
    private Color color;
    protected final double x;
    protected final double y;

    /**
     * Constructor for the shape class
     * @param x - starting x-coordinate
     * @param y - starting y-coordinate
     * @param color - The color of the shape
     */
    public Shape(double x, double y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * An abstract method for drawing a shape.
     * @param plotter - WinPlotterFX object used for drawing the shape.
     */
    public abstract void draw(WinPlotterFX plotter);

    /**
     * Sets the pen color of the WinPlotterFX object.
     * @param plotter - WinPlotterFX object used for drawing the shape.
     */
    public void setPenColor(WinPlotterFX plotter){
        plotter.setPenColor(color.getRed(), color.getGreen(), color.getBlue());
    }

    public void setColor(Color color){
        this.color = color;
    }
}
