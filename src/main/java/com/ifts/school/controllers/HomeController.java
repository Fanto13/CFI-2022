package com.ifts.school.controllers;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.TimeZone;

public class HomeController {
    public static final String JDBC_Driver_MySQL = "com.mysql.cj.jdbc.Driver";
    public static final String JDBC_URL_MySQL = "jdbc:mysql://localhost:3306/jdbc_schema?user=nicola&password=qwertyuio&serverTimezone=" + TimeZone.getDefault().getID();
    HikariDataSource dataSource;

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

    public void initialize() throws IOException {
        hikariSetup();
        onClasses();
    }
    private void hikariSetup() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(JDBC_Driver_MySQL);
        config.setJdbcUrl(JDBC_URL_MySQL);
        config.setLeakDetectionThreshold(2000);
        dataSource = new HikariDataSource(config);
    }

    void switchPanel(String view) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(view));
        Parent pane = loader.load();
        DataSourceController controller = loader.getController();
        controller.setDataSource(dataSource);
        controller.fetchData();
        rightPane.getChildren().clear();
        rightPane.getChildren().add(pane);
    }
}
