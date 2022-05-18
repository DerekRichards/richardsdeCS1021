/*
 * Course: CS1021 - 081
 * Winter 2020/2021
 * Lab 7 - Shapes Revisited
 * Name: Derek Richards
 * Created: 1/27/2021
 */
package richardsde;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.scene.paint.Color;

/**
 * This class represents a point on a grid
 */
public class Point extends Shape {

    /**
     * This is the constructor of the class
     * @param x - The x-coordinate of the point
     * @param y - The y-coordinate of the point
     * @param color - The color of the point
     */
    public Point(double x, double y, Color color){
        super(x, y, color);
    }

    /**
     * Draws the point.
     * @param plotter - WinPlotterFX object used for drawing the shape.
     */
    public void draw(WinPlotterFX plotter){
        plotter.drawPoint(x, y);
    }
}
