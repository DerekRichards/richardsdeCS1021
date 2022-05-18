package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    private Label label;
    private TextField text;
    private Button submit;
    private Button reset;

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane pane = new GridPane();
        label = new Label("When is your Birthday");
        text = new TextField();
        submit = new Button("Submit");
        reset = new Button("Reset");
        submit.setOnAction(this::handleSubmit);
        reset.setOnAction(this::handleReset);

        HBox upperBox = new HBox();
        HBox lowerBox = new HBox();
        upperBox.getChildren().addAll(label, text);
        lowerBox.getChildren().addAll(submit, reset);
        pane.add(upperBox, 0, 0);
        pane.add(lowerBox, 0, 1);

        primaryStage.setTitle("Exam 1");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void handleSubmit(ActionEvent actionEvent){
        label.setText("Your Birthday is " + text.getCharacters());
    }

    private void handleReset(ActionEvent actionEvent){
        label.setText("When is your Birthday?");
        text.clear();
    }
}
