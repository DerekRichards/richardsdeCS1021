/*
 * Course: CS 1021-081
 * Winter 2020/2021
 * Lab 6 - Game of Life
 * Name: Derek Richards
 * Created: 1/22/2021
 */
package sample;

import edu.msoe.se1021.Lab6.WebsiteTester;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Optional;

public class Controller {

    WebsiteTester tester = new WebsiteTester();

    @FXML
    private TextField url;
    @FXML
    private TextField size;
    @FXML
    private TextField time;
    @FXML
    private TextField port;
    @FXML
    private TextField host;
    @FXML
    private TextField timeout;
    @FXML
    private TextArea webpage;

    /**
     * Gets the information for the Website. If there are certain errors, alerts are shown.
     */
    @FXML
    private void analyze(){
        Alert urlError = new Alert(Alert.AlertType.ERROR, "The URL entered into " +
                "the text box is invalid");
        Alert hostError = new Alert(Alert.AlertType.ERROR, "That host does not exist");
        Alert socketTimeout = new Alert(Alert.AlertType.CONFIRMATION, "There has been a " +
                "timeout reaching the site. Click OK to extend the timeout period.");
        Alert fileNotFound = new Alert(Alert.AlertType.ERROR, "Error: File not found on " +
                "the server, " + url.getText());

        try{
            tester.openURL(url.getText());
            tester.openConnection();
            tester.downloadText();
            size.setText(String.valueOf(tester.getSize()));
            time.setText(tester.getDownloadTime() + " ms");
            host.setText(tester.getHostname());
            port.setText(String.valueOf(tester.getPort()));
            webpage.setText(tester.getContent());
        } catch (MalformedURLException e){ //If the user doesn't enter a valid URL.
            urlError.setHeaderText("URL Error");
            urlError.setTitle("Error Dialog");
            urlError.show();
        } catch (UnknownHostException e){ //If a host cannot be found.
            hostError.setHeaderText("Host Error");
            hostError.setTitle("Error Dialog");
            hostError.show();
        } catch (SocketTimeoutException e){ //If the connection has timed out.
            socketTimeout.setHeaderText("Wait longer?");
            socketTimeout.setTitle("Timeout Dialog");
            Optional<ButtonType> result = socketTimeout.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                TextInputDialog userTimeout = new TextInputDialog();
                userTimeout.setHeaderText("Set Extended Timeout");
                userTimeout.setTitle("Set timeout");
                userTimeout.setContentText("Desired timeout");
                userTimeout.showAndWait();
                tester.setTimeout(userTimeout.getEditor().getText());
            }


        } catch (IOException e){ //If there's a problem reading the given file
            fileNotFound.setHeaderText("File Error");
            fileNotFound.setTitle("Error Dialog");
            fileNotFound.show();
        }


    }

    /**
     * Sets the timeout for the Website Tester object
     */
    @FXML
    private void setTimeout(){
        Alert timeoutError = new Alert(Alert.AlertType.ERROR,
                "Timeout must be greater than or equal to zero.");
        try {
            tester.setTimeout(timeout.getText());
        }catch (NumberFormatException e){ //If an invalid timeout is selected.
            timeoutError.setHeaderText("Invalid Timeout Error");
            timeoutError.show();
        }
    }

}
