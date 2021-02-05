package ma.youcode.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import ma.youcode.App;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
