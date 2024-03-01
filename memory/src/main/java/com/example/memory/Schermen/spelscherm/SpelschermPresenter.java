package com.example.memory.Schermen.spelscherm;


import com.example.memory.Schermen.home.HomePresenter;
import com.example.memory.Schermen.home.HomeView;
import javafx.event.ActionEvent;

public class SpelschermPresenter {

    private SpelschermView view;

    public SpelschermPresenter(SpelschermView view) {
        this.view = view;
        addEventListenerMenu();
    }

    private void addEventListenerMenu() {
        this.view.getBtnMenu().addEventHandler(ActionEvent.ACTION, (actionEvent) -> {

            HomeView mijnHomeView = new HomeView();
            HomePresenter mijnHomePresenter = new HomePresenter(mijnHomeView);

            this.view.getScene().setRoot(mijnHomeView);


        });

    }

}
