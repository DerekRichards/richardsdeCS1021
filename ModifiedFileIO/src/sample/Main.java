package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Path;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));


        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("test.txt"))) {
            bos.write(8);
            bos.write(5);
            bos.flush();
        } catch (FileNotFoundException e){
            System.out.println("File not found.");
        } catch (IOException e){
            System.out.println("Something went wrong in the IO for the file");
        }

        FileChooser chooser = new FileChooser();
        read(chooser.showOpenDialog(primaryStage).toPath());
        primaryStage.show();
    }

    private static void read(Path textFilePath){
        try (BufferedInputStream bis =
                     new BufferedInputStream(new FileInputStream(textFilePath.toFile()))) {
            System.out.println(bis.read());
            System.out.println(bis.read());
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e){
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        launch(args);
    }
}
