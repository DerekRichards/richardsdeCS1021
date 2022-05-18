package richardsde;

import edu.msoe.cs1021.ImageUtil;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SecondaryController {
    @FXML
    private TextField topLeftFilter;
    @FXML
    private TextField topCenterFilter;
    @FXML
    private TextField topRightFilter;
    @FXML
    private TextField centerLeftFilter;
    @FXML
    private TextField centerFilter;
    @FXML
    private TextField centerRightFilter;
    @FXML
    private TextField bottomLeftFilter;
    @FXML
    private TextField bottomCenterFilter;
    @FXML
    private TextField bottomRightFilter;

    private Stage mainStage;
    private PrimaryController primaryController;

    /**
     * Sets the main stage for the program.
     * @param mainStage - The stage to be set.
     */
    public void setMainStage(Stage mainStage){
        this.mainStage = mainStage;
    }

    /**
     * Sets the primary controller for the program.
     * @param primaryController - The controller to be set.
     */
    public void setPrimaryController(PrimaryController primaryController){
        this.primaryController = primaryController;
    }

    /**
     * Sets the filter values to values that will blur the image.
     */
    @FXML
    public void blur(){
        topLeftFilter.setText("0");
        topCenterFilter.setText("1");
        topRightFilter.setText("0");
        centerLeftFilter.setText("1");
        centerFilter.setText("5");
        centerRightFilter.setText("1");
        bottomLeftFilter.setText("0");
        bottomCenterFilter.setText("1");
        bottomRightFilter.setText("0");
    }

    /**
     * Sets the filter values to values that will sharpen the image.
     */
    @FXML
    public void sharpen(){
        topLeftFilter.setText("0");
        topCenterFilter.setText("-1");
        topRightFilter.setText("0");
        centerLeftFilter.setText("-1");
        centerFilter.setText("5");
        centerRightFilter.setText("-1");
        bottomLeftFilter.setText("0");
        bottomCenterFilter.setText("-1");
        bottomRightFilter.setText("0");
    }

    /**
     * Applies the filter using the values set in the Text Fields.
     */
    @FXML
    public void apply(){
        int topLeftValue = Integer.parseInt(topLeftFilter.getText());
        int topCenterValue = Integer.parseInt(topCenterFilter.getText());
        int topRightValue = Integer.parseInt(topRightFilter.getText());
        int centerLeftValue = Integer.parseInt(centerLeftFilter.getText());
        int centerValue = Integer.parseInt(centerFilter.getText());
        int centerRightValue = Integer.parseInt(centerRightFilter.getText());
        int bottomLeftValue = Integer.parseInt(bottomLeftFilter.getText());
        int bottomCenterValue = Integer.parseInt(bottomCenterFilter.getText());
        int bottomRightValue = Integer.parseInt(bottomRightFilter.getText());

        double sumOfValues = topLeftValue + topCenterValue + topRightValue + centerLeftValue +
                centerValue + centerRightValue + bottomLeftValue + bottomCenterValue +
                bottomRightValue;

        if (sumOfValues == 0){
            throw new IllegalArgumentException("The values cannot all be zero.");
        } else if (sumOfValues != 1){
            double[] kernel = {topLeftValue/sumOfValues, topCenterValue/sumOfValues,
                    topRightValue/sumOfValues, centerLeftValue/sumOfValues, centerValue/sumOfValues,
                    centerRightValue/sumOfValues, bottomLeftValue/sumOfValues, bottomCenterValue/sumOfValues,
                    bottomRightValue/sumOfValues};
            primaryController.setDisplayedImage(ImageUtil.convolve(primaryController.getDisplayedImage(), kernel));
        } else {
            double[] kernel = {topLeftValue, topCenterValue, topRightValue, centerLeftValue,
                    centerValue, centerRightValue, bottomLeftValue, bottomCenterValue, bottomRightValue};
            primaryController.setDisplayedImage(ImageUtil.convolve(primaryController.getDisplayedImage(), kernel));
        }
    }
}
