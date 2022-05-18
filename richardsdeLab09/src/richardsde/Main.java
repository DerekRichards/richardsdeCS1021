package richardsde;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader mainLoader = new FXMLLoader();
        Parent root = mainLoader.load(getClass().getResource("mainStage.fxml").openStream());
        primaryStage.setTitle("Image Manipulator");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        PrimaryController mainController = mainLoader.getController();
        mainController.setMainGrid((Pane)root);
        FXMLLoader secondaryLoader = new FXMLLoader();
        Stage secondaryStage = new Stage();
        Parent secondaryRoot = secondaryLoader.load(getClass().getResource("secondaryStage.fxml").openStream());
        SecondaryController secondaryController = secondaryLoader.getController();

        secondaryStage.setScene(new Scene(secondaryRoot));
        secondaryStage.setTitle("Filter Kernel");
        secondaryStage.hide();

        mainController.setOtherStage(secondaryStage);
        mainController.setOtherController(secondaryController);

        secondaryController.setMainStage(primaryStage);
        secondaryController.setPrimaryController(mainController);

        primaryStage.setOnCloseRequest(event -> Platform.exit());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
