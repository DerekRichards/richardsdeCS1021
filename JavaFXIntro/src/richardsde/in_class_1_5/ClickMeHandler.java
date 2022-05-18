package richardsde.in_class_1_5;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.BoxBlur;


public class ClickMeHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        Button button = (Button)event.getSource();
        if(button.getEffect()==null) {
            button.setEffect(new BoxBlur());
        } else {
            button.setEffect(null);
        }
    }
}
