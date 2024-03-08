package com.example.memory.Schermen.spelscherm;

import com.example.memory.Schermen.home.HomePresenter;
import com.example.memory.Schermen.home.HomeView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpelschermPresenter {

    private SpelschermView view;


    public SpelschermPresenter(SpelschermView view) {
        this.view = view;
        //this.cardValuesMap = new HashMap<>();
        this.addEventListenerMenu();
        //this.initializeMemoryCards();
        this.addEventListnersAfsluiten();
    }

    private void addEventListenerMenu() {
        this.view.getBtnMenu().addEventHandler(ActionEvent.ACTION, (actionEvent) -> {
            HomeView mijnHomeView = new HomeView();
            HomePresenter mijnHomePresenter = new HomePresenter(mijnHomeView);
            this.view.getScene().setRoot(mijnHomeView);
        });
    }



    private void addEventListnersAfsluiten() {
        this.view.getAfsluiten().addEventHandler(ActionEvent.ACTION, (actionEvent) -> {
            System.exit(0);
        });
    }

    private void addEventListenersButtons(){
        List<Button> buttons = this.view.getButtons();
        // Create an event handle
        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Button button = (Button) event.getSource();
                String[] split = button.getId().split("-");

                int row = Integer.parseInt(split[0]);
                int col = Integer.parseInt(split[1]);





            }
        };

        // Attach to buttons
        for (Button b : buttons) {
            b.addEventHandler(ActionEvent.ACTION, handler);
        }

    }

}
