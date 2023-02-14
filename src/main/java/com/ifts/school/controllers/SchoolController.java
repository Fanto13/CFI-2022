package com.ifts.school.controllers;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SchoolController {
    @FXML
    private AnchorPane rightPane;

    @FXML
    void onClasses() throws IOException {
        switchPanel("classes-view.fxml");
    }

    @FXML
    void onDashboard() throws IOException {
        switchPanel("dashboard-view.fxml");
    }

    @FXML
    void onStudents() throws IOException {
        switchPanel("students-view.fxml");
    }

    void switchPanel(String view) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(view));
        Parent pane = loader.load();
        rightPane.getChildren().clear();
        rightPane.getChildren().add(pane);
    }
}
