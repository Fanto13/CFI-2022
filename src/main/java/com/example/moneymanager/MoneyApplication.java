package com.example.moneymanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class MoneyApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("money-view.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Money Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
