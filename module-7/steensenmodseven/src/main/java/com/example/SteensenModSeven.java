// Alisa Steensen
// Module 7.2

// This GUI program displays 4 circles in a row, with the first circle inside a black rectangle. I stacked the circle on top of the rectangle using the stackpane.

package com.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class SteensenModSeven extends Application {

    @Override
    public void start(Stage primaryStage) { // Setting up the stage
        BorderPane root = new BorderPane();

        Scene scene = new Scene(root, 600, 300);
        scene.getStylesheets().add(getClass().getResource("SteensenModSeven.css").toExternalForm());

        // Rectangle to go around the 1st circle
        javafx.scene.shape.Rectangle rectangle = new javafx.scene.shape.Rectangle(100, 200);
        rectangle.getStyleClass().add("rectangle");
        
        // Circles
        Circle circle1 = new Circle(40); 
        Circle circle2 = new Circle(40); 
        Circle circle3 = new Circle(40); 
        Circle circle4 = new Circle(40); 

        circle1.getStyleClass().add("plaincircle");
        circle2.getStyleClass().add("plaincircle");
        circle3.getStyleClass().add("redcircle");
        circle4.getStyleClass().add("greencircle");

        // StackPane to hold the rectangle and the first circle so the circle is on top of the rectangle
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(rectangle, circle1);

        // HBox for horizontal layout
        HBox hBox = new HBox(40);
        hBox.getChildren().addAll(stackPane, circle2, circle3, circle4);
        hBox.setAlignment(Pos.CENTER); // center alignment for all the elements

        root.setCenter(hBox);

        primaryStage.setTitle("Steensen Mod Seven");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
