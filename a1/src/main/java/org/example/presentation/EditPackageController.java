package org.example.presentation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.example.model.VacationDestination;
import org.example.model.VacationPackage;
import org.example.service.VacationDestinationService;
import org.example.service.VacationPackageService;

import java.io.IOException;
import java.util.List;

public class EditPackageController {
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
    VacationPackageService packageService;
    VacationDestinationService destinationService;
    VacationPackage vacationPackage;
    VacationDestination vacationDestination;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("agencyMenu");
    }

    private void loadDestinationsInChoiceBox(){
        VacationDestinationService destinationService = new VacationDestinationService();
        destinationObservableList = FXCollections.observableArrayList();
        destinationList= destinationService.findAllDestinations();
        for(VacationDestination d: destinationList){
            destinationObservableList.add(d.getName());
        }
        destinationChoiceBox.setItems(destinationObservableList);
    }

    @FXML
    private void findPackage(){
        try{
            packageService = new VacationPackageService();
            destinationService = new VacationDestinationService();
            vacationPackage = packageService.findPackageById(idTextField.getText());
            vacationDestination = destinationService.findDestinationById(vacationPackage.getDestinationId());
            nameTextField.setText(vacationPackage.getName());
            priceTextField.setText(vacationPackage.getPrice().toString());
            availablePlacesTextField.setText(vacationPackage.getAvailablePlaces().toString());
            periodTextField.setText(vacationPackage.getPeriod().toString());
            extraDetailsTextField.setText(vacationPackage.getExtraDetails());
            statusTextField.setText(vacationPackage.getStatus().toString());
            loadDestinationsInChoiceBox();
            destinationChoiceBox.setValue(vacationDestination.getName());
        } catch(IllegalArgumentException e){
            PopUpWindow.displayMessage(e.getMessage());
        }
    }

    @FXML
    private void editPackage(){
        try{
            VacationPackageService packageService = new VacationPackageService();
            packageService.editVacationPackage(vacationPackage.getId(), nameTextField.getText(), priceTextField.getText(),
                    availablePlacesTextField.getText(), periodTextField.getText(), extraDetailsTextField.getText(),
                    statusTextField.getText(), vacationDestination.getId());
            PopUpWindow.displayMessage("Package with id " + vacationPackage.getId() + " successfully updated");
        } catch(IllegalArgumentException | IllegalAccessException e){
            PopUpWindow.displayMessage(e.getMessage());
        }
    }

}
