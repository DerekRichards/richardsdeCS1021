package richardsde;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Path;
import java.util.InputMismatchException;


public class PrimaryController {

    FileChooser fileChooser = new FileChooser();
    Path imagePath;

    @FXML
    ImageView displayedImage;
    @FXML
    private GridPane mainGrid;

    private Stage otherStage;
    private SecondaryController otherController;

    @FXML
    private Button filterButton;

    /**
     * Sets the main window for the program.
     * @param mainGrid - The stage to be set.
     */
    public void setMainGrid(Pane mainGrid) {
        this.mainGrid = (GridPane) mainGrid;
    }

    /**
     * Sets the secondary window for the program.
     * @param otherStage - The stage to be set.
     */
    public void setOtherStage(Stage otherStage) {
        this.otherStage = otherStage;
    }

    /**
     * Sets the secondary controller for the program.
     * @param otherController - The controller to be set.
     */
    public void setOtherController(SecondaryController otherController) {
        this.otherController = otherController;
    }

    /**
     * Loads a .png, .jpeg, or .msoe image into the ImageView object.
     */
    @FXML
    public void load() {

        try {
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg",
                            "*.msoe", "*.bmsoe"));
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
        } catch (InputMismatchException e){
            System.out.println("The file could not be properly read because " +
                    "the file did not appear to be formatted correctly.");
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
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg",
                            "*.msoe", "*.bsmoe"));
            fileChooser.setInitialDirectory(new File("./images"));
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

    /**
     * Creates an image with red as the only color.
     */
    @FXML
    public void red(){
        if (imagePath != null){
            displayedImage.setImage(ImageIO.red(displayedImage.getImage()));
        }
    }

    /**
     * Alternates between all red and grayscale for every other line of the image.
     */
    @FXML
    public void redGray(){
        if (imagePath != null){
            displayedImage.setImage(ImageIO.redGray(displayedImage.getImage()));
        }
    }

    /**
     * Shows and hides the second window.
     */
    @FXML
    public void showFilter(){
        if (filterButton.getText().equals("Show Filter")){
            Stage myStage = (Stage) mainGrid.getScene().getWindow();
            otherStage.setX(myStage.getX() + myStage.getWidth());
            otherStage.setY(myStage.getY());
            otherStage.show();
            filterButton.setText("Hide Filter");
        } else if (filterButton.getText().equals("Hide Filter")){
            otherStage.hide();
            filterButton.setText("Show Filter");
        }

    }

    /**
     * Gets the current image being displayed.
     * @return - The image being displayed.
     */
    public Image getDisplayedImage(){
        return displayedImage.getImage();
    }

    /**
     * Sets the current image being displayed.
     * @param image - What the image will be set to.
     */
    public void setDisplayedImage(Image image){
        displayedImage.setImage(image);
    }
}
