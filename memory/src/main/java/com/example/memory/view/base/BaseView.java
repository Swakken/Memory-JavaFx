package com.example.memory.view.base;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class BaseView extends BorderPane {
    private Menu menuHulp;
    private MenuItem afsluiten;

    public BaseView() {
        menuHulp = new Menu("Hulp");
        afsluiten = new MenuItem("Afsluiten");

        menuHulp.getItems().addAll(afsluiten);
        MenuBar menuBar = new MenuBar(menuHulp);
        this.setTop(menuBar);

        addEventListeners();
    }

    private void addEventListeners() {
    }

    public MenuItem getAfsluiten() {
        return afsluiten;
    }

}