package com.example.memory.Schermen.handleiding;

import com.example.memory.Schermen.home.HomePresenter;
import com.example.memory.Schermen.home.HomeView;
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
