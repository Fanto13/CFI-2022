package com.ifts.school.dialogs;

import com.ifts.school.domain.SchoolClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Window;
import javafx.util.Pair;

import java.io.IOException;

public class ClassDialog extends Dialog<SchoolClass> {
    @FXML private TextField tfPassword;
    @FXML private TextField tfUsername;

    public ClassDialog() throws IOException {
        super();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("newclass-view.fxml"));
        loader.setController(this);
        DialogPane pane = loader.load();
        setDialogPane(pane);
        setTitle("New Class");
        //setHeaderText("Look, a Custom Login Dialog");
        setResizable(false);
        initModality(Modality.APPLICATION_MODAL);
        setResultConverter(buttonType -> {
            if (buttonType == ButtonType.APPLY) {
                //return new SchoolClass();
            }
            return null;
        });
    }
}
