package richardsde;

import edu.msoe.cs1021.ImageUtil;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.io.*;
import java.nio.file.Path;
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
            WritableImage writableImage =
                    new WritableImage((int)image.getWidth(), (int)image.getHeight());
            final double grayscaleRed = 0.2126;
            final double grayscaleGreen = 0.7152;
            final double grayscaleBlue = 0.0722;
            for (int i = 0; i < image.getHeight(); i++){
                for (int j = 0; j < image.getWidth(); j++){
                    Color imageColor = new Color(image.getPixelReader().getColor(j, i).getRed(),
                            image.getPixelReader().getColor(j, i).getGreen(),
                            image.getPixelReader().getColor(j, i).getBlue(),
                            1);
                    writableImage.getPixelWriter().setColor(j, i, imageColor.grayscale());
                }
            }
            return writableImage;
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
            WritableImage writableImage =
                    new WritableImage((int)image.getWidth(), (int) image.getHeight());
            for (int i = 0; i < image.getHeight(); i++){
                for (int j = 0; j < image.getWidth(); j++){
                    writableImage.getPixelWriter().setColor(j, i,
                            new Color( 1 - (image.getPixelReader().getColor(j, i).getRed()),
                                    1 - (image.getPixelReader().getColor(j, i).getGreen()),
                                    1 - (image.getPixelReader().getColor(j, i).getBlue()), 1));
                }
            }
            return writableImage;
        } else {
            System.out.println("Cannot create a negative version of a null image");
        }
        return null;
    }

    /**
     * Attempts to decode an image from a file path with a .msoe extension
     * @param path - The location of the file.
     * @return - An image that was created
     */
    private static Image readMSOE(Path path){
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
            DataOutputStream fileWriter = new DataOutputStream(new FileOutputStream(path.toFile()));
            fileWriter.writeChars("MSOE");
            fileWriter.write('\n');
            fileWriter.writeDouble(image.getWidth());
            fileWriter.write(' ');
            fileWriter.writeDouble(image.getHeight());
            fileWriter.write('\n');
            for (int i = 0; i < image.getHeight(); i++){
                for (int j = 0; j < image.getWidth(); j++){
                    fileWriter.writeChars("#" + image.getPixelReader().getArgb(j, i));
                }
                fileWriter.write('\n');
            }
        } catch (FileNotFoundException e){
            System.out.println("It appears that no file was found.");
        } catch (IOException e){
            System.out.println("Something went wrong with IO.");
        }

    }



}
