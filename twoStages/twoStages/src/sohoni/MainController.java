package sohoni;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private GridPane mainGrid;
    @FXML
    private Label label;

    private Stage otherStage;
    private SecondaryController otherController;

    public void setMainGrid(Pane mainGrid) {
        this.mainGrid = (GridPane) mainGrid;
    }

    public void setOtherStage(Stage otherStage) {
        this.otherStage = otherStage;
    }

    public void setOtherController(SecondaryController otherController) {
        this.otherController = otherController;
    }


    /*
    This method is the action handler for the open button. This will show the second stage
     */
    public void open(ActionEvent actionEvent) {
        //Let's get the position of our main stage so we can open the other stage in relation to it
        Stage myStage = (Stage) mainGrid.getScene().getWindow();
        otherStage.setX(myStage.getX() + myStage.getWidth()); //position it to the right
        otherStage.setY(myStage.getY());
        otherStage.show();
    }

    public void close(ActionEvent actionEvent) {
        otherStage.hide();
    }

    public void sayHi(ActionEvent actionEvent) {
        otherController.setLabel("Hello there");
    }

    public void setMainLabel(String text){
        label.setText(text);
    }
}
