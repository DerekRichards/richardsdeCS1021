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
 * This class describes a Circle object.
 */
public class Circle extends Shape {
    private final double radius;

    /**
     * Constructor for the Circle class
     * @param x - The lower left corner x-value for the circle.
     * @param y - The lower left corner y-value for the circle.
     * @param radius - The length of the radius of the circle.
     * @param color - The color of the circle.
     */
    public Circle(double x, double y, double radius, Color color){
        super(x, y, color);
        this.radius = radius;
    }

    /**
     * Constructor for the Circle class
     * @param x - The lower left corner x-value for the circle.
     * @param y - The lower left corner y-value for the circle.
     * @param width - The width of the circle.
     * @param height - The height of the circle.
     * @param color - The color of the circle.
     */
    public Circle(double x, double y, double width, double height, Color color){
        this(x, y, (1.0/2.0 * width), color);
    }

    /**
     * A method that draws a circle using WinPlotterFX
     * @param plotter - WinPlotterFX object used for drawing the shape.
     */
    public void draw(WinPlotterFX plotter){
        plotter.moveTo(x + 2 * radius, y + radius);
        final int oneHundred = 100;
        double i = 2 * Math.PI / oneHundred;
        double centerX = x + radius;
        double centerY = y + radius;

        for(double j = 0; j < 2 * Math.PI; j += i) {
            double tempX = centerX + radius * Math.cos(j);
            double tempY = centerY - radius * Math.sin(j);
            plotter.drawTo(tempX, tempY);
        }

    }
}
