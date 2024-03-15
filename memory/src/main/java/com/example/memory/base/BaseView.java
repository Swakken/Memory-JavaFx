package com.example.memory.base;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class BaseView extends BorderPane {
    private Menu menuHulp;
    private MenuItem afsluiten, instellingen;

    public BaseView() {
        menuHulp = new Menu("Hulp");
        afsluiten = new MenuItem("Afsluiten");
        instellingen = new MenuItem("Instellingen");

        menuHulp.getItems().addAll(afsluiten, instellingen);
        MenuBar menuBar = new MenuBar(menuHulp);
        this.setTop(menuBar);

        addEventListeners();
    }

    private void addEventListeners() {

    }

    public MenuItem getAfsluiten() {
        return afsluiten;
    }

    public MenuItem getInstellingen() {
        return instellingen;
    }

}
