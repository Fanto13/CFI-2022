package com.ifts.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    CredentialsStorage storage;

    @FXML
    private PasswordField tfPassword;

    @FXML
    private TextField tfUsername;

    public void initialize() {
        storage = new CredentialsStorage();
        storage.connect();
    }

    @FXML
    void onLogin(ActionEvent event) throws IOException {
        if (!storage.checkCredential(tfUsername.getText(), tfPassword.getText())) {
            new Alert(Alert.AlertType.ERROR, "Invalid Credentials!").showAndWait();
        } else {
            new Alert(Alert.AlertType.INFORMATION, "Login successful!").showAndWait();
            /*
            Eventually change scene
            Parent root = FXMLLoader.load(getClass().getResource("money-view.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = (Stage)tfPassword.getScene().getWindow();
            primaryStage.setTitle("Money Manager");
            primaryStage.setScene(scene);
             */
        }

    }

}
