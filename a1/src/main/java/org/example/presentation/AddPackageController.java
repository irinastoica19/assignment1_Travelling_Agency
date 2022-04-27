package org.example.presentation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.example.model.VacationDestination;
import org.example.service.VacationDestinationService;
import org.example.service.VacationPackageService;

import java.io.IOException;
import java.util.List;

public class AddPackageController {
    @FXML
    TextField idTextField;
    @FXML
    TextField nameTextField;
    @FXML
    TextField priceTextField;
    @FXML
    TextField availablePlacesTextField;
    @FXML
    TextField periodTextField;
    @FXML
    TextField extraDetailsTextField;
    @FXML
    TextField statusTextField;
    @FXML
    ChoiceBox<String> destinationChoiceBox;
    ObservableList<String> destinationObservableList;
    List<VacationDestination> destinationList;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("agencyMenu");
    }
    @FXML
    private void addPackage(){
        VacationPackageService packageService = new VacationPackageService();
        Integer chosenDestination = null;
        for(VacationDestination d: destinationList){
            if(d.getName().equals(destinationChoiceBox.getValue())){
                chosenDestination = d.getId();
            }
        }
        if(chosenDestination == null){
            PopUpWindow.displayMessage("Please choose a destination");
        }
        try {
            packageService.addVacationPackage(idTextField.getText(), nameTextField.getText(), priceTextField.getText(),
                    availablePlacesTextField.getText(), periodTextField.getText(), extraDetailsTextField.getText(),
                    statusTextField.getText(), chosenDestination);
            PopUpWindow.displayMessage("Package successfully added");
        } catch(IllegalArgumentException e){
            PopUpWindow.displayMessage(e.getMessage());
        }
    }
    @FXML
    private void initialize(){
        VacationDestinationService destinationService = new VacationDestinationService();
        destinationObservableList = FXCollections.observableArrayList();
        destinationList= destinationService.findAllDestinations();
        for(VacationDestination d: destinationList){
            destinationObservableList.add(d.getName());
        }
        destinationChoiceBox.setItems(destinationObservableList);
    }
}
