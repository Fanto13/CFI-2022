package com.ifts.school.controllers;

import com.ifts.school.dialogs.AddClassDialog;
import com.ifts.school.model.SchoolClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.IOException;
import java.sql.*;
import java.util.Optional;

public class ClassesController extends DataSourceController {
    @FXML private TableView<SchoolClass> tbClasses;
    @FXML private TableColumn<SchoolClass, String> tcName;
    @FXML private TableColumn<SchoolClass, String> tcRoom;
    @FXML private TableColumn<SchoolClass, String> tcTeacher;
    ObservableList<SchoolClass> classes;

    @FXML
    void onInsert() throws IOException {
        AddClassDialog newClassDialog = new AddClassDialog();
        Optional<SchoolClass> result = newClassDialog.showAndWait();
        result.ifPresent(schoolClass -> {
            classes.add(schoolClass);
        });
    }

    @FXML
    void onRemove() {

    }

    public void initialize() {
        setupTable();
    }

    void setupTable() {
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcName.setCellFactory(TextFieldTableCell.forTableColumn());
        /*
        tcDate.setOnEditCommit(e -> {
            try (Connection connection = dataSource.getConnection(); PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE expenses SET date=? WHERE idExpense=?")) {
                preparedStatement.setDate(1, Date.valueOf(e.getNewValue()));
                preparedStatement.setInt(2, e.getRowValue().getIdExpense());
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Database Error").showAndWait();
            }
        });
         */

        tcRoom.setCellValueFactory(new PropertyValueFactory<>("room"));
        tcRoom.setCellFactory(TextFieldTableCell.forTableColumn());
        /*
        tcDescription.setOnEditCommit(e -> {
            try (Connection connection = dataSource.getConnection(); PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE expenses SET description=? WHERE idExpense=?")) {
                preparedStatement.setString(1, e.getNewValue());
                preparedStatement.setInt(2, e.getRowValue().getIdExpense());
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                new Alert(Alert.AlertType.ERROR, "Database Error").showAndWait();
            }
        });
         */

        tcTeacher.setCellValueFactory(new PropertyValueFactory<>("teacher"));
        tcTeacher.setCellFactory(TextFieldTableCell.forTableColumn());
        /*
        tcTeacher.setOnEditCommit(e -> {
            try (Connection connection = dataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE expenses SET amount=? WHERE idExpense=?")) {
                preparedStatement.setDouble(1, e.getNewValue());
                preparedStatement.setInt(2, e.getRowValue().getIdExpense());
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                new Alert(Alert.AlertType.ERROR, "Database Error").showAndWait();
            }
        });
         */
        classes = FXCollections.observableArrayList();
        tbClasses.setItems(classes);
        tbClasses.setEditable(true);
    }

    public void fetchData() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM classes");
             ResultSet rs = preparedStatement.executeQuery()) {
            classes.clear();
            while (rs.next()) {
                classes.add(new SchoolClass(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("coordinator"),
                        rs.getString("room")));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
        }
    }
}
