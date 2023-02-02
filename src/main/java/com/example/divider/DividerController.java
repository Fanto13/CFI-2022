package com.example.divider;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class DividerController {

    @FXML
    private Button btLeft;

    @FXML
    private Button btRight;

    @FXML
    private Button btSave;

    @FXML
    private ListView<String> lvLeft;

    @FXML
    private ListView<String> lvRight;

    @FXML
    void onLeftButtonClick(ActionEvent event) {
        String item = lvRight.getSelectionModel().getSelectedItem();
        int index = lvRight.getSelectionModel().getSelectedIndex();
        lvRight.getItems().remove(index);
        lvLeft.getItems().add(item);
    }

    @FXML
    void onRightButtonClick(ActionEvent event) {
        String item = lvLeft.getSelectionModel().getSelectedItem();
        int index = lvLeft.getSelectionModel().getSelectedIndex();
        lvLeft.getItems().remove(index);
        lvRight.getItems().add(item);
    }

    @FXML
    void onSaveButtonClick(ActionEvent event) {
        System.out.println(event);
    }


    @FXML
    void onMenuOpenClick(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            try {
                List<String> lines = Files.readAllLines(selectedFile.toPath());
                lvLeft.getItems().clear();
                lvRight.getItems().clear();
                lvLeft.getItems().addAll(lines);
            } catch (IOException e) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Read error");
                a.showAndWait();
            }
        }
    }

    @FXML
    void initialize() {
        //lvLeft.getItems().addAll(List.of("nicola", "giulia", "maria"));
    }
}
