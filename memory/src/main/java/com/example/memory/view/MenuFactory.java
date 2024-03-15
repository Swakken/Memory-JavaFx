package com.example.memory.view;

import javafx.application.Platform;
import javafx.scene.layout.BorderPane;

/**
 * Frederic Backeljau
 * 3/15/2024
 */
public class MenuFactory {

    public MenuBuilder createDefaultBuilder(BorderPane pane){

        MenuBuilder menuBuilder = new MenuBuilder(pane);

        menuBuilder.addAfsluiten((event) -> {
            System.exit(0);
        });

        menuBuilder.addInstellingen((event) -> {

        });

        return menuBuilder;
    }

}
