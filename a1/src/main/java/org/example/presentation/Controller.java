package org.example.presentation;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    public Button primaryButton;

    @FXML
    private void switchToAgency() throws IOException {
        App.setRoot("agencyMenu");
    }

}
