package com.example.memory.view.home;

import com.example.memory.base.BasePresenter;
import com.example.memory.view.MenuBuilder;
import com.example.memory.view.MenuFactory;
import com.example.memory.view.handleiding.HandleidingPresenter;
import com.example.memory.view.handleiding.HandleidingView;
import com.example.memory.view.highscores.HighscoresPresenter;
import com.example.memory.view.highscores.HighscoresView;
import com.example.memory.view.instellingen.InstellingenPresenter;
import com.example.memory.view.instellingen.InstellingenView;
import com.example.memory.view.startspel.StartSpelPresenter;
import com.example.memory.view.startspel.StartSpelView;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;

public class HomePresenter extends BorderPane {

    private HomeView view;

    public HomePresenter(HomeView view) {
        super(view);
        this.view = view;
        this.addEventListnersStartSpel();
        this.addEventListnersHighscores();
        this.addEventListnersHandleiding();

        MenuFactory factory = new MenuFactory();
        MenuBuilder builder = factory.createDefaultBuilder(this);
        builder.build();
    }


    private void addEventListnersStartSpel() {
        this.view.getBtnStartSpel().addEventHandler(ActionEvent.ACTION, (actionEvent) -> {

            StartSpelView mijnSpelView = new StartSpelView();
            StartSpelPresenter mijnSpelPresenter = new StartSpelPresenter(mijnSpelView);

            this.view.getScene().setRoot(mijnSpelView);
        });
    }

    private void addEventListnersHighscores() {
        this.view.getBtnHighscores().addEventHandler(ActionEvent.ACTION, (actionEvent) -> {

            HighscoresView mijnHighscoresView = new HighscoresView();
            HighscoresPresenter mijnHighscoresPresenter = new HighscoresPresenter(mijnHighscoresView);

            this.view.getScene().setRoot(mijnHighscoresView);
        });
    }

    private void addEventListnersHandleiding() {
        this.view.getBtnHandleiding().addEventHandler(ActionEvent.ACTION, (actionEvent) -> {

            HandleidingView mijnHandleidingView = new HandleidingView();
            HandleidingPresenter mijnHandleidingPresenter = new HandleidingPresenter(mijnHandleidingView);

            this.view.getScene().setRoot(mijnHandleidingView);
        });
    }


    }




