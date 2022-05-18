/* Derek Richards
 * Winter Quarter 2020/2021
 * CS1021
 */
package richardsde;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    @Override
    public void start(Stage stage) {
        Label message = new Label("Hello World!");
        Scene scene = new Scene(message);

        stage.setTitle("Title bar");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}