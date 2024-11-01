package com.example.memory.view.handleiding;

import com.example.memory.view.base.BaseView;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;


public class HandleidingView extends BaseView {
    private Text txtTitel;
    private Button terugButton;
    private Text intro;
    private Text spelregelsTitel;
    private Text spelregels;
    private Text bedieningTitel;
    private Text bediening;


    public HandleidingView() {
        super();
        initialiseNodes();
        layoutNodes();
        this.getStylesheets().add(getClass().getResource("/styleheets/home.css").toExternalForm());
    }

    private void initialiseNodes() {
        txtTitel = new Text("Memory Handleiding");
        terugButton = new Button("Terug naar Home");
        intro = new Text("Welkom bij ons Memory Spel!");
        spelregelsTitel = new Text("Spelregels:");
        spelregels = new Text(
                "1. Alle kaarten liggen omgekeerd.\n" +
                        "2. Elke beurt mag je twee kaarten omdraaien.\n" +
                        "3. Als de kaarten overeenkomen, blijven ze omgedraaid.\n" +
                        "4. Het doel is om alle paren te vinden binnen de opgegeven tijd.\n" +
                        "5. Het spel eindigt als alle kaarten zijn omgedraaid of als de tijd verstreken is."
        );
        bedieningTitel = new Text("Bediening:");
        bediening = new Text(
                "- Gebruik de muis om kaarten te selecteren."
        );

    }

    public Button getTerugButton() {
        return terugButton;
    }

    private void layoutNodes() {
        this.getChildren().addAll(txtTitel, intro, spelregelsTitel, spelregels, bedieningTitel, bediening, terugButton);

        VBox MainVBox = new VBox(20);

        MainVBox.getChildren().addAll(txtTitel, intro, spelregelsTitel, spelregels, bedieningTitel, bediening, terugButton);
        MainVBox.setAlignment(Pos.CENTER);


        MainVBox.setBackground(new Background(new BackgroundImage(
                new Image("background.jpg"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, false, true)
        )));

        txtTitel.setId("txtTitel");
        setCenter(MainVBox);

    }
}