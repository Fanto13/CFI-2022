package com.ifts.planes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class PlaneController {

    @FXML
    private Button btNext;

    @FXML
    private Button btPrevious;

    @FXML
    private TextField tfFirstFlight;

    @FXML
    private TextField tfLength;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfWingSpan;

    List<Plane> planes;
    int selectedIndex;

    @FXML
    void onMenuOpenClick(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            try {
                List<String> lines = Files.readAllLines(selectedFile.toPath());
                planes = new ArrayList<>();
                for (String line : lines) {
                    String[] fields = line.split(";");
                    planes.add(new Plane(fields[0], Double.parseDouble(fields[1]), Double.parseDouble(fields[2]), fields[3]));
                }
                selectedIndex = 0;
                update();
            } catch (IOException e) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Read error");
                a.showAndWait();
            }
        }

    }

    @FXML
    void onNextButtonClick(ActionEvent event) {
        selectedIndex = Math.min(selectedIndex + 1, planes.size() - 1);
        update();
    }

    @FXML
    void onPreviousButtonClick(ActionEvent event) {
        selectedIndex = Math.max(selectedIndex - 1, 0);
        update();
    }

    @FXML
    void initialize() {

    }

    void update() {
        Plane p = planes.get(selectedIndex);
        if (p != null) {
            tfName.setText(p.getName());
            tfLength.setText(Double.toString(p.getLength()));
            tfWingSpan.setText(Double.toString(p.getWingspan()));
            tfFirstFlight.setText(p.getFirstFlight());
        } else {
            tfName.setText("");
            tfLength.setText("");
            tfWingSpan.setText("");
            tfFirstFlight.setText("");
        }
    }

}
