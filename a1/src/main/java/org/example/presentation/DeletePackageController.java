package org.example.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.service.VacationPackageService;

import java.io.IOException;

public class DeletePackageController {
    @FXML
    TextField destinationIdTextField;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("agencyMenu");
    }
    @FXML
    private void deletePackage(){
        try {
            VacationPackageService destinationService = new VacationPackageService();
            destinationService.deleteVacationPackage(destinationIdTextField.getText());
            PopUpWindow.displayMessage("Destination deleted");
        } catch(IllegalArgumentException e){
            PopUpWindow.displayMessage(e.getMessage());
        }
    }
}
