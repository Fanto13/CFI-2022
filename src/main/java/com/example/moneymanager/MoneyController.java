package com.example.moneymanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDate;

public class MoneyController {
    @FXML
    private DatePicker dpDate;

    @FXML
    private TextField tfAmount;

    @FXML
    private TextField tfDescription;

    @FXML
    TableView<Expense> tbExpenses;
    ObservableList<Expense> expenses;

    public void initialize() {
        expenses = FXCollections.observableArrayList();
        expenses.add(new Expense(LocalDate.MAX, "bella zio", 100));
        TableColumn<Expense, LocalDate> date = new TableColumn<>("Date");
        TableColumn<Expense, String> description = new TableColumn<>("Description");
        TableColumn<Expense, Double> amount = new TableColumn<>("Amount (EUR)");

        date.setPrefWidth(150);
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        date.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter()));

        description.setPrefWidth(150);
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        description.setCellFactory(TextFieldTableCell.forTableColumn());

        amount.setPrefWidth(150);
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        amount.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        tbExpenses.getColumns().add(date);
        tbExpenses.getColumns().add(description);
        tbExpenses.getColumns().add(amount);

        tbExpenses.setEditable(true);
        tbExpenses.setTableMenuButtonVisible(true);
        tbExpenses.setItems(expenses);
    }

    @FXML
    void onAdd(ActionEvent event) {
        Expense expense = new Expense(dpDate.getValue(), tfDescription.getText(),
                Double.parseDouble(tfAmount.getText()));
        expenses.add(expense);
    }

    @FXML
    void onRemove(ActionEvent event) {
        expenses.remove(tbExpenses.getSelectionModel().getSelectedItem());
    }

}
