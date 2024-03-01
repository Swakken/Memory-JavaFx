package com.example.memory.Schermen.highscores;

import com.example.memory.Schermen.home.HomePresenter;
import com.example.memory.Schermen.home.HomeView;
import javafx.event.ActionEvent;

public class HighscoresPresenter {

    private HighscoresView view;

    public HighscoresPresenter(HighscoresView view) {
        this.view = view;
        this.addEventListnersHomePagina();
        this.addEventListnersAfsluiten();
    }

    private void addEventListnersHomePagina() {
        this.view.getTerugButton().addEventHandler(ActionEvent.ACTION, (actionEvent) -> {

            HomeView mijnHomeView = new HomeView();
            HomePresenter mijnHomePresenter = new HomePresenter(mijnHomeView);

            this.view.getScene().setRoot(mijnHomeView);
        });
    }

    private void addEventListnersAfsluiten(){
        this.view.getAfsluiten().addEventHandler(ActionEvent.ACTION, (actionEvent) -> {
            System.exit(0);

        });
    }
}
