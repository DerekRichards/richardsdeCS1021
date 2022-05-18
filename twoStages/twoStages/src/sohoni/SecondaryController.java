package sohoni;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SecondaryController {
    @FXML
    private Button talkBack;

    @FXML
    private Label label;

    private Stage mainStage;
    private MainController mainController;

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setLabel(String text){
        label.setText(text);
    }

    public void talkBack(ActionEvent actionEvent) {
        mainController.setMainLabel("Hellow back to you!");
    }
}
