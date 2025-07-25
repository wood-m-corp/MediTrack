package com.example.code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MediTrackApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        String fxmlFile = UserManager.adminExists() ? "login.fxml" : "register.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(MediTrackApp.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setResizable(false);
        //stage.setMaximized(true);
        stage.setTitle("MediTrack Registration");
        stage.setScene(scene);
        stage.show();
    }
}