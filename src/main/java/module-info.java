module com.example.tempconverter {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.controlsfx.controls;

    opens com.example.tempconverter to javafx.fxml;
    opens com.example.divider to javafx.fxml;
    opens com.example.planes to javafx.fxml;
    opens com.example.paint to javafx.graphics;
    opens com.example.space to javafx.graphics;

    exports com.example.tempconverter;
    exports com.example.divider;
    exports com.example.planes;
    exports com.example.paint;
    exports com.example.space;
}