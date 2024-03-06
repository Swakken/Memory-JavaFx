package com.example.memory.Schermen.home;

import com.example.memory.Schermen.handleiding.HandleidingPresenter;
import com.example.memory.Schermen.handleiding.HandleidingView;
import com.example.memory.Schermen.highscores.HighscoresPresenter;
import com.example.memory.Schermen.highscores.HighscoresView;
import com.example.memory.Schermen.instellingen.InstellingenPresenter;
import com.example.memory.Schermen.instellingen.InstellingenView;
import com.example.memory.Schermen.startspel.StartSpelPresenter;
import com.example.memory.Schermen.startspel.StartSpelView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class HomePresenter {

    private HomeView view;

    public HomePresenter(HomeView view) {
        this.view = view;
        this.addEventListnersStartSpel();
        this.addEventListnersHighscores();
        this.addEventListnersHandleiding();
        this.addEventListnersAfsluiten();
        this.addEventListenersInstellingen();
    }

    private void addEventListnersStartSpel() {
        this.view.getBtnStartSpel().addEventHandler(ActionEvent.ACTION, (actionEvent) -> {

            StartSpelView mijnSpelView = new StartSpelView();
            StartSpelPresenter mijnSpelPresenter = new StartSpelPresenter(mijnSpelView);

            this.view.getScene().setRoot(mijnSpelView);
        });
    }

    private void addEventListnersHighscores() {
        this.view.getBtnHighscores().addEventHandler(ActionEvent.ACTION, (actionEvent) -> {

            HighscoresView mijnHighscoresView = new HighscoresView();
            HighscoresPresenter mijnHighscoresPresenter = new HighscoresPresenter(mijnHighscoresView);

            this.view.getScene().setRoot(mijnHighscoresView);
        });
    }

    private void addEventListnersHandleiding() {
        this.view.getBtnHandleiding().addEventHandler(ActionEvent.ACTION, (actionEvent) -> {

            HandleidingView mijnHandleidingView = new HandleidingView();
            HandleidingPresenter mijnHandleidingPresenter = new HandleidingPresenter(mijnHandleidingView);

            this.view.getScene().setRoot(mijnHandleidingView);
        });
    }

    private void addEventListnersAfsluiten() {
        this.view.getAfsluiten().addEventHandler(ActionEvent.ACTION, (actionEvent) -> {
            System.exit(0);
        });
    }

    private void addEventListenersInstellingen() {
        this.view.getInstellingen().addEventHandler(ActionEvent.ACTION, (actionEvent) -> {
            InstellingenView mijnInstellingenView = new InstellingenView();
            InstellingenPresenter mijnInstellingenPresenter = new InstellingenPresenter(mijnInstellingenView);

            // Fout met verwijzing naar InstellingenView
//            this.view.getScene().setRoot(mijnInstellingenView);
        });
    }
}