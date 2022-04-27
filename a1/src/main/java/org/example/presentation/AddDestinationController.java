package org.example.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.service.VacationDestinationService;

import java.io.IOException;

public class AddDestinationController {
    @FXML
    TextField destinationNameTextField;
    @FXML
    TextField destinationIdTextField;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("agencyMenu");
    }

    @FXML
    private void addDestination(){
        try {
            VacationDestinationService destinationService = new VacationDestinationService();
            destinationService.addVacationDestination(destinationIdTextField.getText(), destinationNameTextField.getText());
            PopUpWindow.displayMessage("Destination added");
        } catch(NumberFormatException e){
            PopUpWindow.displayMessage("Enter a valid number for the ID");
        } catch(IllegalArgumentException e){
            PopUpWindow.displayMessage(e.getMessage());
        }
    }
}
