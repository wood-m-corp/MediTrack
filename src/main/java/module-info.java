module com.example.meditrack {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.meditrack to javafx.fxml;
    exports com.example.meditrack;
}
