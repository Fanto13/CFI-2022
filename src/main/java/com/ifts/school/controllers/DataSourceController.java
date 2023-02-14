package com.ifts.school.controllers;

import com.zaxxer.hikari.HikariDataSource;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DataSourceController {
    HikariDataSource dataSource;

    public HikariDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

}
