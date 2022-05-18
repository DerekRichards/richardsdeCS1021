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
 * This class describes a Triangle object.
 */
public class Triangle extends Shape {
    protected final double base;
    protected final double height;

    /**
     * Constructor for the triangle object.
     * @param x - The lower left corner x-value of the Triangle.
     * @param y - The lower left corner y-value of the Triangle.
     * @param base - The length of the base of the Triangle.
     * @param height - The height of the Triangle.
     * @param color - The color of the Triangle.
     */
    public Triangle(double x, double y, double base, double height, Color color){
        super(x, y, color);
        this.base = base;
        this.height = height;
    }

    /**
     * A method that draws the Triangle using WinPlotterFX
     * @param plotter - WinPlotterFX object used for drawing the shape.
     */
    public void draw(WinPlotterFX plotter){
        plotter.moveTo(x, y);
        plotter.drawTo(x + (base/2), y + height);
        plotter.drawTo(x + base, y);
        plotter.drawTo(x, y);
    }
}
