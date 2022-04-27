package org.example.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.service.VacationDestinationService;

import java.io.IOException;

public class DeleteDestinationController {
    @FXML
    TextField destinationIdTextField;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("agencyMenu");
    }

    @FXML
    private void deleteDestination(){
        try {
            VacationDestinationService destinationService = new VacationDestinationService();
            destinationService.deleteVacationDestination(destinationIdTextField.getText());
            PopUpWindow.displayMessage("Destination deleted");
        } catch(IllegalArgumentException e){
            PopUpWindow.displayMessage(e.getMessage());
        }
    }
}
