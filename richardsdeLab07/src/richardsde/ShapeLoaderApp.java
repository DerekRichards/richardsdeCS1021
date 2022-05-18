/*
 * Course: CS1021 - 081
 * Winter 2020/2021
 * Lab 7 - Shapes Revisited
 * Name: Derek Richards
 * Created: 1/27/2021
 */
package richardsde;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * This is a program that reads in files to create shapes.
 */
public class ShapeLoaderApp extends Application {
    /**
     * Launches the JavaFX application
     * @param args ignored
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        WinPlotterFX plotter = new WinPlotterFX();
//        FileOutputStream fos;
//        String fileText = "Demonstration Picture\n800 600\n#F0F0F0\nP: 40 40 #000000\n" +
//                "C: 40 40 #FF0000 30\nT: 60 60 #00FF00 100 50\nR: 160 160 #0000FF 50 150\n" +
//                "LT: 360 360 00FF00 100 50 Tri\nLR: 460 460 #0000FF 150 100 " +
//                "Reck Tangle Angle Rangle";
//
//        try{
//            fos = new FileOutputStream("WrongHexcode.txt");
//            for(int i = 0; i < fileText.length(); i++){
//                fos.write(fileText.charAt(i));
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("That file does not seem to exist.");
//        } catch (IOException e){
//            System.out.println("Something went wrong in IO.");
//        }

        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(plotter);
        try {
            Scanner scan = new Scanner(file);
            plotter.setWindowTitle(scan.nextLine());
            double windowWidth = scan.nextDouble();
            double windowHeight = scan.nextDouble();
            scan.nextLine();
            plotter.setWindowSize(windowWidth, windowHeight);
            String colorCode = scan.nextLine();
            Color color = Color.valueOf(colorCode);
            plotter.setBackgroundColor(color.getRed(), color.getGreen(), color.getBlue());
            List<Shape> shapes = readShapes(scan);
            drawShapes(shapes, plotter);
            plotter.showPlotter();
        } catch (FileNotFoundException e){
            System.out.println("That file does not seem to exist.");
        } catch (InputMismatchException | IllegalArgumentException e){
            Alert headerAlert = new Alert(Alert.AlertType.ERROR,
                    "The header of the file could not be read.");
            headerAlert.setHeaderText("File error");
            headerAlert.setTitle("File error");
            headerAlert.show();
        }


    }

    /**
     * Reads shapes and adds them to a list.
     * @param scan - A scanner object.
     * @return - A list of shapes.
     */
    public List<Shape> readShapes(Scanner scan){
        List<Shape> shapes = new ArrayList<>();
        final int lines = 6;
        for(int i = 1; i <= lines; i++){
            try {
                shapes.add(parseShape(scan.nextLine()));
            } catch (InputMismatchException e){
                System.out.println("The shape could not be read.");
            }

        }
        return shapes;
    }

    /**
     * A method that draws all of the shapes in the list.
     * @param shapes - A list of Shape objects.
     * @param plotter - A WinPlotterFX object.
     */
    public void drawShapes(List<Shape> shapes, WinPlotterFX plotter){
        for (Shape shape : shapes) {
            shape.setPenColor(plotter);
            shape.draw(plotter);
        }
    }

    /**
     * Creates a shape from the text file.
     * @param line - A line form the text file.
     * @return - A shape determined from the line.
     * @throws InputMismatchException - If the format of the line is wrong.
     */
    public static Shape parseShape(String line) throws InputMismatchException{
        Scanner scanShape = new Scanner(line);
        String shapeType = scanShape.next();
        if (shapeType.equals("P:")){
            double x = Double.parseDouble(scanShape.next());
            double y = Double.parseDouble(scanShape.next());
            String shapeColor = scanShape.next();
            return new Point(x, y, stringToColor(shapeColor));
        } else if (shapeType.equals("C:")){
            double x = Double.parseDouble(scanShape.next());
            double y = Double.parseDouble(scanShape.next());
            String shapeColor = scanShape.next();
            double radius = Double.parseDouble(scanShape.next());
            return new Circle(x, y, radius, stringToColor(shapeColor));
        } else if (shapeType.equals("T:")){
            double x = Double.parseDouble(scanShape.next());
            double y = Double.parseDouble(scanShape.next());
            String shapeColor = scanShape.next();
            double base = Double.parseDouble(scanShape.next());
            double height = Double.parseDouble(scanShape.next());
            return new Triangle(x, y, base, height, stringToColor(shapeColor));
        } else if (shapeType.equals("R:")){
            double x = Double.parseDouble(scanShape.next());
            double y = Double.parseDouble(scanShape.next());
            String shapeColor = scanShape.next();
            double width = Double.parseDouble(scanShape.next());
            double height = Double.parseDouble(scanShape.next());
            return new Rectangle(x, y, width, height, stringToColor(shapeColor));
        } else if (shapeType.equals("LT:")){
            double x = Double.parseDouble(scanShape.next());
            double y = Double.parseDouble(scanShape.next());
            String shapeColor = scanShape.next();
            double base = Double.parseDouble(scanShape.next());
            double height = Double.parseDouble(scanShape.next());
            String name = scanShape.nextLine();
            return new LabeledTriangle(x, y, base, height, stringToColor(shapeColor), name);
        } else if (shapeType.equals("LR:")){
            double x = Double.parseDouble(scanShape.next());
            double y = Double.parseDouble(scanShape.next());
            String shapeColor = scanShape.next();
            double width = Double.parseDouble(scanShape.next());
            double height = Double.parseDouble(scanShape.next());
            String name = scanShape.nextLine();
            return new LabeledRectangle(x, y, width, height, stringToColor(shapeColor), name);
        } else {
            throw new InputMismatchException("A shape was not read from the file.");
        }
    }

    /**
     * Takes in a hex triplet as a String and returns a Color object
     * @param colorValue - A hex triplet as a string
     * @return - A Color object
     * @throws InputMismatchException - If the String is not a valid hex triplet.
     */
    public static Color stringToColor(String colorValue) throws InputMismatchException {
        final int hexLength = 7;
        if (colorValue.charAt(0) != '#' || colorValue.length() != hexLength){
            throw new InputMismatchException("The value entered was not a hex triplet.");
        } else{
            return Color.valueOf(colorValue);
        }

    }
}
