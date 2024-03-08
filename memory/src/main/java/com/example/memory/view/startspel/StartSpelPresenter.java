package com.example.memory.view.startspel;

import com.example.memory.view.home.HomePresenter;
import com.example.memory.view.home.HomeView;
import com.example.memory.view.spelscherm.SpelschermPresenter;
import com.example.memory.view.spelscherm.SpelschermView;
import javafx.event.ActionEvent;

public class StartSpelPresenter {

    private StartSpelView view;

    public StartSpelPresenter(StartSpelView view) {
        this.view = view;
        this.addEventListnersHome();
        this.addEventListnersSpelScherm();
        this.addEventListnersAfsluiten();
        this.enableStartButtonBasedOnNameInput();
        view.getBtnStartSpel().setDisable(view.getTxtfldSpelerNaam().getText().trim().isEmpty());
    }

    private void addEventListnersHome() {
        this.view.getBtnAnnuleren().addEventHandler(ActionEvent.ACTION, (actionEvent) -> {

            HomeView mijnHomeView = new HomeView();
            HomePresenter mijnHomePresenter = new HomePresenter(mijnHomeView);

            this.view.getScene().setRoot(mijnHomeView);
        });
    }

    private void addEventListnersSpelScherm() {
        this.view.getBtnStartSpel().addEventHandler(ActionEvent.ACTION, (actionEvent) -> {

            SpelschermView mijnSpelschermView = new SpelschermView();
//            SpelschermPresenter mijnSpelschermPresenter = new SpelschermPresenter(mijnSpelschermView);

            this.view.getScene().setRoot(mijnSpelschermView);
        });
    }
    private void addEventListnersAfsluiten(){
        this.view.getAfsluiten().addEventHandler(ActionEvent.ACTION, (actionEvent) -> {
            System.exit(0);

        });
    }

    private void enableStartButtonBasedOnNameInput() {
        view.getTxtfldSpelerNaam().textProperty().addListener((observable, oldValue, newValue) -> {
            view.getBtnStartSpel().setDisable(newValue.trim().isEmpty());
        });
    }

}
