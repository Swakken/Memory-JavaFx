package com.example.memory.view.spelscherm;

import com.example.memory.model.Cel;
import com.example.memory.model.Spel;
import com.example.memory.view.home.HomePresenter;
import com.example.memory.view.home.HomeView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class SpelschermPresenter {

    private Spel spel;
    private SpelschermView view;



    public SpelschermPresenter(SpelschermView view, String spelerNaam) {
        this.spel = new Spel();
        this.view = view;
        this.addEventListenerMenu();
        this.addEventListnersAfsluiten();
        this.view.setSpelerNaam(spelerNaam);
        this.initialiseerView();
        this.addEventHandlersKaartButton();
    }

    private void initialiseerView(){
        Cel[] cellenArray = spel.getCellenArray();
        view.vulGridPane(cellenArray);
    }

    private void addEventListenerMenu() {
        this.view.getBtnMenu().addEventHandler(ActionEvent.ACTION, (actionEvent) -> {
            HomeView mijnHomeView = new HomeView();
            HomePresenter mijnHomePresenter = new HomePresenter(mijnHomeView);
            this.view.getScene().setRoot(mijnHomeView);
        });
    }

    private void addEventListnersAfsluiten() {
        this.view.getAfsluiten().addEventHandler(ActionEvent.ACTION, (actionEvent) -> {
            System.exit(0);
        });
    }

    private void addEventHandlersKaartButton(){

        // Alle kaart knoppen opvragen
        List<Button> kaartKnoppen = view.getKaartKnoppen();

        // Event handler kaart knop
        EventHandler<ActionEvent> kaartKnopEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                // Geselecteerde knop
                Button button = (Button) event.getSource();
                int id = (int)button.getUserData();

                // Geselecteerde knop draaien
                view.draaiKaart(button);

                // Communiceren met model

                if (!spel.vergelijkKaarten(id)) {
                    // Niet-matchende kaarten terug omdraaien
                    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
                        view.draaiTerugOm(spel.getEersteId(), spel.getTweedeId());
                    }));
                    timeline.play();
                } else {
                    // Matchende kaarten van het bord halen
                    view.verwijderMatch(id);
                }



            }
        };

        // Loopen door lijst
        for(Button button : kaartKnoppen)
            button.setOnAction(kaartKnopEvent);

    }







//    private void addEventListenersButtons(){
//        List<Button> buttons = this.view.getButtons();
//        // Create an event handle
//        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                Button button = (Button) event.getSource();
//                String[] split = button.getId().split("-");
//
//                int row = Integer.parseInt(split[0]);
//                int col = Integer.parseInt(split[1]);
//
//
//
//                // Communiceren met model
//
//                // Ophalen id van
//                int cellId = 1;
//
//                // Update tile
//                view.updateTile(row, col, cellId);
//
//            }
//        };
//
//
//
//        // Attach to buttons
//        for (Button b : buttons) {
//            b.addEventHandler(ActionEvent.ACTION, handler);
//        }

    }


