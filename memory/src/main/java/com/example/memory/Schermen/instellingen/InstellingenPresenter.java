package com.example.memory.Schermen.instellingen;

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

}
