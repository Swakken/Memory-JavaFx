package com.example.memory.view.highscores;

import com.example.memory.base.BasePresenter;
import com.example.memory.view.home.HomePresenter;
import com.example.memory.view.home.HomeView;
import javafx.event.ActionEvent;

public class HighscoresPresenter extends BasePresenter<HighscoresView> {

    private HighscoresView view;

    public HighscoresPresenter(HighscoresView view) {
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
