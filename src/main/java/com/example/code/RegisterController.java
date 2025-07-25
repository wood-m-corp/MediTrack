package com.example.code;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class RegisterController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Button registerButton;
    @FXML
    private void handleRegister() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (UserManager.registerUser(new User(username, password, "Admin"))) {
            showAlert("Admin account created! Now logging in...");
            Stage stage = (Stage) registerButton.getScene().getWindow();
            SceneSwitcher.switchScene(stage, "admindashboard.fxml", 640, 400, "MediTrack Login");
        } else {
            showAlert("Username taken or error occurred.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
