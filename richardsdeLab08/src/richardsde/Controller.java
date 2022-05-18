package richardsde;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.nio.file.Path;


public class Controller {

    FileChooser fileChooser = new FileChooser();
    Path imagePath;

    @FXML
    ImageView displayedImage;

    /**
     * Loads a .png, .jpeg, or .msoe image into the ImageView object.
     */
    @FXML
    public void load() {

        try {
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.msoe"));
            fileChooser.setInitialDirectory(new File("./images"));
            File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile != null){
                imagePath = selectedFile.toPath();
                displayedImage.setImage(ImageIO.read(imagePath));
            } else {
                System.out.println("Please select a file");
            }
        } catch (IllegalArgumentException e){
            System.out.println("That is not a valid file type. " +
                    "Please select a file ending in .png, .jpg, or .msoe.");
        }




    }

    /**
     * Reloads the non-modified image.
     */
    @FXML
    public void reload(){
        if (imagePath != null){
            displayedImage.setImage(ImageIO.read(imagePath));
        }
    }

    /**
     * Asks the user to save the image as a .jpg, .png, or .msoe file.
     */
    @FXML
    public void save(){
        try {
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.msoe"));
            fileChooser.setInitialDirectory(new File("C:/Users/richardsde/IdeaProjects/CS1021/richardsdeLab08/images"));
            File selectedFile = fileChooser.showSaveDialog(null);
            if (selectedFile != null){
                Path selectedPath = selectedFile.toPath();
                ImageIO.write(displayedImage.getImage(), selectedPath);
            } else {
                System.out.println("To save a file, press the save button.");
            }
        } catch (IllegalArgumentException e){
            System.out.println("That is not a valid file type. " +
                    "Please select a file ending in .png, .jpg, or .msoe.");
        }



    }

    /**
     * Attempts to set the image to grayscale
     */
    @FXML
    public void grayscale(){
        if (imagePath != null){
            displayedImage.setImage(ImageIO.grayscale(displayedImage.getImage()));
        }
    }

    /**
     * Creates the inverse of the image.
     */
    @FXML
    public void negative(){
        if (imagePath != null){
            displayedImage.setImage(ImageIO.negative(displayedImage.getImage()));
        }
    }
}
