package com.example.smith_guiassignment;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class DiceRoller extends Application {

    private ImageView die1ImageView;
    private ImageView die2ImageView;

    @Override
    public void start(Stage primaryStage) {
        // Create the dice images
        Image[] diceImages = new Image[6];
        for (int i = 0; i < 6; i++) {
            diceImages[i] = new Image("C:\\Users\\trent\\IdeaProjects\\Smith_GUIAssignment\\src\\main\\java\\com\\example\\smith_guiassignment\\Die" + (i+1) + ".png");
        }

        // Create the dice image views
        die1ImageView = new ImageView(diceImages[0]);
        die2ImageView = new ImageView(diceImages[0]);

        // Create the roll button
        Button rollButton = new Button("Roll");
        rollButton.setOnAction(event -> {
            // Generate two random numbers between 1 and 6
            int die1Value = new Random().nextInt(6) + 1;
            int die2Value = new Random().nextInt(6) + 1;

            // Update the dice image views
            die1ImageView.setImage(diceImages[die1Value-1]);
            die2ImageView.setImage(diceImages[die2Value-1]);
        });

        // Create the dice box
        HBox diceBox = new HBox(20, die1ImageView, die2ImageView);
        diceBox.setAlignment(Pos.CENTER);

        // Create the root pane
        VBox root = new VBox(20, diceBox, rollButton);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        // Create the scene and show the stage
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dice Roller");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
