package com.ifts.expenses;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.LocalDateStringConverter;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.TimeZone;

public class MoneyController {
    public static final String JDBC_Driver_MySQL = "com.mysql.cj.jdbc.Driver";
    public static final String JDBC_URL_MySQL = "jdbc:mysql://localhost:3306/jdbc_schema?user=nicola&password=qwertyuio&serverTimezone=" + TimeZone.getDefault().getID();

    @FXML private DatePicker dpDate;
    @FXML private TableColumn<Expense, Double> tcAmount;
    @FXML private TableColumn<Expense, LocalDate> tcDate;
    @FXML private TableColumn<Expense, String> tcDescription;
    @FXML private TableView<Expense> tvExpenses;
    @FXML private TextField tfAmount;
    @FXML private TextField tfDescription;
    ObservableList<Expense> expenses;
    HikariDataSource dataSource;

    public void initialize() {
        setupTable();
        hikariSetup();
        fetchExpenses();
    }

    private void hikariSetup() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(JDBC_Driver_MySQL);
        config.setJdbcUrl(JDBC_URL_MySQL);
        config.setLeakDetectionThreshold(2000);
        dataSource = new HikariDataSource(config);
    }

    private void fetchExpenses() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM expenses");
             ResultSet rs = preparedStatement.executeQuery()) {
            expenses.clear();
            while (rs.next()) {
                expenses.add(new Expense(convertSQLDateToLocalDate(
                        rs.getDate("date")),
                        rs.getString("description"),
                        rs.getDouble("amount")));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
        }
    }

    public LocalDate convertSQLDateToLocalDate(Date SQLDate) {
        java.util.Date date = new java.util.Date(SQLDate.getTime());
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    void setupTable() {
        tcDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tcDate.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter()));
        tcDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tcDescription.setCellFactory(TextFieldTableCell.forTableColumn());
        tcAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        tcAmount.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        expenses = FXCollections.observableArrayList();
        tvExpenses.setItems(expenses);
    }

    @FXML
    void onAdd() {
        expenses.add(new Expense(
                dpDate.getValue(),
                tfDescription.getText(),
                Double.parseDouble(tfAmount.getText())));
    }

    @FXML
    void onRemove() {
        expenses.remove(tvExpenses.getSelectionModel().getSelectedItem());
    }
}
