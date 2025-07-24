package com.example.code;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu {
    public void show(Stage stage) {
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        ComboBox<String> roleBox = new ComboBox<>();
        roleBox.getItems().addAll("doctor", "staff");
        roleBox.setPromptText("Select Role");
        Button createBtn = new Button("Create Account");
        Label statusLabel = new Label();
        User newUser = new User(usernameField.getText(), passwordField.getText(), roleBox.getValue());
        createBtn.setOnAction(e -> {
            boolean success = UserManager.registerUser(
               newUser
            );
            statusLabel.setText(success ? "Account created!" : "Error creating account.");
        });

        VBox root = new VBox(10, usernameField, passwordField, roleBox, createBtn, statusLabel);
        stage.setScene(new Scene(root, 300, 200));
        stage.setTitle("Main Menu");
        stage.show();
    }
}