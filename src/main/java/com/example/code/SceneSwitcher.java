package com.example.code;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitcher {
    public static void switchScene(Stage stage, String fxmlFile, int width, int height, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneSwitcher.class.getResource(fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene(root, width, height);
            stage.setScene(scene);
            if (title != null) {
                stage.setTitle(title);
            }
            stage.show();
        } catch (IOException e) {
            Logger.error("Scene switch error", e);
        }
    }
}
