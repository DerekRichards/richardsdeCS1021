package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;


public class Controller {
    @FXML
    private TextField numItems;
    @FXML
    private TextField cost;
    @FXML
    private Label total;

    @FXML
    public void ok(){
        int items = Integer.parseInt(numItems.getText());
        double costPerItem = Double.parseDouble(cost.getText());
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        total.setText("Cart Total: $" + decimalFormat.format (items * costPerItem));
    }

    @FXML
    public void clear(){
        numItems.clear();
        cost.clear();
        total.setText("Cart Total: $0.00");
    }
}
