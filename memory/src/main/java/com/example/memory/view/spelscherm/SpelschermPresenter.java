package com.example.memory.view.spelscherm;

import com.example.memory.view.base.BasePresenter;
import com.example.memory.model.Cel;
import com.example.memory.model.Spel;
import com.example.memory.view.home.HomePresenter;
import com.example.memory.view.home.HomeView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

public class SpelschermPresenter extends BasePresenter<SpelschermView> {

    private Spel spel;
    private SpelschermView view;


    public SpelschermPresenter(SpelschermView view, String spelerNaam) {
        super(view);
        this.spel = new Spel();
        this.view = view;
        this.addEventListenerMenu();
        this.view.setSpelerNaam(spelerNaam);
        this.initialiseerView();
        this.addEventHandlersKaartButton();
        this.endGame();
    }

    private void initialiseerView() {
        Cel[] cellenArray = spel.getCellenArray();
        view.vulGridPane(cellenArray);
    }

    private void addEventListenerMenu() {
        this.view.getBtnMenu().addEventHandler(ActionEvent.ACTION, actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Spel Afsluiten");
            alert.setHeaderText("Weet je zeker dat je het spel wilt beëindigen?");
            alert.setContentText("Als het spel nog niet voltooid is zal je vooruitgang verloren gaan!");

            ButtonType jaButton = new ButtonType("Ja", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancelButton = new ButtonType("Annuleren", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(jaButton, cancelButton);

            alert.getDialogPane().getStylesheets().add(getClass().getResource("/styleheets/alert.css").toExternalForm());

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == jaButton) {
                HomeView mijnHomeView = new HomeView();
                HomePresenter mijnHomePresenter = new HomePresenter(mijnHomeView);
                this.view.getScene().setRoot(mijnHomeView);
            }
        });
    }


    private void addEventHandlersKaartButton() {
        // Alle kaart knoppen opvragen
        List<Button> kaartKnoppen = view.getKaartKnoppen();

        // Event handler kaart knop
        EventHandler<ActionEvent> kaartKnopEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                // Geselecteerde knop
                Button button = (Button) event.getSource();
                int id = (int) button.getUserData();
                button.setDisable(true);
                view.draaiKaart(button);
                // Communiceren met model
                if (!spel.vergelijkKaarten(id)) {
                    // Niet-matchende kaarten terug omdraaien
                    view.draaiTerugOm(spel.getEersteId(), spel.getTweedeId());
                    int score = view.getScore();
                    view.verminderScore(score);
                } else {
                    // Matchende kaarten van het bord halen
                    view.verwijderMatch(id);
                    int score = view.getScore();
                    view.vermeerderScore(score);

                    // Controleer of het spel voltooid is NA de match
                    if (isSpelVoltooid()) {
                        toonSpelVoltooidBericht();
                        endGame();
                    }

                    String playerName = view.getTxtSpelerNaam().getText();
                }
            }
        };

        // Loopen door lijst
        for (Button button : kaartKnoppen)
            button.setOnAction(kaartKnopEvent);
    }


    private boolean isSpelVoltooid() {
        return view.getKaartKnoppen().stream().allMatch(Node::isDisabled);
    }

    // Methode om het spel te beëindigen en scores op te slaan
    public void endGame() {
        // De score ophalen
        int score = view.getScore();

        if (score > 1) {
            String playerName = view.getTxtSpelerNaam().getText();
            saveScore(playerName, score);
        }
    }

    private void saveScore(String playerName, int score) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("highscores.txt", true))) {
            // Score en speler naam opslaan
            writer.println(playerName + ": " + score);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void toonSpelVoltooidBericht() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Spel Voltooid");
        alert.setHeaderText(null);
        alert.setContentText("Goed gedaan! Je hebt het spel voltooid, bekijk je score op het scorebord");
        alert.getDialogPane().getStylesheets().add(getClass().getResource("/styleheets/alert.css").toExternalForm());

        alert.showAndWait();
    }

}