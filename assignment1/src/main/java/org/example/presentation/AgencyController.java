package org.example.presentation;

import java.io.IOException;
import javafx.fxml.FXML;

public class AgencyController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("view");
    }
}