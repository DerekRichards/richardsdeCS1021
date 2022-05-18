package richardsde;

import edu.msoe.cs1021.ImageUtil;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.io.*;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class reads and writes image files.
 */
public class ImageIO {
    private static Scanner in;

    /**
     * An image file is read into the program.
     * @param path - The file path for the file.
     * @return - An image that was created.
     * @throws IllegalArgumentException - If the extension is invalid,
     * an IllegalArgumentException is thrown.
     */
    public static Image read(Path path) throws IllegalArgumentException{
        try {
            String pathAsString = path.toString();
            if (pathAsString.substring(pathAsString.length() - 4).equals(".png") ||
                    pathAsString.substring(pathAsString.length() - 4).equals(".jpg")){
                return ImageUtil.readImage(path);
            } else if(pathAsString.substring(pathAsString.length() - 5).equals(".msoe")){
                return readMSOE(path);
            } else if (pathAsString.substring(pathAsString.length() - 6).equals(".bmsoe")){
                readBSMOE(path);
            } else{
                throw new IllegalArgumentException("The file chosen is not of the correct type");
            }
        } catch (IOException e){
            System.out.println("Something went wrong with IO.");
        }
        return null;
    }

    /**
     * An image file is written to the file specified in the path
     * @param image - The image to be written.
     * @param path - Location of the file
     * @throws IllegalArgumentException - If the extension is invalid,
     * an IllegalArgumentException is thrown.
     */
    public static void write(Image image, Path path) throws IllegalArgumentException{
        try {
            if (image != null){
                String pathAsString = path.toString();
                if (pathAsString.substring(pathAsString.length() - 4).equals(".png")
                        || pathAsString.substring(pathAsString.length() - 4).equals(".jpg")){
                    ImageUtil.writeImage(path, image);
                } else if (pathAsString.substring(pathAsString.length() - 5).equals(".msoe")){
                    writeMSOE(image, path);
                } else if (pathAsString.substring(pathAsString.length() - 6).equals(".bmsoe")){
                    writeBSMOE(image, path);
                } else {
                    throw new IllegalArgumentException("The file chosen is not of the correct type");
                }
            } else {
                System.out.println("You tried to write a null image");
            }


        } catch (IOException e){
            System.out.println("Something went wrong with IO.");
        }
    }

    /**
     * Sets the an image to be displayed in grayscale.
     * @param image - The original image.
     * @return - An image similar to the original, but in grayscale.
     */
    public static Image grayscale(Image image){
        if (image != null){
            Transformable transformGrey = ((y, color) -> color.grayscale());
            return transformImage(image, transformGrey);
        } else {
            System.out.println("Cannot convert a null image to grayscale.");
        }
        return null;
    }

    /**
     * Sets the displayed image to its inverse
     * @param image - The original image.
     * @return - The modified image.
     */
    public static Image negative(Image image){
        if (image != null){
            Transformable transformNegative = ((y, color) ->  new Color( 1 - color.getRed(),
                    1 - color.getGreen(), 1 - color.getBlue(), 1));
            return transformImage(image, transformNegative);
        } else {
            System.out.println("Cannot create a negative version of a null image.");
        }
        return null;
    }

    /**
     * Sets the image to contain only the color red.
     * @param image - The image to be changed.
     * @return - The image with red only.
     */
    public static Image red(Image image){
        if (image != null){
            Transformable transformRed = ((y, color) -> new Color(color.getRed(), 0, 0, 1));
            return transformImage(image, transformRed);
        } else {
            System.out.println("Cannot create a red version of a null image.");
        }
        return null;
    }

    /**
     * Alternates between red and grayscale for every row of an image.
     * @param image - The image to be changed.
     * @return - The transformed image.
     */
    public static Image redGray(Image image){
        if (image != null){
            Transformable transformRedGray = ((y, color) -> y % 2 == 0 ? color.grayscale() :
                    new Color(color.getRed(), 0, 0, 1));
            return transformImage(image, transformRedGray);
        } else {
            System.out.println("Cannot create a red-gray version of a null image.");
        }
        return null;
    }

    /**
     * Attempts to decode an image from a file path with a .msoe extension
     * @param path - The location of the file.
     * @return - An image that was created
     * @throws InputMismatchException - If the .msoe file does not start with "MSOE"
     */
    private static Image readMSOE(Path path) throws InputMismatchException{
        try {
            WritableImage writableImage;
            in = new Scanner(path);
            String msoe = in.nextLine();
            if (msoe.equalsIgnoreCase("MSOE")){
                int width = Integer.parseInt(in.next());
                int height = Integer.parseInt(in.next());
                writableImage = new WritableImage(width, height);
                for (int i = 0; i < height; i++){
                    for (int j = 0; j < width; j++){
                        writableImage.getPixelWriter().setColor(j, i, Color.valueOf(in.next()));
                    }
                }
                return writableImage;
            } else {
                throw new InputMismatchException("The file is not formatted correctly");
            }

        } catch (IOException e){
            System.out.println("Something went wrong with IO.");
        }
        return null;

    }

    /**
     * Attempts to write an image file with a .msoe extension
     * @param image - an image object.
     * @param path - The file path of the image being written.
     */
    private static void writeMSOE(Image image, Path path){
        try {
//            DataOutputStream fileWriter = new DataOutputStream(new FileOutputStream(path.toFile()));
//            fileWriter.writeChars("MSOE");
//            fileWriter.write('\n');
//            fileWriter.writeDouble(image.getWidth());
//            fileWriter.write(' ');
//            fileWriter.writeDouble(image.getHeight());
//            fileWriter.write('\n');
//            for (int i = 0; i < image.getHeight(); i++){
//                for (int j = 0; j < image.getWidth(); j++){
//                    fileWriter.writeChars("#" + image.getPixelReader().getArgb(j, i));
//                }
//                fileWriter.write('\n');
//            }
            PrintWriter fileWriter = new PrintWriter(path.toFile());
            fileWriter.println("MSOE");
            fileWriter.println((int)image.getWidth() + " " + (int)image.getHeight());
            for (int i = 0; i < image.getHeight(); i++){
                for (int j = 0; j < image.getWidth(); j++){
                    fileWriter.print("#" + Integer.toHexString(image.getPixelReader().getArgb(j, i)) + " ");
                }
                fileWriter.println();
            }
            fileWriter.flush();
        } catch (FileNotFoundException e){
            System.out.println("It appears that no file was found.");
        } catch (IOException e){
            System.out.println("Something went wrong with IO.");
        }

    }

    /**
     * Attempts to read a .bmsoe file.
     * @param path - The file being read.
     * @throws InputMismatchException - If the file is not formatted properly.
     */
    private static void readBSMOE(Path path) throws InputMismatchException{
        try {
            WritableImage writableImage;
            in = new Scanner(path);
            String bmsoe = in.nextLine();
            if (bmsoe.equalsIgnoreCase("BMSOE")){
                int width = Integer.parseInt(in.next());
                int height = Integer.parseInt(in.next());
                in.nextLine();
                writableImage = new WritableImage(width, height);
                for (int i = 0; i < height; i++){
                    for (int j = 0; j < width; j++){
                        writableImage.getPixelWriter().setColor(j, i, intToColor(in.nextInt()));
                    }
                }
            } else {
                throw new InputMismatchException("The file was not formatted correctly.");
            }

        } catch (FileNotFoundException e){
            System.out.println("It appears that no file was found.");
        } catch (IOException e){
            System.out.println("Something went wrong with IO.");
        }
    }

    /**
     * Attempts to write a .bmsoe file.
     * @param image - The current image being displayed.
     * @param path - The path of the file to be saved.
     */
    private static void writeBSMOE(Image image, Path path) {
        try {
            DataOutputStream fileWriter = new DataOutputStream(new FileOutputStream(path.toFile()));
            fileWriter.writeChars("MSOE");
            fileWriter.write('\n');
            fileWriter.writeDouble(image.getWidth());
            fileWriter.write(' ');
            fileWriter.writeDouble(image.getHeight());
            fileWriter.write('\n');
            for (int i = 0; i < image.getHeight(); i++){
                for (int j = 0; j < image.getWidth(); j++){
                    fileWriter.write(colorToInt(image.getPixelReader().getColor(j, i)));
                }
                fileWriter.write('\n');
            }
        } catch (FileNotFoundException e){
            System.out.println("It appears that no file was found.");
        } catch (IOException e){
            System.out.println("Something went wrong with IO.");
        }
    }

    /**
     * Converts an integer value to a Color object.
     * @param color - The integer value to be converted.
     * @return - The color in the form of a Color object.
     */
    private static Color intToColor(int color){
        double red = ((color >> 16) & 0x000000FF)/255.0;
        double green = ((color >> 8) & 0x000000FF)/255.0;
        double blue = (color & 0x000000FF)/255.0;
        double alpha = ((color >> 24) & 0x000000FF)/255.0;
        return new Color(red, green, blue, alpha);
    }

    /**
     * Converts a Color object to an integer value.
     * @param color - The color object to be converted.
     * @return - The color in the form of an integer value.
     */
    private static int colorToInt(Color color){
        int red = ((int)(color.getRed()*255)) & 0x000000FF;
        int green = ((int)(color.getGreen()*255)) & 0x000000FF;
        int blue = ((int)(color.getBlue()*255)) & 0x000000FF;
        int alpha = ((int)(color.getOpacity()*255)) & 0x000000FF;
        return (alpha << 24) + (red << 16) + (green << 8) + blue;
    }

    /**
     * Transforms an image using the color of an image at the current location.
     * @param image - The image to be transformed.
     * @param transform - The operation to be done with the object's color at the current location.
     * @return - The transformed image.
     */
    private static Image transformImage(Image image, Transformable transform){
        if (image != null){
            WritableImage writableImage = new WritableImage((int)image.getWidth(),
                    (int)image.getHeight());
            for (int i = 0; i < image.getHeight(); i++){
                for (int j = 0; j < image.getWidth(); j++){
                    writableImage.getPixelWriter().setColor(j, i,
                            transform.apply(i, image.getPixelReader().getColor(j, i)));
                }
            }
            return writableImage;
        } else {
            System.out.println("Cannot transform a null image.");
        }
        return null;
    }




}
