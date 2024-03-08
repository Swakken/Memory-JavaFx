package com.example.memory.view.spelscherm;

import com.example.memory.model.Game;
import com.example.memory.view.home.HomePresenter;
import com.example.memory.view.home.HomeView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.List;

public class SpelschermPresenter {

    private Game game;

    private SpelschermView view;


    public SpelschermPresenter(SpelschermView view) {
        this.game = game;
        this.view = view;
        //this.cardValuesMap = new HashMap<>();
        this.addEventListenerMenu();
        //this.initializeMemoryCards();
        this.addEventListnersAfsluiten();

//        this.view.showBoard(game.getBoardIds());
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
