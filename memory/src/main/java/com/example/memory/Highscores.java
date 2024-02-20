package com.example.memory;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Highscores extends Application {
    public void start(Stage mijnHighscoresStage) throws IOException {
        // Nodes aanmaken
        Text txtTitel = new Text("Highscores");
        Text score1 = new Text("1. Speler A - 100 punten");
        Text score2 = new Text("2. Speler B - 90 punten");
        Text score3 = new Text("3. Speler C - 80 punten");
        Text score4 = new Text("4. Speler D - 70 punten");
        Text score5 = new Text("5. Speler E - 60 punten");

        Button terugButton = new Button("Terug naar Home");
        terugButton.setFont(Font.font("Arial", 14));
        terugButton.setStyle("-fx-background-color: #E76F51; -fx-text-fill: white;");

        VBox buttonVBox = new VBox();
        buttonVBox.getChildren().addAll(txtTitel, score1, score2, score3, score4, score5, terugButton);

        buttonVBox.setAlignment(Pos.CENTER);
        buttonVBox.setSpacing(12);

        // FullScreen
        mijnHighscoresStage.setFullScreenExitHint("Druk op ESC om te sluiten");
        mijnHighscoresStage.setFullScreen(true);

        // Scene toevoegen en Pane daaraan toevoegen
        //Je hebt normaal gezien maar 1 scene
        Scene sceneButtons = new Scene(buttonVBox);
        // Scene toevoegen aan stage
        mijnHighscoresStage.setScene(sceneButtons);
        mijnHighscoresStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}