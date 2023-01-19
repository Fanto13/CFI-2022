module com.example.tempconverter {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;

    opens com.example.tempconverter to javafx.fxml;
    opens com.example.divider to javafx.fxml;
    opens com.example.planes to javafx.fxml;

    exports com.example.tempconverter;
    exports com.example.divider;
    exports com.example.planes;
}