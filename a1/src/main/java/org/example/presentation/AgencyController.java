package org.example.presentation;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AgencyController {
    public Button secondaryButton;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("view");
    }

    @FXML
    private void switchToAddDestination() throws IOException {
        App.setRoot("addDestination");
    }

    @FXML
    private void switchToDeleteDestination() throws IOException {
        App.setRoot("deleteDestination");
    }

    @FXML
    private void switchToAddPackage() throws IOException {
        App.setRoot("addPackage");
    }

    @FXML
    private void switchToDeletePackage() throws IOException {
        App.setRoot("deletePackage");
    }

    @FXML
    private void switchToViewPackages() throws IOException {
        App.setRoot("viewPackages");
    }

    @FXML
    private void switchToEditPackage() throws IOException {
        App.setRoot("editPackage");
    }
}