// Alisa Steensen Module 10.2

package com.example.javafxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FanTracker extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // FMXL layout
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/javafxml/javafxml.fxml"));
        Scene scene = new Scene(root);

        // CSS style sheet coming up!
        scene.getStylesheets().add(getClass().getResource("/com/example/javafxml/FanTracker.css").toExternalForm());

        primaryStage.setTitle("FanTracker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
