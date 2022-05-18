/* Derek Richards
 * Winter 2020-2021
 *
 */
package richardsde.in_class_1_5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Scene;

public class SimpleGUI extends Application {

    private Label label;
    private Button clickMe;
    private TextField text;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        label = new Label("What is your favorite color?");
        clickMe = new Button("Click Me");
        Button reset = new Button("Reset");
        clickMe.setOnAction(this::handleClickMe);
        reset.setOnAction(this::handleReset);
        text = new TextField();

        HBox upperBox = new HBox();
        HBox lowerBox = new HBox();
        HBox lowestBox = new HBox();
        lowestBox.getChildren().addAll(clickMe, reset);
        upperBox.getChildren().addAll(label);
        lowerBox.getChildren().addAll(text);

        root.add(upperBox, 0, 0);
        root.add(lowerBox, 0, 1);
        root.add(lowestBox, 0, 2);
        //root.add(label, 0, 1, 2, 1);

        primaryStage.setTitle("Simple GUI");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }

    private void handleReset(ActionEvent actionEvent){
        text.clear();
        label.setText("What is your favorite color?");
        //label.setText("Here is some text that can be manipulated with the button above.");
    }

    private void handleClickMe(ActionEvent event) {
        String input = text.getCharacters().toString();
        label.setText("Your favorite color is " + input);
        
        //label.setText("Alive cells: 0");
    }
}
