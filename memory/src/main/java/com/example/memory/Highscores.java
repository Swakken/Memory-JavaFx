package com.example.memory;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Highscores extends Application {
    public void start(Stage mijnHomeStage) throws IOException {
        //1 of meerdere Nodes aanmaken aanmaken
        Text txtTitel = new Text("Highscores");


        VBox buttonVBox = new VBox();
        buttonVBox.getChildren().add(txtTitel);


        buttonVBox.setAlignment(Pos.CENTER);
        buttonVBox.setSpacing(12);


        // FullScreen
        mijnHomeStage.setFullScreenExitHint("Highscores");
        mijnHomeStage.setFullScreen(true);

        //Scene toevoegen en pane daaraan toevoegen
        //Je hebt normaal gezien maar 1 scene
        Scene sceneButtons = new Scene(buttonVBox);
        //Scene toevoegen aan stage die je via parameter binnenkrijgt
        mijnHomeStage.setScene(sceneButtons);
        mijnHomeStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

