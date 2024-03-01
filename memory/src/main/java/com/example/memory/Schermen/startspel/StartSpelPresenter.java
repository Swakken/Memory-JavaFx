package com.example.memory.Schermen.startspel;

import com.example.memory.Schermen.home.HomePresenter;
import com.example.memory.Schermen.home.HomeView;
import com.example.memory.Schermen.spelscherm.SpelschermPresenter;
import com.example.memory.Schermen.spelscherm.SpelschermView;
import javafx.event.ActionEvent;

public class StartSpelPresenter {

    private StartSpelView view;

    public StartSpelPresenter(StartSpelView view) {
        this.view = view;
        this.addEventListnersHome();
        this.addEventListnersSpelScherm();
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
            SpelschermPresenter mijnSpelschermPresenter = new SpelschermPresenter(mijnSpelschermView);

            this.view.getScene().setRoot(mijnSpelschermView);
        });
    }

}