module com.example.code {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.code to javafx.fxml;
    exports com.example.code;
}
