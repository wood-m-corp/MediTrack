package com.example.code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MediTrackApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MediTrackApp.class.getResource("register.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setResizable(false);
        //stage.setMaximized(true);
        stage.setTitle("MediTrack Registration");
        stage.setScene(scene);
        stage.show();
    }
}