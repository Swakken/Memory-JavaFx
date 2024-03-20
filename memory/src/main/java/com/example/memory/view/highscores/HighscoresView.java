package com.example.memory.view.highscores;

import com.example.memory.view.base.BaseView;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HighscoresView extends BaseView {
    private Text txtTitel;
    private Text[] scores;
    private Button terugButton;

    public HighscoresView() {
        super();
        initialiseNodes();
        layoutNodes();
        this.getStylesheets().add(getClass().getResource("/styleheets/home.css").toExternalForm());
        loadScores(); // Load scores when the view is created
    }

    private void initialiseNodes() {
        txtTitel = new Text("Highscores");
        scores = new Text[5]; // Array to hold scores
        for (int i = 0; i < scores.length; i++) {
            scores[i] = new Text();
        }
        terugButton = new Button("Terug naar Home");
    }

    public Button getTerugButton() {
        return terugButton;
    }

    private void layoutNodes() {
        VBox buttonVBox = new VBox();
        buttonVBox.getChildren().addAll(txtTitel);
        for (Text score : scores) {
            buttonVBox.getChildren().add(score);
        }
        buttonVBox.getChildren().addAll(terugButton);
        buttonVBox.setAlignment(Pos.CENTER);
        buttonVBox.setSpacing(12);

        buttonVBox.setBackground(new Background(new BackgroundImage(
                new Image("background.jpg"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, false, true)
        )));

        txtTitel.setId("txtTitel");
        setCenter(buttonVBox);
    }

    // Method to load scores from highscores.txt file
    private void loadScores() {
        try (BufferedReader reader = new BufferedReader(new FileReader("highscores.txt"))) {
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null && i < scores.length) {
                scores[i].setText(line); // Set score text
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
