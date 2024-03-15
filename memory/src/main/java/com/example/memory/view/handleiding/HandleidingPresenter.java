package com.example.memory.view.handleiding;

import com.example.memory.base.BasePresenter;
import com.example.memory.view.highscores.HighscoresView;
import com.example.memory.view.home.HomePresenter;
import com.example.memory.view.home.HomeView;
import javafx.event.ActionEvent;

public class HandleidingPresenter extends BasePresenter<HandleidingView> {

    private HandleidingView view;

    public HandleidingPresenter(HandleidingView view) {
        super(view);
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
