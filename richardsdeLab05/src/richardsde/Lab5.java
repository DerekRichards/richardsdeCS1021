/*
 * Course: CS 1021-081
 * Winter 2020/2021
 * Lab 5 - Game of Life
 * Name: Derek Richards
 * Created: 1/13/2021
 */
package richardsde;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * This the driver class for the Game of Life Application for Lab 5.
 */
public class Lab5 extends Application {
    private Label aliveCells;
    private Label deadCells;
    private Button randomize;
    private Button iterate;
    private LifeGrid grid;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        FlowPane pane = new FlowPane();
        final int width = 400;
        final int height = 350;
        grid = new LifeGrid(pane, width, height);
        aliveCells = new Label("Alive Cells: " + grid.getAliveCells() + " ");
        deadCells = new Label("Dead Cells: " + grid.getDeadCells() + " ");
        randomize = new Button("Randomize Cells");
        iterate = new Button("Iterate Once");
        randomize.setOnAction(this::handleRandomize);
        iterate.setOnAction(this::handleIterate);
        pane.setOnMouseClicked(event -> handleOnMouseClicked());


        pane.getChildren().addAll(aliveCells, deadCells, randomize, iterate);

        primaryStage.setTitle("Lab 5");
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();

    }


    private void handleRandomize(ActionEvent actionEvent){
        grid.randomize();
        aliveCells.setText("Alive Cells: " + grid.getAliveCells() + " ");
        deadCells.setText("Dead Cells: " + grid.getDeadCells() + " ");
    }

    private void handleIterate(ActionEvent actionEvent){
        grid.iterate();
        aliveCells.setText("Alive Cells: " + grid.getAliveCells() + " ");
        deadCells.setText("Dead Cells: " + grid.getDeadCells() + " ");
    }

    private void handleOnMouseClicked(){
        aliveCells.setText("Alive Cells: " + grid.getAliveCells() + " ");
        deadCells.setText("Dead Cells: " + grid.getDeadCells() + " ");
    }
}
