package com.ifts.moneymanager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

    @FXML
    private DatePicker dpDate;

    @FXML
    private TextField tfAmount;

    @FXML
    private TextField tfDescription;

    @FXML
    TableView<Expense> tbExpenses;
    ObservableList<Expense> expenses;
    private HikariDataSource dataSource;

    public void initialize() {
        expenses = FXCollections.observableArrayList();
        dbConnection();
        loadFromDB();

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

    private void dbConnection() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(JDBC_Driver_MySQL);
        config.setJdbcUrl(JDBC_URL_MySQL);
        config.setLeakDetectionThreshold(2000);
        dataSource = new HikariDataSource(config);
    }

    private void loadFromDB() {
        try (Connection connection = dataSource.getConnection()) {
            expenses.clear();
            try (PreparedStatement getPlanes = connection.prepareStatement("SELECT * FROM expenses")) {
                try (ResultSet rs = getPlanes.executeQuery()) {
                    while (rs.next()) {
                        expenses.add(new Expense(
                                convertSQLDateToLocalDate(rs.getDate("date")),
                                rs.getString("description"),
                                rs.getDouble("amount")));
                    }
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
        }
    }

    public LocalDate convertSQLDateToLocalDate(Date SQLDate) {
        java.util.Date date = new java.util.Date(SQLDate.getTime());
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
