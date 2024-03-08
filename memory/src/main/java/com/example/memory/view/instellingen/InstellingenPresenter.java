package com.example.memory.view.instellingen;

import com.example.memory.view.home.HomePresenter;
import com.example.memory.view.home.HomeView;
import javafx.event.ActionEvent;

public class InstellingenPresenter {

    private InstellingenView view;

    public InstellingenPresenter(InstellingenView view) {
        this.view = view;
        this.addEventListnersAfsluiten();
    }

    private void addEventListnersAfsluiten() {
        this.view.getAfsluiten().addEventHandler(ActionEvent.ACTION, (actionEvent) -> {
            System.exit(0);
        });
    }

    private void addEventListnersHomePagina() {
        this.view.getTerugButton().addEventHandler(ActionEvent.ACTION, (actionEvent) -> {

            HomeView mijnHomeView = new HomeView();
            HomePresenter mijnHomePresenter = new HomePresenter(mijnHomeView);

//            this.view.getScene().setRoot(mijnHomeView);
        });
    }

}
