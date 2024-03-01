package com.example.memory.view.startspel;

import com.example.memory.view.home.HomePresenter;
import com.example.memory.view.home.HomeView;
import javafx.event.ActionEvent;

public class StartSpelPresenter {

    private StartSpelView view;

    public StartSpelPresenter(StartSpelView view) {
        this.view = view;
        this.addEventListnersHome();
    }

    private void addEventListnersHome() {
        this.view.getBtnAnnuleren().addEventHandler(ActionEvent.ACTION, (actionEvent) -> {

            HomeView mijnHomeView = new HomeView();
            HomePresenter mijnHomePresenter = new HomePresenter(mijnHomeView);

            this.view.getScene().setRoot(mijnHomeView);
        });
    }

}
