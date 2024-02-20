package com.example.memory;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Home extends Application {

    public void start(Stage mijnHomeStage) throws IOException {
        //1 of meerdere Nodes aanmaken aanmaken
        Text txtTitel = new Text("Memory Spel");
        Button btnStartSpel = new Button("Start Spel");
        Button btnHighscores = new Button("Highscores");
        Button btnHandleiding = new Button("Handleiding");
        Button btnInstellingen = new Button("Instellingen");
        Button btnAfsluiten = new Button("Afsluiten");

        btnStartSpel.setPrefSize(200,100);
        btnHighscores.setPrefSize(200,100);
        btnHandleiding.setPrefSize(200,100);
        btnInstellingen.setPrefSize(200,100);
        btnAfsluiten.setPrefSize(200,100);

        VBox buttonVBox = new VBox();
        buttonVBox.getChildren().add(txtTitel);
        buttonVBox.getChildren().add(btnStartSpel);
        buttonVBox.getChildren().add(btnHighscores);
        buttonVBox.getChildren().add(btnHandleiding);
        buttonVBox.getChildren().add(btnInstellingen);
        buttonVBox.getChildren().add(btnAfsluiten);

        buttonVBox.setAlignment(Pos.CENTER);
        buttonVBox.setSpacing(12);


        // FullScreen
        mijnHomeStage.setFullScreenExitHint("Memory");
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