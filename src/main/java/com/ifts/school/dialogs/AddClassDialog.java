package com.ifts.school.dialogs;

import com.ifts.school.model.SchoolClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.stage.Modality;

import java.io.IOException;

public class AddClassDialog extends Dialog<SchoolClass> {

    @FXML private TextField tfCoordinator;
    @FXML private TextField tfName;
    @FXML private TextField tfRoom;

    public AddClassDialog() throws IOException {
        super();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addClass-view.fxml"));
        loader.setController(this);
        DialogPane pane = loader.load();
        setDialogPane(pane);
        setTitle("Insert a new class");
        //setHeaderText("Look, a Custom Login Dialog");
        setResizable(false);
        initModality(Modality.APPLICATION_MODAL);
        setResultConverter(buttonType -> {
            if (buttonType == ButtonType.OK) {
                return new SchoolClass(
                        0,
                        tfName.getText(),
                        tfRoom.getText(),
                        tfCoordinator.getText());
            }
            return null;
        });
    }
}
