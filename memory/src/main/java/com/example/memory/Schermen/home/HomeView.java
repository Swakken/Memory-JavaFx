package com.example.memory.Schermen.home;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HomeView extends BorderPane {

    private Text txtTitel;
    private Button btnStartSpel;
    private Button btnHighscores;
    private Button btnHandleiding;

    private Menu menuHulp;

    private MenuItem afsluiten;

    private MenuItem instellingen;

    public HomeView() {
        initialiseNodes();
        layoutNodes();
        this.getStylesheets().add(getClass().getResource("/styleheets/home.css").toExternalForm());

    }

    private void initialiseNodes() {
        txtTitel = new Text("Memory Homepagina");
        btnStartSpel = new Button("Start Spel");
        btnHighscores = new Button("Highscores");
        btnHandleiding = new Button("Handleiding");

        menuHulp = new Menu("Hulp");
        afsluiten = new MenuItem("Afsluiten");
        instellingen = new MenuItem("Instellingen");
    }

    public Button getBtnStartSpel() {
        return btnStartSpel;
    }

    public Button getBtnHighscores() {
        return btnHighscores;
    }

    public Button getBtnHandleiding() {
        return btnHandleiding;
    }

    public MenuItem getAfsluiten() {
        return afsluiten;
    }

    private void layoutNodes() {
        txtTitel.setFont(Font.font("Arial", 24));
        btnStartSpel.setPrefSize(200, 100);
        btnHighscores.setPrefSize(200, 100);
        btnHandleiding.setPrefSize(200, 100);

        menuHulp.getItems().addAll(afsluiten, instellingen);



        setTop(new MenuBar(menuHulp));

        VBox buttonVBox = new VBox();
        buttonVBox.getChildren().add(txtTitel);
        buttonVBox.getChildren().add(btnStartSpel);
        buttonVBox.getChildren().add(btnHighscores);
        buttonVBox.getChildren().add(btnHandleiding);

        buttonVBox.setAlignment(Pos.CENTER);
        setCenter(buttonVBox);





    }
}
