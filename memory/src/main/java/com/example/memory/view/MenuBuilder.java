package com.example.memory.view;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

/**
 * Frederic Backeljau
 * 3/15/2024
 */
public class MenuBuilder {
    private BorderPane borderPane;

    private EventHandler<ActionEvent> handlerAfsluiten;

    private EventHandler<ActionEvent> handlerInstellingen;


    public MenuBuilder(BorderPane borderPane){
        this.borderPane = borderPane;
    }

    public void addAfsluiten(EventHandler<ActionEvent> event){
        handlerAfsluiten = event;
    }

    public void addInstellingen(EventHandler<ActionEvent> event){
        handlerInstellingen = event;
    }

    public void build(){

        boolean hasHandlers = !(handlerAfsluiten == null && handlerInstellingen == null);

        if(hasHandlers)
        {
            Menu menuHulp = new Menu("Hulp");
            MenuBar menuBar = new MenuBar(menuHulp);

            if(handlerAfsluiten != null)
            {
                MenuItem menuAfsluiten = new MenuItem("Afsluiten");
                menuAfsluiten.setOnAction(handlerAfsluiten);
                menuHulp.getItems().add(menuAfsluiten);
            }

            if(handlerInstellingen != null)
            {
                MenuItem menuInstellingen = new MenuItem("Instellingen");
                menuInstellingen.setOnAction(handlerInstellingen);
                menuHulp.getItems().add(menuInstellingen);
            }

            // Set top border pane
            borderPane.setTop(menuBar);
        }

    }

}
