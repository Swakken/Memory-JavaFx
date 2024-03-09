package com.example.memory.view.spelscherm;

import com.example.memory.model.Cel;
import com.example.memory.model.Spel;
import com.example.memory.view.home.HomePresenter;
import com.example.memory.view.home.HomeView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.List;

public class SpelschermPresenter {

    private Spel spel;

    private SpelschermView view;


    public SpelschermPresenter(SpelschermView view, String spelerNaam) {
        this.spel = spel;
        this.view = view;
        this.addEventListenerMenu();
        this.addEventListnersAfsluiten();
        this.view.setSpelerNaam(spelerNaam);
    }

    private void initialiseerView(){
        Cel[] cellenArray = spel.getCellenArray();
        view.VulGridPane(cellenArray);

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



                // Communiceren met model

                // Ophalen id van
                int cellId = 1;

                // Update tile
                view.updateTile(row, col, cellId);

            }
        };



        // Attach to buttons
        for (Button b : buttons) {
            b.addEventHandler(ActionEvent.ACTION, handler);
        }

    }

}
