package com.example.tempconverter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private Button btConvert;

    @FXML
    private TextField tfC;

    @FXML
    private TextField tfF;

    @FXML
    void onConvertButtonClick(ActionEvent event) {
        double f = Double.valueOf(tfC.getText()) * 1.8 + 32;
        tfF.setText(Double.toString(f));
    }

}
