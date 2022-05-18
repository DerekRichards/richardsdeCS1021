/*
 * Course: CS1021 - 081
 * Winter 2020/2021
 * Lab 4 - Inheritance with Shapes
 * Name: Derek Richards
 * Created: 1/6/2021
 */
package richardsde;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Scanner;

/**
 * This class draws a face out of a bunch of rectangles.
 * @author taylor
 * @version 20191216
 */
public class FaceMaker extends Application {
    public static final int WINDOW_SIZE = 800;
    public static final int GRID_INCREMENT = WINDOW_SIZE/10;
    public static final int HEAD_SIZE = 700;

    /**
     * Launches the JavaFX application
     * @param args ignored
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Use the Shape class and its descendants to draw a face.
     * @param stage Default stage given to a JavaFX program. Unused.
     */
    @Override
    public void start(Stage stage) {
        WinPlotterFX plotter = new WinPlotterFX();
        plotter.setWindowTitle("Face Maker");
        plotter.setWindowSize(WINDOW_SIZE, WINDOW_SIZE);
        plotter.setBackgroundColor(Color.BLACK.getRed(), Color.BLACK.getGreen(),
                Color.BLACK.getBlue());
        final boolean showGrid = true;
        plotter.setGrid(showGrid, GRID_INCREMENT, GRID_INCREMENT, Color.GRAY);
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the FaceMaker Program. " +
                "This program creates a face from shapes.");
        System.out.println("The available shapes are:");
        System.out.println("Rectangles.");
        System.out.println("Circles.");
        System.out.println("Triangles.");
        System.out.println("Labeled Rectangles.");
        System.out.println("Labeled Triangles.");
        System.out.println("Random shapes.");
        System.out.println("Which option would you like to use?");
        String choice = in.nextLine();


        Shape head;
        Shape leftEye;
        Shape rightEye;
        Shape nose;
        Shape mouth;
        final int five = 5;

        // This code uses a number to represent the individual shapes.
        // 1 = rectangle, 2 = circle, 3 = triangle,
        // 4 = labeled rectangle, 5 = labeled triangle
        if (choice.equalsIgnoreCase("rectangles")){
            head = createHead(1);
            leftEye = createLeftEye(1);
            rightEye = createRightEye(1);
            nose = createNose(1);
            mouth = createMouth(1);
        } else if(choice.equalsIgnoreCase("circles")){
            head = createHead(2);
            leftEye = createLeftEye(2);
            rightEye = createRightEye(2);
            nose = createNose(2);
            mouth = createMouth(2);
        } else if(choice.equalsIgnoreCase("triangles")){
            head = createHead(3);
            leftEye = createLeftEye(3);
            rightEye = createRightEye(3);
            nose = createNose(3);
            mouth = createMouth(3);
        } else if(choice.equalsIgnoreCase("labeled rectangles")){
            head = createHead(4);
            leftEye = createLeftEye(4);
            rightEye = createRightEye(4);
            nose = createNose(4);
            mouth = createMouth(4);
        } else if(choice.equalsIgnoreCase("labeled triangles")){
            head = createHead(five);
            leftEye = createLeftEye(five);
            rightEye = createRightEye(five);
            nose = createNose(five);
            mouth = createMouth(five);
        } else{
            head = createHead((int)(Math.random() * five + 1));
            leftEye = createLeftEye((int)(Math.random() * five + 1));
            rightEye = createRightEye((int)(Math.random() * five + 1));
            nose = createNose((int)(Math.random() * five + 1));
            mouth = createMouth((int)(Math.random() * five + 1));
        }

        head.setPenColor(plotter);
        head.draw(plotter);
        leftEye.setPenColor(plotter);
        leftEye.draw(plotter);
        rightEye.setPenColor(plotter);
        rightEye.draw(plotter);
        nose.setPenColor(plotter);
        nose.draw(plotter);
        mouth.setPenColor(plotter);
        mouth.draw(plotter);

        plotter.showPlotter();
    }

    /**
     * Creates and returns a shape representing the head
     * @param type - What shape the head is
     * @return shape representing the head
     */
    private Shape createHead(int type) {
        final int xLeft = (WINDOW_SIZE-HEAD_SIZE)/2;
        final int yBottom = (WINDOW_SIZE-HEAD_SIZE)/2;

        if (type == 1){
            return new Rectangle(xLeft, yBottom, HEAD_SIZE, HEAD_SIZE, Color.WHITE);
        } else if(type == 2){
            return new Circle(xLeft, yBottom, HEAD_SIZE, HEAD_SIZE, Color.WHITE);
        } else if(type == 3){
            return new Triangle(xLeft, yBottom, HEAD_SIZE, HEAD_SIZE, Color.WHITE);
        } else if (type == 4){
            return new LabeledRectangle(xLeft, yBottom, HEAD_SIZE, HEAD_SIZE, Color.WHITE, "head");
        } else {
            return new LabeledTriangle(xLeft, yBottom, HEAD_SIZE, HEAD_SIZE, Color.WHITE, "head");
        }

    }

    /**
     * Creates and returns a shape representing the right eye
     * @param type - What shape the right eye is
     * @return shape representing the right eye
     */
    private Shape createRightEye(int type) {
        final double scaleFactor = 0.15;
        final double size = scaleFactor*HEAD_SIZE;
        final double yBottom = WINDOW_SIZE/2 + size*3/2;
        final double xLeft = WINDOW_SIZE/2 + size;

        if (type == 1){
            return new Rectangle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (type == 2){
            return new Circle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (type == 3){
            return new Triangle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (type == 4){
            return new LabeledRectangle(xLeft, yBottom, size, size, Color.WHITE, "right eye");
        } else {
            return new LabeledTriangle(xLeft, yBottom, size, size, Color.WHITE, "right eye");
        }

    }

    /**
     * Creates and returns a shape representing the left eye
     * @param type - What shape the right eye is.
     * @return shape representing the left eye
     */
    private Shape createLeftEye(int type) {
        final double scaleFactor = 0.15;
        final double size = scaleFactor*HEAD_SIZE;
        final double yBottom = WINDOW_SIZE/2 + size*3/2;
        final double xLeft = WINDOW_SIZE/2 - size*2;

        if (type == 1){
            return new Rectangle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (type == 2){
            return new Circle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (type == 3){
            return new Triangle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (type == 4){
            return new LabeledRectangle(xLeft, yBottom, size, size, Color.WHITE, "left eye");
        } else {
            return new LabeledTriangle(xLeft, yBottom, size, size, Color.WHITE, "left eye");
        }

    }

    /**
     * Creates and returns a shape representing the nose
     * @param type - What shape the nose is.
     * @return shape representing the nose
     */
    private Shape createNose(int type) {
        final double scaleFactor = 0.2;
        final double size = scaleFactor*HEAD_SIZE;
        final double xLeft = WINDOW_SIZE/2 - size/2;
        final double yBottom = (WINDOW_SIZE)/2;


        if (type == 1){
            return new Rectangle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (type == 2){
            return new Circle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (type == 3){
            return new Triangle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (type == 4){
            return new LabeledRectangle(xLeft, yBottom, size, size, Color.WHITE, "nose");
        } else {
            return new LabeledTriangle(xLeft, yBottom, size, size, Color.WHITE, "nose");
        }
    }

    /**
     * Creates and returns a shape representing the mouth
     * @param type - What shape the mouth is.
     * @return shape representing the mouth
     */
    private Shape createMouth(int type) {
        final double scaleFactor = 0.3;
        final double size = scaleFactor*HEAD_SIZE;
        final double xLeft = WINDOW_SIZE/2 - size/2;
        final double yBottom = (WINDOW_SIZE)/2 - size*3/2;


        if (type == 1){
            return new Rectangle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (type == 2){
            return new Circle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (type == 3){
            return new Triangle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (type == 4){
            return new LabeledRectangle(xLeft, yBottom, size, size, Color.WHITE, "mouth");
        } else {
            return new LabeledTriangle(xLeft, yBottom, size, size, Color.WHITE, "mouth");
        }
    }

}