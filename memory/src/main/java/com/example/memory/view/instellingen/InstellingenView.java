package com.example.memory.view.instellingen;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
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

    private Button terugButton;

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
        terugButton = new Button("Terug naar Home");
    }

    private void layoutNodes() {
        txtTitel.setFont(Font.font("Arial", 24));

        MenuBar menuBar = new MenuBar();
        menuHulp.getItems().addAll(afsluiten, instellingen);
        menuBar.getMenus().add(menuHulp);

    }

    public Button getTerugButton() {
        return terugButton;
    }

}
