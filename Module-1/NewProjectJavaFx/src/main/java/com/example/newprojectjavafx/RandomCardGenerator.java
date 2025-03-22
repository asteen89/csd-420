// Alisa Steensen
// Module 1

// This code generates 4 images and has a refresh button underneath that will randomly generate 4 different cards onclick



package com.example.newprojectjavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import java.io.File;



import javafx.scene.text.Font;


public class RandomCardGenerator extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        VBox vBox = new VBox(20); // Vbox for the button centered position
        vBox.setAlignment(Pos.CENTER);

        HBox hBox = new HBox(20); // Hbox for the card alignment above the button, centered position
        hBox.setAlignment(Pos.CENTER);

        Button newButton = new Button("Refresh"); // button that will refresh cards when clicked using the event handler
        newButton.setFont(Font.font("Comic Sans MS", 15));

        newButton.setOnAction(e -> viewCards(hBox)); // lambda handler

        viewCards(hBox);
        vBox.getChildren().addAll(hBox, newButton);

        Scene scene = new Scene(vBox, 500, 200); // creates the scene container to hold the vbox root, set up width and height for container
        stage.setTitle("Random Cards");
        stage.setScene(scene);
        stage.show();
    }


    // The purpose of this method is to display 4 random cards at a time from the folder
    private void viewCards(HBox hBox) {

        File cardsLocation = new File("C:/csd-420/csd-420/module-1/NewProjectJavaFx/src/main/resources/cards");
        File[] cards = cardsLocation.listFiles(); // adding card images to an array to store them


        java.util.Collections.shuffle(java.util.Arrays.asList(cards)); // using the collections shuffle to shuffle through the array of card images

        // loop through for 4 random cards
        for (int i = 0; i < 4; i++) { // iterates 4 times through loop
            File randomCard = cards[i]; // this selects a random card in array on index i
            Image image = new Image("file:" + randomCard.getPath());
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(120);
            imageView.setFitWidth(100);
            hBox.getChildren().add(imageView);
        }
    }
}