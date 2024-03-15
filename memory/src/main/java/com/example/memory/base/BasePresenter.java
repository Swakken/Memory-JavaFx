package com.example.memory.base;

import com.example.memory.base.BaseView;
import javafx.event.ActionEvent;

public abstract class BasePresenter<ViewType extends BaseView> {
    protected ViewType view;

    public BasePresenter(ViewType view) {
        this.view = view;
        addEventListeners();
    }

    protected void addEventListeners() {
        addEventListenersAfsluiten();
//        addEventListenersInstellingen();
    }

    private void addEventListenersAfsluiten() {
        this.view.getAfsluiten().addEventHandler(ActionEvent.ACTION, actionEvent -> System.exit(0));
    }

//    private void addEventListenersInstellingen() {
//        this.view.getInstellingen().addEventHandler(ActionEvent.ACTION, (actionEvent) -> {
//            InstellingenView mijnInstellingenView = new InstellingenView();
//            InstellingenPresenter mijnInstellingenPresenter = new InstellingenPresenter(mijnInstellingenView);
//
////             Fout met verwijzing naar InstellingenView
////            this.view.getScene().setRoot(mijnInstellingenView);
//        });
}
