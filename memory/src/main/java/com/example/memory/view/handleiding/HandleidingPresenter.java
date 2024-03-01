package com.example.memory.view.handleiding;

import com.example.memory.view.home.HomePresenter;
import com.example.memory.view.home.HomeView;
import com.example.memory.view.startspel.StartSpelPresenter;
import com.example.memory.view.startspel.StartSpelView;
import javafx.event.ActionEvent;

public class HandleidingPresenter {

    private HandleidingView view;

    public HandleidingPresenter(HandleidingView view) {
        this.view = view;
        this.addEventListnersHomePagina();
    }

    private void addEventListnersHomePagina() {
        this.view.getTerugButton().addEventHandler(ActionEvent.ACTION, (actionEvent) -> {

            HomeView mijnHomeView = new HomeView();
            HomePresenter mijnHomePresenter = new HomePresenter(mijnHomeView);

            this.view.getScene().setRoot(mijnHomeView);
        });
    }

}
