package application;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SampleController {

    @FXML
    Label massage;

    @FXML
    public void counter() {

        String hours = this.hours.getText();
        String minutes = this.minutes.getText();

        Pattern pat = Pattern.compile("[0-9]+");
        Matcher hrs = pat.matcher(hours);
        Matcher min = pat.matcher(minutes);
        int h = 0;
        int m = 0;

        while (hrs.find()) {
            h = h + Integer.parseInt(hrs.group());
        }

        while (min.find()) {
            m = m + Integer.parseInt(min.group());
            if (m >= 60) {
                h = h + 1;
                m = m - 60;
            }
        }
        massage.setText(h + " год. " + m + " хв.");
    }

    @FXML
    Button button1;

    @FXML
    Button button2;

    @FXML
    public void closingProgram(ActionEvent event) {
        Stage stage = (Stage) button2.getScene().getWindow();
        stage.close();
    }

    @FXML
    TextField hours;

    @FXML
    TextField minutes;

}
