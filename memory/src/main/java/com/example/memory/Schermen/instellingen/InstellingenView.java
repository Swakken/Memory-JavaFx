package com.example.memory.Schermen.instellingen;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class InstellingenView {
    private Text txtTitel;

    private Menu menuHulp;
    private MenuItem afsluiten;
    private MenuItem instellingen;

    public InstellingenView() {
        initialiseNodes();
        layoutNodes();
    }

    public MenuItem getAfsluiten() {
        return afsluiten;
    }

    private void initialiseNodes() {
        txtTitel = new Text("Memory Instellingenpagina");

        menuHulp = new Menu("Hulp");
        afsluiten = new MenuItem("Afsluiten");
        instellingen = new MenuItem("Instellingen");
    }

    private void layoutNodes() {
        txtTitel.setFont(Font.font("Arial", 24));
        menuHulp.getItems().addAll(afsluiten, instellingen);
//        setTop(new MenuBar(menuHulp));

    }


}
