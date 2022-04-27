package org.example.presentation;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.*;

public class PopUpWindow {

    public static void displayMessage(String error){
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMinWidth(250);
        stage.setMinHeight(250);

        Label label = new Label();
        label.setText(error);
        label.setFont(new Font("Arial", 16));
        label.setWrapText(true);
        label.setAlignment(Pos.CENTER);

        Button close = new Button("Close");
        close.setOnAction( e -> stage.close());

        VBox vBox = new VBox();
        vBox.getChildren().addAll(label, close);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }

}
