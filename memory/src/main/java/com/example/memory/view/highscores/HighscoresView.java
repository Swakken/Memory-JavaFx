package com.example.memory.view.highscores;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class HighscoresView extends BorderPane {
    private Text txtTitel;
    private Text score1;
    private Text score2;
    private Text score3;
    private Text score4;
    private Text score5;
    private Button terugButton;

    private Menu menuHulp;
    private MenuItem afsluiten;
    private MenuItem instellingen;

    public HighscoresView() {
        initialiseNodes();
        layoutNodes();
        this.getStylesheets().add(getClass().getResource("/styleheets/home.css").toExternalForm());
    }

    private void initialiseNodes() {
        txtTitel = new Text("Highscores");
        score1 = new Text("1. Speler A - 100 punten");
        score2 = new Text("1. Speler A - 90 punten");
        score3 = new Text("1. Speler A - 80 punten");
        score4 = new Text("1. Speler A - 70 punten");
        score5 = new Text("1. Speler A - 60 punten");
        terugButton = new Button("Terug naar Home");

        menuHulp = new Menu("Hulp");
        afsluiten = new MenuItem("Afsluiten");
        instellingen = new MenuItem("Instellingen");
    }

    public Button getTerugButton() {
        return terugButton;
    }

    public MenuItem getAfsluiten() {
        return afsluiten;
    }

    private void layoutNodes() {
        VBox buttonVBox = new VBox();
        buttonVBox.getChildren().addAll(txtTitel, score1, score2, score3, score4, score5, terugButton);
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


        menuHulp.getItems().addAll(afsluiten, instellingen);
        setTop(new MenuBar(menuHulp));
    }
}
