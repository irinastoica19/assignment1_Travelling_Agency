package org.example.presentation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.model.VacationPackage;
import org.example.service.VacationPackageService;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ViewPackagesController {
    @FXML
    TableView<VacationPackage> tableView = new TableView<>();

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("agencyMenu");
    }

    @FXML
    private void initialize(){
        VacationPackageService packageService = new VacationPackageService();
        List<VacationPackage> objects = packageService.findAllPackages();
        ObservableList<VacationPackage> packageObservableList = FXCollections.observableArrayList();
        ArrayList<TableColumn<VacationPackage,Object>> columns = new ArrayList<>();
        for(Field field: objects.get(0).getClass().getDeclaredFields()){
            if(!field.getName().equals("vacationDestination")) {
                TableColumn<VacationPackage, Object> newColumn = new TableColumn<>(field.getName());
                newColumn.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
                columns.add(newColumn);
            }
        }
        tableView.getColumns().addAll(columns);
        packageObservableList.addAll(objects);
        tableView.setItems(packageObservableList);
    }
}
